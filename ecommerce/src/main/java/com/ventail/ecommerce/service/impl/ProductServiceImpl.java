package com.ventail.ecommerce.service.impl;

import com.ventail.ecommerce.domain.Product;
import com.ventail.ecommerce.domain.entity.ProductEntity;
import com.ventail.ecommerce.repository.ProductRepository;
import com.ventail.ecommerce.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class ProductServiceImpl implements ProductService {
    @Autowired
    private ProductRepository productRepository;

    @Override
    public List<Product> getAllProducts(){
        List<ProductEntity> products = productRepository.findAll();

        List<Product> productList = new ArrayList<>();
        for(int i=0; i<products.size();i++){
            Product product = new Product(products.get(i));
            productList.add(product);
        }
        return productList;
    }

//    public Product getProductDetailsV1(Long productId){
//        List<ProductEntity> products = productRepository.findAll();
//
//        //productId => roomNo?
//        for(int i=0; i<products.size(); i++){
//            if(productId.equals(products.get(i).getProductId())) {
//                //??? user click => productId
//                return new Product(products.get(i));
//            }
//        }
//        return null;
//    }

    @Override
    public Product getProductDetails(Long productId){
        return new Product(productRepository.findFirstByProductId(productId));
    }

//    public Map<Long, Product> getShoppingCartItemsV1(List<Long> productIds){
//        Map<Long, Product> shoppingCartItems = new HashMap<>();
//
//        for (int i=0; i<productIds.size(); i++){
//        Product shoppingCartItem = new Product(productRepository.findFirstByProductId(productIds.get(i))); //ask database 1 by 1
//        shoppingCartItems.put(productIds.get(i), shoppingCartItem);
//        }
//        return shoppingCartItems;
//    }

    @Override
    public Map<Long, Product> getProductsByIds(List<Long> productIds){
        Map<Long, Product> shoppingCartItems = new HashMap<>();
        List<ProductEntity> matchProducts = productRepository.findByProductIdIn(productIds); //ask database once only
        for(int i=0; i<matchProducts.size(); i++){
            shoppingCartItems.put(matchProducts.get(i).getProductId(), new Product(matchProducts.get(i)));
        }
        return shoppingCartItems;
    }



}
