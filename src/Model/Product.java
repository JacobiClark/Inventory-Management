package Model;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

/*
* To change this license header, choose License Headers in Project Properties.
* To change this template file, choose Tools | Templates
* and open the template in the editor.
 */

/**
 *
 * @author Jacobi
 */
public class Product {
    public static ObservableList<Part> associatedParts = FXCollections.observableArrayList();
    private int                        id;
    private String                     name;
    private double                     price;
    private int                        stock;
    private int                        min;
    private int                        max;

    public Product() {
        this.id    = id;
        this.name  = name;
        this.price = price;
        this.stock = stock;
        this.min   = min;
        this.max   = max;
    }

    public void addAssociatedPart(Part part) {
        associatedParts.add(part);
    }

    public void deleteAssociatedPart(Part part) {
        associatedParts.remove(part);
    }

    public void getAllAssociatedParts(ObservableList<Part> associatedParts) {
        this.associatedParts = associatedParts;
    }

    public int getID() {
        return id;
    }

    public void setID(int id) {
        this.id = id;
    }

    public int getMax() {
        return max;
    }

    public void setMax(int max) {
        this.max = max;
    }

    public int getMin() {
        return min;
    }

    public void setMin(int min) {
        this.min = min;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getStock() {
        return stock;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }
}