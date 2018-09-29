package com.jwt.impl.enums;

public enum JWTConstants {
	SECRET("jhgdjbhbsakjsdadkjbas"), EXPIRATION_TIME("50000"), USER_ID("userId"), CATEGORY("category"),
	AUTHORIZATION_HEADER("Authorization"), TOKEN("Token");

	public String getCode() {
		return code;
	}

	private String code;

	private JWTConstants(String code) {
		this.code = code;
	}
}
