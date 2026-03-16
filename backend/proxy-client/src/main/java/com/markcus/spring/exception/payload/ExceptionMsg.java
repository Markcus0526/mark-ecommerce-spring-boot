package com.markcus.spring.exception.payload;

import java.io.Serializable;
import java.time.ZonedDateTime;

import org.springframework.http.HttpStatus;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonFormat.Shape;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.datatype.jsr310.ser.ZonedDateTimeSerializer;
import com.markcus.spring.constant.AppConstant;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@AllArgsConstructor
@Data
@Builder
public final class ExceptionMsg  implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	@JsonSerialize(using = ZonedDateTimeSerializer.class)
	@JsonFormat(shape = Shape.STRING, pattern = AppConstant.ZONED_DATE_TIME_FORMAT)
	private final ZonedDateTime timestamp;
	
	@JsonInclude(value = Include.NON_NULL)
	private Throwable throwable;
	
	private final HttpStatus httpStatus;
	
	private final String msg;
	
//	public ExceptionMsg(ZonedDateTime timestamp, Throwable throwable, HttpStatus httpStatus, String msg) {
//		this.timestamp = timestamp;
//		this.throwable = throwable;
//		this.httpStatus = httpStatus;
//		this.msg = msg;
//	}
	
	public static ExceptionMsgBuilder builder() {
		return new ExceptionMsgBuilder();
	}
	
	public static class ExceptionMsgBuilder {
		private ZonedDateTime timestamp;
		private Throwable throwable;
		private HttpStatus httpStatus;
		private String msg;
		
		public ExceptionMsgBuilder timestamp(ZonedDateTime timestamp) {
			this.timestamp = timestamp;
			return this;
		}
		
		public ExceptionMsgBuilder throwable(Throwable throwable) {
			this.throwable = throwable;
			return this;
		}
		
		public ExceptionMsgBuilder httpStatus(HttpStatus httpStatus) {
			this.httpStatus = httpStatus;
			return this;
		}
		
		public ExceptionMsgBuilder msg(String msg) {
			this.msg = msg;
			return this;
		}
		
		public ExceptionMsg build() {
			return new ExceptionMsg(timestamp, throwable, httpStatus, msg);
		}
	}
}










