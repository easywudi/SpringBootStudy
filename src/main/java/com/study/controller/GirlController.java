package com.study.controller;

import java.util.List;

import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.study.domain.Girl;
import com.study.domain.Result;
import com.study.repository.GirlRepository;
import com.study.service.GirlService;
import com.study.utils.ResultUtil;

@RestController
public class GirlController {

	private final static Logger logger = LoggerFactory.getLogger(GirlController.class);
	
	@Autowired
	private GirlRepository girlRepository;
	
	@Autowired
	private GirlService girlService;
	
	@GetMapping(value = "/girls")
	public List<Girl> girlList () {
		return girlRepository.findAll();
	}
	
	@PostMapping(value = "/girls")
	public Result girlAdd(@Valid Girl girl,BindingResult result) {
		if(result.hasErrors()) {
			return  ResultUtil.error(1, result.getFieldError().getDefaultMessage());
		}
		girl.setAge(girl.getAge());
		girl.setCupSize(girl.getCupSize());
		return ResultUtil.success(girlRepository.save(girl));
	}
	
	@GetMapping(value = "/girls/{id}")
	public Girl findOneGirl(@PathVariable("id") Integer id) {
		return girlRepository.findOne(id); 
	}
	
	@PutMapping(value = "/girls/{id}")
	public Girl girlUpdate(@PathVariable("id") Integer id,
						@RequestParam("cupSize") String cupSize,
						@RequestParam("age") Integer age) {
		Girl girl = new Girl();
		girl.setId(id);
		girl.setAge(age);
		girl.setCupSize(cupSize);
		
		return girlRepository.save(girl);
	}
	
	@DeleteMapping(value = "/girls/{id}")
	public void deleteGirl(@PathVariable("id") Integer id) {
		girlRepository.delete(id);
	}
	
	@GetMapping(value = "/girls/age/{age}")
	public List<Girl> findByAge (@PathVariable("age") Integer age) {
		
		return girlRepository.findByAge(age);
	}
	
	
	@PostMapping(value = "/girls/two")
	public void girlTwo () {
		
		girlService.insertTwo();
	}
	
	@GetMapping(value = "girls/getAge/{id}")
	public void getAge(@PathVariable("id") Integer id) throws Exception {
		girlService.getAge(id);
	}
	
	
}
