package com.markcus.spring.exception;

import java.time.ZoneId;
import java.time.ZonedDateTime;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.validation.BindException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.markcus.spring.exception.payload.ExceptionMsg;
import com.markcus.spring.exception.wrapper.CredentialNotFoundException;
import com.markcus.spring.exception.wrapper.FavouriteNotFoundException;
import com.markcus.spring.exception.wrapper.UserObjectNotFoundException;
import com.markcus.spring.exception.wrapper.VerificationTokenNotFoundException;

import feign.FeignException;
import feign.FeignException.FeignClientException;
import feign.FeignException.FeignServerException;

@ControllerAdvice
public class ApiExceptionHandler {
	
	private static final Logger log = LoggerFactory.getLogger(ApiExceptionHandler.class);
	
	@ExceptionHandler(value = {
		FeignClientException.class,
		FeignServerException.class,
		FeignException.class
	})
	public <T extends FeignException> ResponseEntity<ExceptionMsg> handleProxyException(final T e) {
		
		log.info("**ApiExceptionHandler controller, handle feign proxy exception*\n");
		final var badRequest = HttpStatus.BAD_REQUEST;
		
		return new ResponseEntity<>(
				ExceptionMsg.builder()
					.msg(e.contentUTF8())
					.httpStatus(badRequest)
					.timestamp(ZonedDateTime
							.now(ZoneId.systemDefault()))
					.build(), badRequest);
	}
	
	@ExceptionHandler(value = {
		MethodArgumentNotValidException.class,
		HttpMessageNotReadableException.class
	})
	public <T extends BindException> ResponseEntity<ExceptionMsg> handleValidationException(final T e) {
		
		log.info("**ApiExceptionHandler controller, handle validation exception*\n");
		final var badRequest = HttpStatus.BAD_REQUEST;
		
		return new ResponseEntity<>(
				ExceptionMsg.builder()
					.msg(e.getBindingResult().getFieldError().getDefaultMessage())
					.httpStatus(badRequest)
					.timestamp(ZonedDateTime
							.now(ZoneId.systemDefault()))
					.build(), badRequest);
	}
	
	@ExceptionHandler(value = {
		UserObjectNotFoundException.class,
		CredentialNotFoundException.class,
		VerificationTokenNotFoundException.class,
		FavouriteNotFoundException.class,
		IllegalStateException.class,
	})
	public <T extends RuntimeException> ResponseEntity<ExceptionMsg> handleApiRequestException(final T e) {
		
		log.info("**ApiExceptionHandler controller, handle API request*\n");
		final var badRequest = HttpStatus.BAD_REQUEST;
		
		return new ResponseEntity<>(
				ExceptionMsg.builder()
					.msg(e.getMessage())
					.httpStatus(badRequest)
					.timestamp(ZonedDateTime
							.now(ZoneId.systemDefault()))
					.build(), badRequest);
	}
	
	
	
}










