package com.epam.order.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "tb_Order")
public class Order implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -684563182710807119L;
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	
	@Column(name = "userid")
	private String userid;
	
	@Column(name = "orderdate")
	private Date orderdate;
	
	@JsonIgnore
	@JoinColumn(name= "order_id")
	@OneToMany(cascade = CascadeType.ALL, orphanRemoval = true) 
	List<Product> orderproduct = new ArrayList<>();
	
	@OneToOne(cascade = CascadeType.ALL, orphanRemoval = true)
	private Shipping shipping;
	

	public String getUserid() {
		return userid;
	}

	public void setUserid(String userid) {
		this.userid = userid;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Date getOrderdate() {
		return orderdate;
	}

	public void setOrderdate(Date orderdate) {
		this.orderdate = orderdate;
	}

	public List<Product> getOrderproduct() {
		return orderproduct;
	}

	public void setOrderproduct(List<Product> orderproduct) {
		this.orderproduct = orderproduct;
	}

	public Shipping getShipping() {
		return shipping;
	}

	public void setShipping(Shipping shipping) {
		this.shipping = shipping;
	}

		
}
