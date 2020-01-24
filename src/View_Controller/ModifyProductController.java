/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package View_Controller;


import Model.Inventory;
import Model.Part;
import Model.Product;
import static Model.Product.associatedParts;
import java.awt.event.ActionEvent;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.collections.transformation.FilteredList;
import javafx.collections.transformation.SortedList;
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
public class ModifyProductController implements Initializable {

   @FXML
    private TableView<Part> unassociatedPartsTable;
    @FXML
    private TableColumn<Part, Integer> unassociatedPartIDColumn;
    @FXML
    private TableColumn<Part, String> unassociatedPartNameColumn;
    @FXML
    private TableColumn<Part, Integer> unassociatedPartStockColumn;
    @FXML
    private TableColumn<Part, Double> unassociatedPartCostColumn;
    
    //Products Table
    @FXML
    private TableView<Part> associatedPartsTable;
    @FXML
    private TableColumn<Part, Integer> associatedPartIDColumn;
    @FXML
    private TableColumn<Part, String> associatedParttNameColumn;
    @FXML
    private TableColumn<Part, Integer> associatedPartStockColumn;
    @FXML
    private TableColumn<Part, Double> associatedPartCostColumn;
    
    //Search buttons/boxes
    @FXML    
    private TextField unassociatedPartsSearch;
    @FXML
    private Button unassociatedPartsSearchButton;
    @FXML
    private TextField Name;
    @FXML
    private TextField ID;
    @FXML
    private TextField Max;
    @FXML
    private TextField PriceCost;
    @FXML
    private TextField Min;
    @FXML
    private TextField Inv;
    @FXML
    private Button deleteAssociatedPartButton;
    @FXML
    private Button saveProductButton;
    private Button addUnassociatedPartButton;
    
    @FXML
    private Button addAssociatedPartButton;
    
    public void setProduct(Product product) {
        Product selectedProduct = product;
        ID.setText(new String(String.valueOf(selectedProduct.getID())));
        Name.setText(new String (selectedProduct.getName()));
        Inv.setText((new String(String.valueOf(selectedProduct.getStock()))));
        PriceCost.setText(new String(String.valueOf(selectedProduct.getPrice())));
        Min.setText(new String(String.valueOf(selectedProduct.getMin())));
        Max.setText(new String(String.valueOf(selectedProduct.getMax())));
     }
    
    public void modifyProductCancelButtonPushed (ActionEvent event) {
        ((Stage)(((Button)event.getSource()).getScene().getWindow())).close();
    }

    public void modifyProductSaveButtonPushed (ActionEvent event) throws IOException {
        Product newProduct = new Product();
        newProduct.setID(Inventory.getProductID());
        newProduct.setName(Name.getText());
        newProduct.setPrice(Double.parseDouble(PriceCost.getText()));
        newProduct.setStock(Integer.parseInt(Inv.getText()));
        newProduct.setMin(Integer.parseInt(Min.getText()));
        newProduct.setMax(Integer.parseInt(Max.getText()));
        newProduct.getAllAssociatedParts(associatedParts);
        Inventory.addProduct(newProduct);
        ((Stage)(((Button)event.getSource()).getScene().getWindow())).close();
        /*if (SourceDependantLabel.getText().equals("Machine ID")) {
                InHousePart newIhPart = new InHousePart();
                newIhPart.setName(PartName.getText());
                newIhPart.setPrice(Double.parseDouble(PartCost.getText()));
                newIhPart.setStock(Integer.parseInt(PartStock.getText()));
                newIhPart.setMin(Integer.parseInt(PartMin.getText()));
                newIhPart.setMax(Integer.parseInt(PartMax.getText()));
                newIhPart.setMachineID(Integer.parseInt(SourceDependantTextField.getText()));
                newIhPart.setId(Integer.parseInt(PartID.getText()));
                Inventory.updatePart(newIhPart);
            }import Model.Inventory;*/

    }


    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        //Initialize unassociated parts table columns
    unassociatedPartIDColumn.setCellValueFactory(new PropertyValueFactory<Part, Integer>("id"));
    unassociatedPartNameColumn.setCellValueFactory(new PropertyValueFactory<Part, String>("name"));
    unassociatedPartStockColumn.setCellValueFactory(new PropertyValueFactory<Part, Integer>("stock"));
    unassociatedPartCostColumn.setCellValueFactory(new PropertyValueFactory<Part, Double>("price"));
    //Load in Parts
    unassociatedPartsTable.setItems(Inventory.allParts);
    
    //Initialize associated parts table columns
    associatedPartIDColumn.setCellValueFactory(new PropertyValueFactory<Part, Integer>("id"));
    associatedParttNameColumn.setCellValueFactory(new PropertyValueFactory<Part, String>("name"));
    associatedPartStockColumn.setCellValueFactory(new PropertyValueFactory<Part, Integer>("stock"));
    associatedPartCostColumn.setCellValueFactory(new PropertyValueFactory<Part, Double>("price"));
    //Load in Products
    associatedPartsTable.setItems(associatedParts);
    
    //Filter the Parts
    FilteredList<Part> filteredData = new FilteredList<>(Inventory.allParts, p -> true);

    unassociatedPartsSearch.textProperty().addListener((observable, oldValue, newValue) -> {
            filteredData.setPredicate(Part -> {
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
    SortedList<Part> sortedData = new SortedList<>(filteredData);
    sortedData.comparatorProperty().bind(unassociatedPartsTable.comparatorProperty());
    unassociatedPartsTable.setItems(sortedData);
    }    
    
}