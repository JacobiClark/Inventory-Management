/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package View_Controller;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;

/**
 * FXML Controller class
 *
 * @author Jacobi
 */
public class ModifyProductController implements Initializable {

    @FXML
    private TableView<?> modifyProductTable;
    @FXML
    private TextField productSearch;
    @FXML
    private Button productSearchButton;
    @FXML
    private Button addProductButton;
    @FXML
    private TextField Name;
    @FXML
    private TextField Max;
    @FXML
    private TextField PriceCost;
    @FXML
    private TextField Min;
    @FXML
    private TextField Inv;
    @FXML
    private TableView<?> deleteProductTable;
    @FXML
    private Button deleteProductButton;
    @FXML
    private Button saveProductButton;
    @FXML
    private Button cancelProductButton;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
}
