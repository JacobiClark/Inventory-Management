package jacob.clark.Model;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Jacobi
 */
public class OutsourcedPart extends Part {
    
    public OutsourcedPart(int id, String name, double price, int stock, int min, int max) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.stock = stock;
        this.min = min;
        this.max = max;
    }
        
    private String CompanyName;
    
    public void setCompanyName(String CompanyName) {
        this.CompanyName = CompanyName;
    }
    
    public String getCompanyName() {
        return CompanyName;
    }
}
