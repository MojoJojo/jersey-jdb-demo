package com.ontarget.demo.hibernate.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

@Entity
@Table(name = "Product", uniqueConstraints = { @UniqueConstraint(columnNames = { "id" }) })
public class Product {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id", nullable = false, unique = true, length = 32)
	private int id;

	@Column(name = "name", length = 128, nullable = true)
	private String name;

	@Column(name = "price", length = 32, nullable = true)
	private float price;
	
	public Product() {
		this.name="";
		this.price=0.0F;
		
	}
	public Product(String productName, float productPrice) {
		this.name = productName;
		this.price = productPrice;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public float getPrice() {
		return price;
	}

	public void setPrice(float price) {
		this.price = price;
	}

}
