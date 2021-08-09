package com.tjint.springboot.app.exception;

import com.tjint.springboot.app.api.admin.login.controller.AdminLoginApi;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice(assignableTypes = AdminLoginApi.class)
public class UserException {

	Logger logger = LoggerFactory.getLogger(getClass());

	@ResponseStatus(HttpStatus.NOT_FOUND)
	@ExceptionHandler(IllegalArgumentException.class)
	public void userExceptionHandler(IllegalArgumentException e) {
		logger.error("No Exist User!!!!!");
		e.getStackTrace();
	}
}
