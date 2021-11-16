package com.ventail.ecommerce.service.impl;

import com.ventail.ecommerce.api.ProductApi;
import com.ventail.ecommerce.domain.Product;
import com.ventail.ecommerce.domain.entity.ProductEntity;
import com.ventail.ecommerce.domain.entity.ProductImageEntity;
import com.ventail.ecommerce.repository.ProductImageRepository;
import com.ventail.ecommerce.repository.ProductRepository;
import com.ventail.ecommerce.service.ProductService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class ProductServiceImpl implements ProductService {
    Logger logger = LoggerFactory.getLogger(ProductService.class);

    @Autowired
    private ProductRepository productRepository;
    @Autowired
    private ProductImageRepository productImageRepository;

    @Override
    public List<Product> getAllProducts(){
//        List<ProductImageEntity> productImageEntities = productImageRepository.findAll();
        List<ProductEntity> products = productRepository.findAll();
        logger.debug(products.toString());
        List<Product> productList = new ArrayList<>();
        for(int i=0; i<products.size();i++){
            Product product = new Product(products.get(i));
            productList.add(product);
        }
        return productList;
    }

    @Override
    public List<Product> getCategoryProducts(String category){
        List<ProductEntity> categoryProducts = productRepository.findByCategory_Id(category);
        List<Product> categoryProductList = new ArrayList<>();
        for(int i=0; i<categoryProducts.size();i++){
            Product product = new Product(categoryProducts.get(i));
            categoryProductList.add(product);
        }
        return categoryProductList;
    }

    @Override
    public List<Product> getProductsByProductName(String productName) {
        List<ProductEntity> searchProducts = productRepository.findByNameLike("%" + productName + "%");
        List<Product> searchProductsList = new ArrayList<>();
        for(int i=0; i<searchProducts.size(); i++){
            Product product = new Product(searchProducts.get(i));
            searchProductsList.add(product);
        }
        return searchProductsList;
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
    public List<ProductEntity> getProductEntityByIds(List<Long> productIds){
        return productRepository.findByProductIdIn(productIds);
    }

    @Override
    public Map<Long, Product> getProductsByIds(List<Long> productIds){
        Map<Long, Product> shoppingCartItems = new HashMap<>();
        List<ProductEntity> matchProducts = getProductEntityByIds(productIds); //ask database once only
        for(int i=0; i<matchProducts.size(); i++){
            shoppingCartItems.put(matchProducts.get(i).getProductId(), new Product(matchProducts.get(i)));
        }
        return shoppingCartItems;
    }

    @Override
    public ProductEntity getProductEntityById(Long productId){
        return productRepository.findFirstByProductId(productId);
    }



}
