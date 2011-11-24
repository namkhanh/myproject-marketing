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
@Table(name = "order",schema= "emailmarketing")
public class Order implements Serializable{

	private Long id;
	private Integer productId;
	private Integer userId;
	private Date orderDate;
	private Date orderStatus;

	@Basic
	@Id
	@GeneratedValue
	@Column(name = "order_id")
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	@Basic
	@Column(name = "product_id")
	public Integer getProductId() {
		return productId;
	}

	public void setProductId(Integer productId) {
		this.productId = productId;
	}

	@Basic
	@Column(name = "user_id")
	public Integer getUserId() {
		return userId;
	}

	public void setUserId(Integer userId) {
		this.userId = userId;
	}

	@Basic
	@Column(name = "order_date")
	public Date getOrderDate() {
		return orderDate;
	}

	public void setOrderDate(Date orderDate) {
		this.orderDate = orderDate;
	}

	@Basic
	@Column(name = "order_status")
	public Date getOrderStatus() {
		return orderStatus;
	}

	public void setOrderStatus(Date orderStatus) {
		this.orderStatus = orderStatus;
	}

}