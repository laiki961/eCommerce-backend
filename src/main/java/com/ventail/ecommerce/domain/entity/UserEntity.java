package com.ventail.ecommerce.domain.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="User")
public class UserEntity {
    @Id
    @Column(name="user_id", nullable = false, updatable = false)
    private String userId;

    @Column(name="username", nullable = false, updatable = false)
    private String username;

    @Column(name="password", nullable = false, updatable = true)
    private String password;

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }


}
