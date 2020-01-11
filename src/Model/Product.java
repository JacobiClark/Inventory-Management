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
    private int id;
    private String name;
    private double price;
    private int stock;
    private int min;
    private int max;
    
    public Product (int id, String name, double price, int stock, int min, int max){
        this.id = id;
        this.name = name;
        this.price = price;
        this.stock = stock;
        this.min = min;
        this.max = max;
    }
    
    public static ObservableList<Part> associatedParts = FXCollections.observableArrayList();
    
    public void setID(int id){
        this.id = id;
    }
    
    public void setName(String Name){
        this.name = name;
    }
    
    public void setPrice(double price){
        this.price = price;
    }
    
    public void setStock(int stock){
        this.stock = stock;
    }
    
    public void setMin(int min){
        this.min = min;
    }
    
    public void setMax(int max){
        this.max = max;
    }

    public int getID(){
        return id;
    }
    
    public String getName(){
        return name;
    }
    
    public double getPrice(){
        return price;
    }
    
    public int getStock(){
        return stock;
    }
    
    public int getMin(){
        return min;
    }
    
    public int getMax(){
        return max;
    }
    
    public void addAssociatedPart(Part part){
        associatedParts.add(part);
    }
    
    public void deleteAssociatedPart(Part part){
        associatedParts.remove(part);
    }
    
    /*public ObservableList<Part> getAllAssociatedParts(){
        
    }*/
    
/*
    setID setName setPrice setStock setMin setMax
setPrice getID getName getPrice getStock getMin getMax
addAssociatedPart delete** getAll**s*/

}