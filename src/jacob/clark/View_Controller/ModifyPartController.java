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
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;

/**
 * FXML Controller class
 *
 * @author Jacobi
 */
public class ModifyPartController implements Initializable {

    @FXML
    private Button modifyPartCancelButton;
    @FXML
    private RadioButton inHouseRB;
    @FXML
    private Button modifyPartSaveButton;
    @FXML
    private RadioButton outsourcedRB;
    @FXML
    private TextField ID;
    @FXML
    private TextField Name;
    @FXML
    private TextField Max;
    @FXML
    private TextField priceCost;
    @FXML
    private TextField Min;
    @FXML
    private TextField companyName;
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
