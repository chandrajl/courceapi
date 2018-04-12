package com.javalearn.controller;


import java.math.BigDecimal;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.javalearn.domain.Product;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@RestController
@RequestMapping("/product")
@Api(value="onlinestore", description="Operations pertaining to products in Online Store")
public class ProductController {

	@ApiResponses(
			value ={
					@ApiResponse(code=202, message="202 code response code"),
					@ApiResponse(code=401, message="Unauthorized Resource"),
					@ApiResponse(code=403, message="Forbidden Request"),
			})

	@ApiOperation(value = "Add a new product to the store", response=Product.class)
	@PostMapping("/details")
	public Product getProductDetails(int id,String catagary) {
		Product product=new Product();
		product.setId(id);
		product.setVersion(1.1);
		product.setPrice(new BigDecimal(100.00));
		product.setDescription(catagary);
		return product;
	}

	@ApiOperation(value="Returns Product price")
	@GetMapping("/price")
	public double getPrice(){
		return 10.00;

	}
}
