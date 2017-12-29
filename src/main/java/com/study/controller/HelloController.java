package com.study.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.study.domain.GirlBean;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/hello")
public class HelloController {
	
//	@Value("${capSize}")
//	private String capSize;
//	@Value("${age}")
//	private Integer age;
//	@Value("${content}")
//	private String content;
	
	@Autowired
	private GirlBean girl;
	
	
	@RequestMapping(value = "/say",method = RequestMethod.GET)
	public String say() {
		return girl.getCupSize();
	}
	

}

