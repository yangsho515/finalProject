package kr.or.ddit.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import lombok.extern.slf4j.Slf4j;

//설정 파일임을 표시
@Slf4j
@Configuration 
public class FileConfig implements WebMvcConfigurer{
	
	// 첨부파일 Root Path 경로 메모리 상수 관리

	//public static final String uploadPath = "D:\\A_TeachingMaterial\\src\\FINAL_PROJECT\\final\\upload";
	public static final String uploadPath = "D:\\resources\\upload\\";
	//public static final String addResourceLocations = "file:///D:/A_TeachingMaterial/src/FINAL_PROJECT/final/upload/";
	public static final String addResourceLocations = "file:///D:/resources/upload/";
	
	
	/*	웹 주소와 파일의 위치 매핑
	 *  주소줄에 이렇게 쓰면 /resources/upload/2024/12/11/b456e527-dc2a-4ba3-88ee-a16e82ba817d_자연인.jpg
	 *  C:/upload/2024/11/12/b456e527-dc2a-4ba3-88ee-a16e82ba817d_자연인.jpg
	 * */
	
	@Override
	public void addResourceHandlers(ResourceHandlerRegistry registry) {
		log.debug("addResourceHandlers 실행!");
		registry.addResourceHandler("/resources/upload/**")             // 웹 접근 경로 
		        .addResourceLocations(addResourceLocations);  // 서버내 실제 경로
		
		//.addResourceLocations("file:///D:/A_TeachingMaterial/src/FINAL_PROJECT/final/resources/upload/"); 
	}
	

}
