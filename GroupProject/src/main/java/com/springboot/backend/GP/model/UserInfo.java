package com.springboot.backend.GP.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.springboot.backend.GP.enums.AccountType;
@Entity
@Table(name = "userinfo")
public class UserInfo {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	
	@Column
	private String Username;
	
	@Column
	private String Password;
	
	@Column
	private AccountType accountType;

	public UserInfo() {
		super();
		// TODO Auto-generated constructor stub
	}

	public UserInfo(Long id, String username, String password, AccountType accountType) {
		super();
		this.id = id;
		Username = username;
		Password = password;
		this.accountType = accountType;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getUsername() {
		return Username;
	}

	public void setUsername(String username) {
		Username = username;
	}

	public String getPassword() {
		return Password;
	}

	public void setPassword(String password) {
		Password = password;
	}

	public AccountType getAccountType() {
		return accountType;
	}

	public void setAccountType(AccountType accountType) {
		this.accountType = accountType;
	}

	@Override
	public String toString() {
		return "UserInfo [id=" + id + ", Username=" + Username + ", Password=" + Password + ", accountType="
				+ accountType + "]";
	}
	
}
