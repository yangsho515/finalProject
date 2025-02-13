package kr.or.ddit.security;

import java.io.IOException;

import org.springframework.security.access.AccessDeniedException;
import org.springframework.security.web.access.AccessDeniedHandler;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class CustomAccessDeniedHandler implements AccessDeniedHandler{

	@Override
	public void handle (HttpServletRequest request, HttpServletResponse response,
			AccessDeniedException accessDeniedException)throws IOException, ServletException {
		log.debug("체킁1: {}",accessDeniedException.getMessage());
		response.sendRedirect("/accessError");
	}
}


