package com.janus.inventory.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;


@Entity
@Table(name="warehouse", uniqueConstraints = {
@UniqueConstraint(name = "uk_warehouse_code", columnNames = "code")
    })

public class Warehouse {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message="Warehouse Name cant be empty")
    @NotNull
    private String warehouse_name;

    @Size(max=200)
    private String street;

    @Size(max=100)
    private String city;

    @Size(max=100)
    private String state;

    @Size(max=100)
    private String country;

    @Size(max=10)
    private Long zip;

    @Size(max=50)
    @NotNull
    private String code;


    public Warehouse() {
    }

    public Warehouse(Long id, String warehouse_name, String street, String city, String state, String country, Long zip, String code) {
        this.id = id;
        this.warehouse_name = warehouse_name;
        this.street = street;
        this.city = city;
        this.state = state;
        this.country = country;
        this.zip = zip;
        this.code = code;
    }

    public Warehouse(String warehouse_name, String street, String city, String state, String country, Long zip, String code) {
        this.warehouse_name = warehouse_name;
        this.street = street;
        this.city = city;
        this.state = state;
        this.country = country;
        this.zip = zip;
        this.code = code;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getWarehouse_name() {
        return warehouse_name;
    }

    public void setWarehouse_name(String warehouse_name) {
        this.warehouse_name = warehouse_name;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public Long getZip() {
        return zip;
    }

    public void setZip(Long zip) {
        this.zip = zip;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    @Override
    public String toString() {
        return "Warehouse{" +
                "id=" + id +
                ", warehouse_name='" + warehouse_name + '\'' +
                ", street='" + street + '\'' +
                ", city='" + city + '\'' +
                ", state='" + state + '\'' +
                ", country='" + country + '\'' +
                ", zip=" + zip +
                ", code='" + code + '\'' +
                '}';
    }
}
