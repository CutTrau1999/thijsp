package com.example.thijsp.entity;

import com.example.thijsp.annotation.Column;
import com.example.thijsp.annotation.Entity;
import com.example.thijsp.annotation.Id;
import com.example.thijsp.util.SQLDataTypes;

@Entity(tableName = "phones")
public class Phone {
    @Id(autoIncrement = true)
    @Column(columnName = "id", columnType = SQLDataTypes.INTEGER)
    private int id;
    @Column(columnName = "name", columnType = SQLDataTypes.VARCHAR50)
    private String name;
    @Column(columnName = "brand", columnType = SQLDataTypes.VARCHAR50)
    private String brand;
    @Column(columnName = "price", columnType = SQLDataTypes.DOUBLE)
    private double price;
    @Column(columnName = "description", columnType = SQLDataTypes.VARCHAR255)
    private String description;

    public Phone(String name, String brand, String description, double price) {

        this.name = name;
        this.brand = brand;
        this.price = price;
        this.description = description;
    }




    public Phone() {
    }



    public Phone(int id, String name, String brand, String description, double price) {
        this.id = id;
        this.name = name;
        this.brand = brand;
        this.price = price;
        this.description = description;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
