package kr.or.ddit.att.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@RequestMapping("/att")
@Controller
public class WorkReportController {
	
	@GetMapping("/attAppliSituation")
	public String BlankList() {
		return "att/attAppliSituation";
	}
//	
//	@GetMapping("/blankDetail")
//	public String BlankDetail() {
//		return "";
//	}
//	
//	@PostMapping("/blankCreate")
//	public String BlankCreate() {
//		return "";
//	}
//	
//	@PutMapping("/blankUpdate")
//	public String BlankUpdate() {
//		return "";
//	}
//	
//	@DeleteMapping("/blankDelete")
//	public String BlankDelete() {
//		return "";
//	}
	
	

}
