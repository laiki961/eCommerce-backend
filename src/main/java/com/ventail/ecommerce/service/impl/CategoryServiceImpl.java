package com.ventail.ecommerce.service.impl;

import com.ventail.ecommerce.domain.Category;
import com.ventail.ecommerce.domain.Product;
import com.ventail.ecommerce.domain.entity.CategoryEntity;
import com.ventail.ecommerce.repository.CategoryRepository;
import com.ventail.ecommerce.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CategoryServiceImpl implements CategoryService {
    @Autowired
    private CategoryRepository categoryRepository;

    @Override
    public List<Category> getAllCategories() {
        List<CategoryEntity> categoryEntities = categoryRepository.findAll();
        List<Category> categorytList = new ArrayList<>();
        for(int i=0; i<categoryEntities.size();i++){
            Category category = new Category(categoryEntities.get(i));
            categorytList.add(category);
        }
        return categorytList;
    }
}
