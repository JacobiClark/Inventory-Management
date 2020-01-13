/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package View_Controller;

import Model.Inventory;
import Model.Part;
import Model.Product;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author Jacobi
 */
public class AddProductController implements Initializable {
    //Parts Table
    @FXML
    private TableView<Part> partsTable;
    @FXML
    private TableColumn<Part, Integer> PartIDColumn;
    @FXML
    private TableColumn<Part, String> PartNameColumn;
    @FXML
    private TableColumn<Part, Integer> PartStockColumn;
    @FXML
    private TableColumn<Part, Double> PartCostColumn;
    
    //Products Table
    @FXML
    private TableView<Product> productsTable;
    @FXML
    private TableColumn<Product, Integer> ProductIDColumn;
    @FXML
    private TableColumn<Product, String> ProductNameColumn;
    @FXML
    private TableColumn<Product, Integer> ProductStockColumn;
    @FXML
    private TableColumn<Product, Double> ProductCostColumn;
    
    //Search buttons/boxes
    @FXML    
    private TextField partsSearch;
    @FXML
    private Button partsSearchButton;
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
    private Button deleteProductButton;
    @FXML
    private Button saveProductButton;
    
    @FXML
    private Button cancelProductButton;
    public void addProductCancelButtonPushed (ActionEvent event) {
        ((Stage)(((Button)event.getSource()).getScene().getWindow())).close();
    }

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
    
    //Initialize part table columns
    PartIDColumn.setCellValueFactory(new PropertyValueFactory<Part, Integer>("id"));
    PartNameColumn.setCellValueFactory(new PropertyValueFactory<Part, String>("name"));
    PartStockColumn.setCellValueFactory(new PropertyValueFactory<Part, Integer>("stock"));
    PartCostColumn.setCellValueFactory(new PropertyValueFactory<Part, Double>("price"));
    //Load in Parts
    partsTable.setItems(Inventory.allParts);
    
    //Initialize product table columns
    ProductIDColumn.setCellValueFactory(new PropertyValueFactory<Product, Integer>("id"));
    ProductNameColumn.setCellValueFactory(new PropertyValueFactory<Product, String>("name"));
    ProductStockColumn.setCellValueFactory(new PropertyValueFactory<Product, Integer>("stock"));
    ProductCostColumn.setCellValueFactory(new PropertyValueFactory<Product, Double>("price"));
    //Load in Products
    productsTable.setItems(Inventory.allProducts);
    
    
    
    
    }
    
    
    
    
}
