package com.pcservice.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pcservice.dao.ProductCatalogueDAO;
import com.pcservice.model.Product;

@Service
public class ProductCatalogueService {
	
	@Autowired
	ProductCatalogueDAO pcDao;
	
	public List<Product> getProducts(){
		return pcDao.list();	
	}
	
	public List<Product> getProductsByType(String type){
		return pcDao.getByType(type);
	}
	
	public Product getProductById(Long id){
		return pcDao.get(id);
	}

	public Product addProduct(Product product){
		return pcDao.add(product);
	}
	
	public Long remove(Long id) {
		return pcDao.remove(id);
	}

}
