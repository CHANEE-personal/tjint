package com.tjint.springboot.app.exception;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@Slf4j
@RestControllerAdvice(annotations = RestController.class)
public class UserException {

//	@ExceptionHandler(Exception.class)
//	public void userExceptionHandler(IllegalArgumentException e) {
//		logger.error("No Exist User!!!!!");
//		e.getStackTrace();
//	}
}
