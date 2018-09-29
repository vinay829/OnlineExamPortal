package com.jwt.impl.Interceptors;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import com.jwt.impl.enums.JWTConstants;

@Component
public class JwtInterceptor implements HandlerInterceptor {

	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		String authorizationToken = request.getHeader(JWTConstants.AUTHORIZATION_HEADER.getCode());
		System.out.println("in prehandle");

		if (StringUtils.isBlank(authorizationToken) || !authorizationToken.startsWith(JWTConstants.TOKEN.getCode())) {
			response.sendError(403, "Token Not Present..");
			return false;
		}
		System.out.println(authorizationToken);
		request.setAttribute(JWTConstants.TOKEN.getCode(), authorizationToken.substring(6));
		return true;
	}

	@Override
	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
			ModelAndView modelAndView) throws Exception {
		// TODO Auto-generated method stub

		System.out.println("post handle called");
	}

}
