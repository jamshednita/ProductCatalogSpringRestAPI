package com.pcservice.dao;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.pcservice.model.Product;

@Repository
public class ProductCatalogueDAO {

	private static List<Product> products;
	{
		products = new ArrayList<Product>();
		products.add(new Product(101L, "Harry Potter", "Harry Potter Book", 540.0F, "Book"));
		products.add(new Product(102L, "Lux International", "Lux International Soap", 50.0F, "Cosmetics"));
		products.add(new Product(103L, "Cosco Football", "Cosco Football Size 5", 900.0F, "Sports"));
		products.add(new Product(103L, "Slazener Bat", "Slazener Bat Adult Size", 29000.0F, "Sports"));
	}
	
	public List<Product> list() {
		return products;
	}
	
	public Product get(Long id) {

		for (Product p : products) {
			if (p.getId().equals(id)) {
				return p;
			}
		}
		return null;
	}
	
	public Product add(Product product) {
		product.setId(System.currentTimeMillis());
		products.add(product);
		return product;
	}
	
	public Long remove(Long id) {

		for (Product p : products) {
			if (p.getId().equals(id)) {
				products.remove(p);
				return id;
			}
		}

		return null;
	}
	
	public List<Product> getByType(String type){
		List<Product> out = new ArrayList<Product>();
		
		for (Product p : products) {
			if (p.getType().equals(type)) {
				out.add(p);
			}
		}

		return out;
	}
}
