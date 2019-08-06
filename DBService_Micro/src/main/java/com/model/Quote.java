package com.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.springframework.aop.framework.autoproxy.target.QuickTargetSourceCreator;

@Entity
@Table(name= "quote", catalog = "test_micro")
public class Quote {
	
	@Id
	@GeneratedValue(strategy= GenerationType.AUTO)
	@Column(name= "id")
	private Integer id;
	
	@Column(name= "username")
	private String username;
	
	@Column(name= "quote")
	private  String quote;
	
	public Quote() {
		// TODO Auto-generated constructor stub
	}
	
	public Quote(String username, String quote) {
		this.username= username;
		this.quote= quote;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getQuote() {
		return quote;
	}

	public void setQuote(String quote) {
		this.quote = quote;
	}
}
