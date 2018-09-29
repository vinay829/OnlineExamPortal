package com.jwt.impl.entities;

public class JwtRequest {

	private String userId;
	private String category;

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public JwtRequest(String userId, String category) {

		this.userId = userId;
		this.category = category;
	}

	public JwtRequest() {
		super();
	}

}
