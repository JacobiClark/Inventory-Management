package Model;

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
    public String CompanyName;

    public OutsourcedPart() {
        super();

        String CompanyName;
    }

    public String getCompanyName() {
        return CompanyName;
    }

    public void setCompanyName(String CompanyName) {
        this.CompanyName = CompanyName;
    }
}
