package com.jwt.impl.Controllers;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestAttribute;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.jwt.impl.entities.JwtRequest;
import com.jwt.impl.enums.JWTConstants;
import com.jwt.impl.util.JWTHelper;

@RestController
@RequestMapping("/jwt")
public class JwtController {
	private static final Logger LOGGER = LoggerFactory.getLogger(JwtController.class);

	
	

	@RequestMapping(value = "/authenticate", method = RequestMethod.POST)
	public boolean authenticateUser(@RequestAttribute("Token") String token) {
		System.out.println("in controller");
		return JWTHelper.validateUserAuthentication(token);

	}

	@RequestMapping(value = "/generate", method = RequestMethod.POST)
	public String generateJWTToken(@RequestBody JwtRequest jwtBody) {
		return JWTHelper.generateJWT(jwtBody);

	}

}
