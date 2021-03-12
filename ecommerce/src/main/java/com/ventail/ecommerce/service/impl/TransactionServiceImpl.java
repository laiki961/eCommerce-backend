package com.ventail.ecommerce.service.impl;

import com.ventail.ecommerce.domain.CheckoutItem;
import com.ventail.ecommerce.domain.Product;
import com.ventail.ecommerce.domain.Transaction;
import com.ventail.ecommerce.repository.ProductRepository;
import com.ventail.ecommerce.repository.TransactionProductRepository;
import com.ventail.ecommerce.repository.TransactionRepository;
import com.ventail.ecommerce.service.ProductService;
import com.ventail.ecommerce.service.TransactionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class TransactionServiceImpl implements TransactionService {
    @Autowired
    private ProductService productService;
    @Autowired
    private TransactionRepository transactionRepository;
    @Autowired
    private TransactionProductRepository transactionProductRepository;

    public void createTransaction(List<CheckoutItem> checkoutItems){
//      Transaction checkoutItem = new Transaction();

        //List<CheckoutItems> productIds -> List<ProductEntity> checkoutItems
        List<Product> items = new ArrayList<>();
        List<Long> productIds = new ArrayList<>();
        for(int i=0; i<checkoutItems.size(); i++){
            productIds.add(checkoutItems.get(i).getProductId());
        }

        Map<Long, Product> products = productService.getProductsByIds(productIds);
        //Product -> Transaction
        for (int i=0; i<products.size(); i++){

        }

    }
}
