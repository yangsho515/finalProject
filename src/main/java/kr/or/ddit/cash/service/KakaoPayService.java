package kr.or.ddit.cash.service;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestTemplate;

import kr.or.ddit.cash.mapper.BudgetMapper;
import kr.or.ddit.cash.mapper.CashMapper;
import kr.or.ddit.cash.vo.KakaoPayApprovalResponse;
import kr.or.ddit.cash.vo.KakaoPayReadyVO;
import kr.or.ddit.cash.vo.PaymentRequest;

public interface KakaoPayService {
	
	public static final CashMapper cashMapper = null;
	public static final BudgetMapper budgetMapper = null;
	KakaoPayReadyVO KakaoPayapproveResponse = null;
	
    String kakaoPayReady(PaymentRequest request);
    KakaoPayApprovalResponse approvePayment(String pgToken, String tid);
    
    // 필요한 다른 메서드들 선언
	static KakaoPayReadyVO kakaoPay(Map<String, Object> params) {
		HttpHeaders headers = new HttpHeaders();
        headers.set("Authorization", "KakaoAK {key}"); //발급받은 adminkey

        /*
        * 결제번호는 고유한 결제번호로 생성해줘야 한다.
        * 여기서는 임시로 그냥 KAO20230318001
        * */
        MultiValueMap<String, Object> payParams = new LinkedMultiValueMap<String, Object>();
        
        payParams.add("cid", "TC0ONETIME");
        payParams.add("partner_order_id", "KAO20230318001");
        payParams.add("partner_user_id", "kakaopayTest");
        payParams.add("item_name", params.get("item_name"));
        payParams.add("quantity", params.get("quantity"));
        payParams.add("total_amount", params.get("total_amount"));
        payParams.add("tax_free_amount", params.get("tax_free_amount"));
        payParams.add("approval_url", "http://localhost:8080/pay/success"); // 결제승인시 넘어갈 url
        payParams.add("cancel_url", "http://localhost:8080/pay/cancel"); // 결제취소시 넘어갈 url
        payParams.add("fail_url", "http://localhost:8080/pay/fail"); // 결제 실패시 넘어갈 url

        //카카오페이 결제준비 api 요청
        HttpEntity<Map> request = new HttpEntity<Map>(payParams, headers);

        RestTemplate template = new RestTemplate();
        String url = "https://kapi.kakao.com/v1/payment/ready";

        //요청결과
        KakaoPayReadyVO res = template.postForObject(url, request, KakaoPayReadyVO.class);
        
        /*
        * 요청결과에서 응답받은 tid 값을 데이터베이스에 저장하는 로직 추가
        */
        
        return res;
	}
}
