package com.ventail.ecommerce.api;

import com.ventail.ecommerce.domain.Category;
import com.ventail.ecommerce.domain.dto.response.CategoryResponseDto;
import com.ventail.ecommerce.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/public/category")
public class CategoryApi {
    @Autowired
    private CategoryService categoryService;

    @GetMapping("/all")
    public List<CategoryResponseDto> fetchAllCategories(){
        List<CategoryResponseDto> responseDtos = new ArrayList<>();
        List<Category> categories = categoryService.getAllCategories();
        for(Category category: categories){
            responseDtos.add(new CategoryResponseDto(category));
        }
        return responseDtos;
    }

}
