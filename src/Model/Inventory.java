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
public class Inventory {
    
    public static ObservableList<Part> allParts = FXCollections.observableArrayList();
    public static ObservableList<Product> allProducts = FXCollections.observableArrayList();
    public static int partID = 1;
    public static Integer productID = 1;
    
    public Inventory() {
        
    }

    public static void addPart(Part part) {
        allParts.add(part);
        partID++;
    }

    public static void addProduct(Product product) {
        allProducts.add(product);
        productID++;
    }

    public static void lookupPart(int id) {
        allParts.get(id);
    }
    
    public static  void lookupProduct(int productID) {
        allProducts.get(productID);
    }

    public static void deletePart(Part part) {
        allParts.remove(part);
    }

    public static void deleteProduct(Product product) {
        allProducts.remove(product);
    }

    public static void updatePart(Part part) {
        allParts.set(part.getId() -2, part);
    }
    public static void printPartID(Part part) {
        System.out.print(part.getId());
    }
    
    public static int getPartID() {
        return partID;
    }
    
    public static ObservableList<Part> getAllParts() {
        return allParts;
    }
    
    public static ObservableList<Product> getAllProducts() {
        return allProducts;
    }


}