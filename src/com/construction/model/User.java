package com.construction.model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@SuppressWarnings("serial")
@Entity
@Table(name = "user",schema= "emailmarketing")
public class User implements Serializable{

	private Long id;
	private String accountName;
	private String password;
	private String name;
	private String email;
	private String phone;
	private Long point;
	private String address;
	private String accountEnabled;
	private String accountLocked;
	private Date registerDate;

	@Basic
	@Id
	@GeneratedValue
	@Column(name = "user_id")
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	@Basic
	@Column(name = "user_account_name")
	public String getAccountName() {
		return accountName;
	}

	public void setAccountName(String accountName) {
		this.accountName = accountName;
	}

	@Basic
	@Column(name = "user_password")
	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	@Basic
	@Column(name = "user_name")
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Basic
	@Column(name = "user_email")
	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	@Basic
	@Column(name = "user_phone")
	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	@Basic
	@Column(name = "user_point")
	public Long getPoint() {
		return point;
	}

	public void setPoint(Long point) {
		this.point = point;
	}

	@Basic
	@Column(name = "user_address")
	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	@Basic
	@Column(name = "user_account_enabled")
	public String getAccountEnabled() {
		return accountEnabled;
	}

	public void setAccountEnabled(String accountEnabled) {
		this.accountEnabled = accountEnabled;
	}

	@Basic
	@Column(name = "user_account_locked")
	public String getAccountLocked() {
		return accountLocked;
	}

	public void setAccountLocked(String accountLocked) {
		this.accountLocked = accountLocked;
	}

	@Basic
	@Column(name = "user_register_date")
	public Date getRegisterDate() {
		return registerDate;
	}

	public void setRegisterDate(Date registerDate) {
		this.registerDate = registerDate;
	}

}