/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jacob.clark.View_Controller;

import jacob.clark.Model.Part;
import jacob.clark.Model.Product;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;

/**
 * FXML Controller class
 *
 * @author Jacobi
 */
public class MainController implements Initializable {

    //Parts Table
    @FXML
    private TableView<Part> partsTable;
    @FXML
    private TableColumn<Part, Integer> PartID;
    @FXML
    private TableColumn<Part, String> PartName;
    @FXML
    private TableColumn<Part, Integer> PartStock;
    @FXML
    private TableColumn<Part, Integer> PartCost;
    
    //Products Table
    private TableView<Product> productsTable;
    @FXML
    private TableColumn<Product, Integer> ProductID;
    @FXML
    private TableColumn<Product, String> ProductName;
    @FXML
    private TableColumn<Product, Integer> ProductStock;
    @FXML
    private TableColumn<Product, Integer> ProductCost;
    
    //Search buttons/boxes
    @FXML    
    private TextField partsSearch;
    @FXML
    private Button partsSearchButton;
    @FXML
    private TextField productsSearch;
    @FXML
    private Button productsSearchButton;
    
    @FXML    
    private Button partAdd;
    @FXML
    private Button partDelete;
    @FXML
    private Button partModify;
    @FXML
    private Button productsAdd;
    @FXML
    private Button productsModify;
    @FXML
    private Button productsDelete;
    @FXML
    private Button mainExit;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
}
