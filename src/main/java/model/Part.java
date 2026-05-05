/**
 * Part is my superclass for all of my other PC components.
 * In this class we set the name, category, brand, and price of our PC components.
 *
 * @author [Jean M. Alvarez Robles]
 * @version 1.0
 * @since 2026
 */
/*
 * OS: [Mac]
 * IDE: [IntelliJ]
 * Copyright : This is my own original work
 * based on specifications issued by our instructor
 * Academic Honesty: I attest that this is my original work.
 * I have not used unauthorized source code, either modified or
 * unmodified, nor used generative AI as a final draft.
 * I have not given other fellow student(s) access to my program.
 */
package model;

public class Part {
    private String name;
    private String category;
    private String brand;
    private double price;

    // Part default constructor
    public Part() {}

    // Part argument constructure
    public Part(String name, String category, String brand, double price) {
        this.name = name;
        this.category = category;
        this.brand = brand;
        this.price = price;
    }

    /**
     * getName -> returns PC Part name
     * @return name
     * */
    public String getName() {
        return name;
    }

    /**
     * getCategory -> returns PC Part category Ex.(GPU, CPU, ETC)
     * @return  category
     * */
    public String getCategory() {
        return category;
    }

    /**
     * getBrand -> return the PC Part brand
     * @return brand
     * */
    public String getBrand() {
        return brand;
    }

    /**
     * getPrice -> returns the PC Part price
     * @return price
     * */
    public double getPrice() {
        return price;
    }

    /**
     * setName
     * @param name -> sets the name for the PC Part
     * */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * setCategory
     * @param category -> sets the category for the PC Part
     * */
    public void setCategory(String category) {
        this.category = category;
    }

    /**
     * setBrand
     * @param brand -> sets the brand for the PC Part
     * */
    public void setBrand(String brand) {
        this.brand = brand;
    }

    /**
     * setPrice
     * @param price -> sets price for the PC Part*/
    public void setPrice(double price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return getCategory() + ": " + name +
                " | Brand: " + brand +
                " | Price: $" + String.format("%.2f", price);
    }
}
