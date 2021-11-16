package com.ventail.ecommerce.domain;

import com.ventail.ecommerce.domain.entity.CategoryEntity;

public class Category {
    private String id;
    private String name;


    //convert categoryEntity to Category
    public Category(CategoryEntity categoryEntity) {
        this.id = categoryEntity.getId();
        this.name = categoryEntity.getName();
    }

    //convert to CategoryEntity
    public CategoryEntity toCategoryEntity(){
        CategoryEntity categoryEntity = new CategoryEntity();
        categoryEntity.setId(id);
        categoryEntity.setName(name);
        return categoryEntity;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Category{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                '}';
    }
}
