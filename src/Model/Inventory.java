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

    public void addPart(Part part) {
        allParts.add(part);
    }

    public void addProduct(Product product) {
        allProducts.add(product);
    }

    public void lookupPart(int id) {
        allParts.get(id);
    }
    
    public void lookupProduct(int productID) {
        allProducts.get(productID);
    }

    public void deletePart(Part part) {
        allParts.remove(part);
    }

    public void deleteProduct(Product product) {
        allProducts.remove(product);
    }

    public void updatePart(Part part) {
        allParts.set(part.getId(), part);
    }


}