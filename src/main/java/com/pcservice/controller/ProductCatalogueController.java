package com.pcservice.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.pcservice.dao.ProductCatalogueDAO;
import com.pcservice.model.Product;
import com.pcservice.service.ProductCatalogueService;

@RestController
public class ProductCatalogueController {
	
	@Autowired
	ProductCatalogueService pcService;
	
	@RequestMapping(value = "/products", method = RequestMethod.GET, produces = "application/json")
	@ResponseBody
	public List<Product> getProducts() {
		System.out.println("#### Inside getProducts() ####");
		return pcService.getProducts();
	}
	
	@RequestMapping(value = "/productsByType/{type}", method = RequestMethod.GET, produces = "application/json")
	@ResponseBody
	public List<Product> getProductsByType(@PathVariable("type") String type) {
		System.out.println("#### Inside getProductsByType ####");
		return pcService.getProductsByType(type);
	}
	
	@GetMapping("/products/{id}")
	public ResponseEntity getProductById(@PathVariable("id") Long id) {
		System.out.println("#### Inside getProductById ####");
		Product product = pcService.getProductById(id);
		if (product == null) {
			return new ResponseEntity("No Product found for ID " + id, HttpStatus.NOT_FOUND);
		}

		return new ResponseEntity(product, HttpStatus.OK);
	}
	
	@PostMapping(value = "/addProduct")
	public ResponseEntity addProduct(@RequestBody Product product) {
		System.out.println("#### Inside addProduct ####");
		pcService.addProduct(product);

		return new ResponseEntity(product, HttpStatus.OK);
	}
	
	@DeleteMapping("/removeProduct/{id}")
	public ResponseEntity removeProduct(@PathVariable Long id) {
		System.out.println("#### Inside removeProduct ####");
		if (null == pcService.remove(id)) {
			return new ResponseEntity("No Product found for ID " + id, HttpStatus.NOT_FOUND);
		}

		return new ResponseEntity(id, HttpStatus.OK);
	}
	
}
