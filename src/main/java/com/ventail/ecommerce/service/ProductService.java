package com.ventail.ecommerce.service;

import com.ventail.ecommerce.domain.Product;

import java.util.List;
import java.util.Map;

public interface ProductService {
    List<Product> getAllProducts();
    Product getProductDetails(Long productId);
    Map<Long, Product> getProductsByIds(List<Long> productIds);

}
