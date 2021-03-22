package com.ventail.ecommerce.api;

import com.ventail.ecommerce.domain.Product;
import com.ventail.ecommerce.dto.response.ProductResponseDto;
import com.ventail.ecommerce.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/product")
public class ProductApi {
    @Autowired
    private ProductService productService;

    @GetMapping("/all")
    public List<ProductResponseDto> fetchAllProducts(){
        List<ProductResponseDto> responseDtos = new ArrayList<>();
        List<Product> products = productService.getAllProducts();
        for(int i=0; i<products.size(); i++){
            ProductResponseDto dto = new ProductResponseDto(products.get(i));
            responseDtos.add(dto);
        }
        return responseDtos;
    }

    @GetMapping("/details")
    public ProductResponseDto fetchProductDetails(@RequestParam("productId") Long productId){
        Product product = productService.getProductDetails(productId);
        return new ProductResponseDto(product);
    }

//    Version 1
//    @PostMapping("/productByIds")
//    public Map<Long, ProductResponseDto> fetchProductByIds(@RequestBody List<Long> productIds){
//        Map<Long, ProductResponseDto> dtoMap = new HashMap<>();
//        Map<Long, Product> products = productService.getProductsByIds(productIds);
//        for(int i=0; i<productIds.size(); i++){
//            Long productId = productIds.get(i);
//            Product productItem = products.get(productId);
//            ProductResponseDto dto = new ProductResponseDto(productItem);
//            dtoMap.put(productId, dto);
//        }
//        return dtoMap;
//    }

    //Version 2
    @PostMapping("/byIds")
    public Map<Long, ProductResponseDto> fetchProductByIds(@RequestBody List<Long> productIds){
        Map<Long, ProductResponseDto> dtoMap = new HashMap<>();
        Map<Long, Product> products = productService.getProductsByIds(productIds);
        for(Product productItem: products.values()){
            ProductResponseDto dto = new ProductResponseDto(productItem);
            dtoMap.put(productItem.getProductId(), dto);
        }
        return dtoMap;
    }



}
