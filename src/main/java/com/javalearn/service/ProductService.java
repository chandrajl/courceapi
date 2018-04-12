package com.javalearn.service;

import com.javalearn.domain.Product;

public interface ProductService {

	Iterable<Product> listAllProducts();

    Product getProductById(Integer id);

    Product saveProduct(Product product);

    void deleteProduct(Integer id);
}
