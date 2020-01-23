/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package View_Controller;

import Model.InHousePart;
import Model.Inventory;
import Model.OutsourcedPart;
import Model.Part;
import Model.Product;
import javafx.event.ActionEvent;
import java.io.IOException;
import java.net.URL;
import java.util.HashSet;
import java.util.ResourceBundle;
import javafx.collections.transformation.FilteredList;
import javafx.collections.transformation.SortedList;
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
    @FXML
    public static int selectedPartID;
    @FXML
    public static String selectedPartName;
    @FXML
    public static int selectedPartStock;
    @FXML
    public static double selectedPartPrice;
    @FXML
    public static int selectedPartMax;
    @FXML
    public static int selectedPartMin;
    @FXML
    public static int modifyPartIndex;
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
    public TextField productsSearch;
    @FXML    
    private Button partAdd;
    @FXML
    public void partAddButtonPushed(ActionEvent event) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("AddPart.fxml"));
        Parent root = (Parent) fxmlLoader.load();
        Stage stage = new Stage();
        stage.setTitle("Add New Part");
        stage.setScene(new Scene(root));  
        stage.show();
    }
    
    @FXML
    private Button partModify;
    @FXML
    public void partModifyButtonPushed(ActionEvent event) throws IOException {
        this.modifyPartIndex = partsTable.getSelectionModel().getSelectedIndex();
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("ModifyPart.fxml"));
        Parent root = (Parent) fxmlLoader.load();
        Stage stage = new Stage();
        stage.setTitle("Modify Parts");
        stage.setScene(new Scene(root));  
        stage.show();
        ModifyPartController controller = fxmlLoader.getController();
        Part selectedPart = partsTable.getSelectionModel().getSelectedItem();
        controller.setPart(selectedPart);       
        
    }
    @FXML
    private Button partDelete;


    @FXML
    private Button productAdd;
    @FXML
    public void productAddButtonPushed(ActionEvent event) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("AddProduct.fxml"));
        Parent root = (Parent) fxmlLoader.load();
        Stage stage = new Stage();
        stage.setTitle("Add New Product");
        stage.setScene(new Scene(root));  
        stage.show();
    }

    
    @FXML
    private Button productModify;
    @FXML
    public void productModifyButtonPushed(ActionEvent event) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("ModifyProduct.fxml"));
        Parent root = (Parent) fxmlLoader.load();
        Stage stage = new Stage();
        stage.setTitle("Modify Product");
        stage.setScene(new Scene(root));  
        stage.show();
    }
    
    @FXML
    private Button ProductsSearchButton;
    
    @FXML
    private Button productDelete;
    @FXML
    private Button mainExit;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        //create test IH and OS parts
        InHousePart sampleIH = new InHousePart();
        sampleIH.setId(Inventory.getPartID());
        sampleIH.setName("IH");
        sampleIH.setStock(55);
        sampleIH.setMax(99);
        sampleIH.setMin(2);
        sampleIH.setMachineID(22);
        Inventory.addPart(sampleIH);
        OutsourcedPart sampleOS = new OutsourcedPart();
        sampleOS.setId(Inventory.getPartID());
        sampleOS.setName("IH");
        sampleOS.setStock(55);
        sampleOS.setMax(99);
        sampleOS.setMin(2);
        sampleOS.setCompanyName("bruh");
        Inventory.addPart(sampleOS);
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
    //Load in Parts
    productsTable.setItems(Inventory.allProducts);
    
    //Filter the Parts
    FilteredList<Part> filteredParts = new FilteredList<>(Inventory.allParts, p -> true);
    FilteredList<Product> filteredProducts = new FilteredList<>(Inventory.allProducts, p -> true);

    partsSearch.textProperty().addListener((observable, oldValue, newValue) -> {
            filteredParts.setPredicate(Part -> {
                // If filter text is empty, display all persons.
                if (newValue == null || newValue.isEmpty()) {
                    return true;
                }
                
                // Compare first name and last name of every person with filter text.
                String lowerCaseFilter = newValue.toLowerCase();
                
                if (Part.getName().toLowerCase().contains(lowerCaseFilter)) {
                    return true; // Filter matches first name.
                }
                return false; // Does not match.
            });
        });
    SortedList<Part> sortedDataPart = new SortedList<>(filteredParts);
    sortedDataPart.comparatorProperty().bind(partsTable.comparatorProperty());
    partsTable.setItems(sortedDataPart);
    
    //filter the products
    productsSearch.textProperty().addListener((observable, oldValue, newValue) -> {
            filteredProducts.setPredicate(Product -> {
                // If filter text is empty, display all persons.
                if (newValue == null || newValue.isEmpty()) {
                    return true;
                }
                
                // Compare first name and last name of every person with filter text.
                String lowerCaseFilter = newValue.toLowerCase();
                
                if (Product.getName().toLowerCase().contains(lowerCaseFilter)) {
                    return true; // Filter matches first name.
                }
                return false; // Does not match.
            });
        });
    SortedList<Product> sortedDataProduct = new SortedList<>(filteredProducts);
    sortedDataProduct.comparatorProperty().bind(productsTable.comparatorProperty());
    productsTable.setItems(sortedDataProduct);
    }
}
