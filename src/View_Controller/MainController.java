/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package View_Controller;

import Model.Inventory;
import Model.Part;
import Model.Product;
import javafx.event.ActionEvent;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
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
public class MainController implements Initializable {

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
    private TableColumn<Product, Integer> ProductCostColumn;
    
    //Search buttons/boxes
    @FXML    
    private TextField partsSearch;
    @FXML
    private Button partsSearchButton;
    @FXML
    private TextField productsSearch;
    @FXML    
    private Button partAdd;
    
    @FXML
    public void partAddButtonPushed(ActionEvent event) throws IOException {
        Parent AddPartScreen = FXMLLoader.load(getClass().getResource("AddPart.fxml"));
        Scene AddPartScene = new Scene(AddPartScreen);
        Stage AddPartStage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        AddPartStage.setScene(AddPartScene);
        AddPartStage.show();
    }
    
    @FXML
    private Button ProductsSearchButton;
    @FXML
    private Button partDelete;
    @FXML
    private Button partModify;
    @FXML
    private Button productAdd;
    
    @FXML
    public void productAddButtonPushed(ActionEvent event) throws IOException {
        Parent AddProductScreen = FXMLLoader.load(getClass().getResource("AddProduct.fxml"));
        Scene AddProductScene = new Scene(AddProductScreen);
        Stage AddProductStage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        AddProductStage.setScene(AddProductScene);
        AddProductStage.show();
    }
    @FXML
    private Button productModify;
    @FXML
    private Button productDelete;
    @FXML
    private Button mainExit;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
/*@FXML
    private TableView<Part> partsTable;
    @FXML
    private TableColumn<Part, Integer> PartID;
    @FXML
    private TableColumn<Part, String> PartName;
    @FXML
    private TableColumn<Part, Integer> PartStock;
    @FXML
    private TableColumn<Part, Integer> PartCost;
    PartID*/
    //Set up table columns
    PartIDColumn.setCellValueFactory(new PropertyValueFactory<Part, Integer>("PartID"));
    PartNameColumn.setCellValueFactory(new PropertyValueFactory<Part, String>("PartName"));
    PartStockColumn.setCellValueFactory(new PropertyValueFactory<Part, Integer>("PartStock"));
    PartCostColumn.setCellValueFactory(new PropertyValueFactory<Part, Double>("PartCost"));
    //Load in Parts
    partsTable.setItems(Inventory.allParts);
    
    }

    
}
