/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jacob.clark.View_Controller;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;

/**
 * FXML Controller class
 *
 * @author Jacobi
 */
public class AddPartController implements Initializable {

    @FXML
    private Button addPartCancelButon;
    @FXML
    private RadioButton Inhiouse;
    @FXML
    private Button addPartSaveButton;
    @FXML
    private RadioButton Outsourced;
    @FXML
    private TextField ID;
    @FXML
    private TextField Name;
    @FXML
    private TextField Max;
    @FXML
    private TextField PriceCost;
    @FXML
    private TextField Min;
    @FXML
    private TextField CompanyName;
    @FXML
    private Label companyName;
    @FXML
    private TextField Inv;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
}
