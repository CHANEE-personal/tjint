package com.tjint.springboot.app.apiEnum;

public enum StatusEnum {

	BRAND("brand"),
	NEWS("news");

	private String status;

	StatusEnum(String status) {
		this.status = status;
	}
}
