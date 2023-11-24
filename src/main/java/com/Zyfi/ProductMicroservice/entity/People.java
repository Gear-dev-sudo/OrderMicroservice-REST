package com.Zyfi.ProductMicroservice.entity;

import jakarta.persistence.Entity;


public class People {
    public int id;
    public String username;

    public String password;
    public String role;

    public int getId() {
        return id;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    public String getRole() {
        return role;

    }

    @Override
    public String toString() {
        return "People{" +
                "id=" + id +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", role='" + role + '\'' +
                '}';
    }
}
