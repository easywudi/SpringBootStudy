package com.study.exception;

//import static org.hamcrest.CoreMatchers.instanceOf;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import com.study.domain.Result;
import com.study.utils.ResultUtil;

@ControllerAdvice
public class ExceptionHandle {
	
	private final static Logger log = LoggerFactory.getLogger(ExceptionHandle.class);

	@ExceptionHandler(value = Exception.class)
	@ResponseBody
	public Result handle (Exception e) {
		if(e instanceof GirlException ) {
			GirlException gx = (GirlException) e;
			return ResultUtil.error(gx.getCode(), gx.getMessage());
		}
		log.error("[系统错误]{}",e);
		return ResultUtil.error(0000, "unknow Exception" );
	}
	
}
