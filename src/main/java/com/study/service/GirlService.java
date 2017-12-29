package com.study.service;

import com.study.domain.Girl;
import com.study.exception.GirlException;
import com.study.repository.GirlRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
public class GirlService {
	
	@Autowired
	private GirlRepository girlRepository;
	
	@Transactional
	public void insertTwo() {
		Girl g1 = new Girl("F",20);
		girlRepository.save(g1);
		Girl g2 = new Girl("EEEEEEEEEEEEEEE",21);
		girlRepository.save(g2);
	}
	
	
	public void getAge(Integer id) throws Exception {
		Girl girl = girlRepository.findOne(id);
		Integer age = girl.getAge();
		if(age < 10) {
			throw new GirlException(10,"");
		} else if(age >10 && age < 16) {
			throw new GirlException(16,"");
		}
	}
	
	public Girl findOne (Integer id) {
		return girlRepository.findOne(id);
	}

}
