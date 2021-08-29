package com.tjint.springboot.app.exception;

import com.tjint.springboot.app.apiEnum.ExceptionEnum;
import lombok.Getter;

@Getter
public class ApiException extends RuntimeException{
	private ExceptionEnum error;

	public ApiException(ExceptionEnum e) {
		super(e.getMessage());
		this.error = e;
	}
}
