package com.ventail.ecommerce.domain.entity;

import javax.persistence.*;

@Entity
@Table(name="Category")
public class CategoryEntity {
    @Id
    @Column(name = "category", nullable = false)
    private String id;

    @Column(name = "name", nullable = false)
    private String name;



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
        return "CategoryEntity{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}
