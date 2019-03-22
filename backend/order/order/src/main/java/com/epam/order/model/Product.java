package com.epam.order.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "tb_product")
public class Product implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 4841554196088955013L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	
	@Column(name = "imageUrl")
	private String imageUrl;
	
	@Column(name = "price")
	private Long price;
	
	@Column(name = "totalprice")
	private Long totalprice;
	
	@Column(name = "quantity")
	private Long quantity;
	
	public Long getTotalprice() {
		return totalprice;
	}

	public void setTotalprice(Long totalprice) {
		this.totalprice = totalprice;
	}

	public Long getQuantity() {
		return quantity;
	}

	public void setQuantity(Long quantity) {
		this.quantity = quantity;
	}

	@Column(name = "title")
	private String title;
	
	
	@ManyToOne(fetch=FetchType.EAGER)
	private Order order;

	public Order getOrder() {
		return order;
	}

	public void setOrder(Order order) {
		this.order = order;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getImageUrl() {
		return imageUrl;
	}

	public void setImageUrl(String imageUrl) {
		this.imageUrl = imageUrl;
	}

	public Long getPrice() {
		return price;
	}

	public void setPrice(Long price) {
		this.price = price;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}
	
}
