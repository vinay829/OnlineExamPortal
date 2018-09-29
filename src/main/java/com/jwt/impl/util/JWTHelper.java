package com.jwt.impl.util;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import java.util.Base64;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.jwt.impl.entities.JwtRequest;
import com.jwt.impl.enums.JWTConstants;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

public class JWTHelper {
	private static final Logger LOGGER = LoggerFactory.getLogger(JWTHelper.class);

	public JWTHelper() {
	}

	public static String generateJWT(JwtRequest jwtRequest) {
		Date date = new Date();
		long time = date.getTime();
		Date expirationTime = new Date(time + Long.parseLong(JWTConstants.EXPIRATION_TIME.getCode()));
		Map<String, Object> tokenData = new HashMap<String, Object>();
		tokenData.put(JWTConstants.USER_ID.getCode(), jwtRequest.getUserId());
		tokenData.put(JWTConstants.CATEGORY.getCode(), jwtRequest.getCategory());
		Claims claims = Jwts.claims(tokenData).setExpiration(expirationTime).setIssuedAt(date);
		String jwtToken = Jwts.builder().setClaims(claims).signWith(SignatureAlgorithm.HS256,
				Base64.getUrlEncoder().encode(JWTConstants.SECRET.getCode().getBytes())).compact();

		return jwtToken;
	}

	public static boolean validateUserAuthentication(String token) {
		Claims body = null;

		try {
			body = Jwts.parser().setSigningKey(Base64.getEncoder().encode(JWTConstants.SECRET.getCode().getBytes()))
					.parseClaimsJws(token).getBody();

		} catch (Throwable t) {
			LOGGER.info(t.getMessage());

		}
		if (null != body) {
			Date expiration = body.getExpiration();

			if (!expiration.before(new Date()))
				return true;

		}
		return false;

	}
}
