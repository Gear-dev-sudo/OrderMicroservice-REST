package com.Zyfi.ProductMicroservice.entity;

public class Products {
    public int id;
    public String productName;


    public int stockQuantity;
    public String description=null;

    public int getId() {
        return id;
    }

    public String getProductName() {
        return productName;
    }

    public int getStockQuantity() {
        return stockQuantity;
    }

    public String getDescription() {
        return description;
    }

    @Override
    public String toString() {
        return "Products{" +
                "id=" + id +
                ", productName='" + productName + '\'' +
                ", stockQuantity=" + stockQuantity +
                ", description='" + description + '\'' +
                '}';
    }
}
