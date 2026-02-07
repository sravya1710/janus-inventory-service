package com.janus.inventory.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

@Entity
@Table(name="product",
        uniqueConstraints = {
                @UniqueConstraint(name = "uk_product_sku", columnNames = "sku")
        })

public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message="Product Name cant be empty")
    @Column(nullable=false)
    private String product_name;

    @Size(max=100)
    private String category;

    @NotNull
    @Column(nullable=false)
    private double unit_cost;

    @NotBlank
    @Column(nullable=false,length=20)
    private String unit_of_measure;

    @NotBlank(message="SKU Cannot be empty")
    @Size(max=64)
    @Column(nullable=false)
    private String sku;


    public Product() {
    }

    public Product(String product_name, String category, double unit_cost, String unit_of_measure, String sku) {
        this.product_name = product_name;
        this.category = category;
        this.unit_cost = unit_cost;
        this.unit_of_measure = unit_of_measure;
        this.sku = sku;
    }

    public Product(String unit_of_measure, Long id, String product_name, String category, double unit_cost, String sku) {
        this.unit_of_measure = unit_of_measure;
        this.id = id;
        this.product_name = product_name;
        this.category = category;
        this.unit_cost = unit_cost;
        this.sku = sku;
    }

    public String getSku() {
        return sku;
    }

    public void setSku(String sku) {
        this.sku = sku;
    }

    public String getUnit_of_measure() {
        return unit_of_measure;
    }

    public void setUnit_of_measure(String unit_of_measure) {
        this.unit_of_measure = unit_of_measure;
    }

    public double getUnit_cost() {
        return unit_cost;
    }

    public void setUnit_cost(double unit_cost) {
        this.unit_cost = unit_cost;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getProduct_name() {
        return product_name;
    }

    public void setProduct_name(String product_name) {
        this.product_name = product_name;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "Product{" +
                "id=" + id +
                ", product_name='" + product_name + '\'' +
                ", category='" + category + '\'' +
                ", unit_cost=" + unit_cost +
                ", unit_of_measure='" + unit_of_measure + '\'' +
                ", sku='" + sku + '\'' +
                '}';
    }
}
