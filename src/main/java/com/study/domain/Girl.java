package com.study.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Min;

@Entity
@Table(name = "girl")
public class Girl {

	@Id
	@GeneratedValue
	@Column(name = "ID")
	private Integer id;
	@Column(name = "CUP_SIZE")
	private String cupSize;
	@Column(name = "AGE") 
	@Min(value = 18,message = "未成年禁止入内")
	private Integer age;
	
	
	
	@Override
	public String toString() {
		return "Girl [id=" + id + ", cupSize=" + cupSize + ", age=" + age + "]";
	}

	public Girl(Integer id, String cupSize, Integer age) {
		super();
		this.id = id;
		this.cupSize = cupSize;
		this.age = age;
	}
	
	public Girl(){
		
	}
	
	public Girl(String cupSize, Integer age) {
		super();
		this.cupSize = cupSize;
		this.age = age;
	}

	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getCupSize() {
		return cupSize;
	}
	public void setCupSize(String cupSize) {
		this.cupSize = cupSize;
	}
	public Integer getAge() {
		return age;
	}
	public void setAge(Integer age) {
		this.age = age;
	}
	
	
	
}
