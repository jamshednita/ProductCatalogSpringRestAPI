package com.pcservice.model;

public class Product {
	
	private Long id;
	private String name;
	private String desc;
	private Float price;
	private String type;
	
	public Product() {
		super();
	}

	public Product(Long id, String name, String desc, Float price, String type) {
		super();
		this.id = id;
		this.name = name;
		this.desc = desc;
		this.price = price;
		this.type = type;
	}
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getDesc() {
		return desc;
	}
	public void setDesc(String desc) {
		this.desc = desc;
	}
	public Float getPrice() {
		return price;
	}
	public void setPrice(Float price) {
		this.price = price;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
}
