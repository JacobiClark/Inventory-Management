
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package View_Controller;

import java.io.IOException;

import java.net.URL;

import java.util.ResourceBundle;

import javafx.collections.transformation.FilteredList;
import javafx.collections.transformation.SortedList;

import javafx.event.ActionEvent;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;

import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;

import javafx.stage.Stage;

import Model.Inventory;
import Model.Part;
import Model.Product;

import static Model.Product.associatedParts;
import java.util.Optional;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;

/**
 * FXML Controller class
 *
 * @author Jacobi
 */
public class AddProductController implements Initializable {
    public static int ProductCounter = 1;

    // Parts Table
    @FXML
    private TableView<Part>            unassociatedPartsTable;
    @FXML
    private TableColumn<Part, Integer> unassociatedPartIDColumn;
    @FXML
    private TableColumn<Part, String>  unassociatedPartNameColumn;
    @FXML
    private TableColumn<Part, Integer> unassociatedPartStockColumn;
    @FXML
    private TableColumn<Part, Double>  unassociatedPartCostColumn;

    // Products Table
    @FXML
    private TableView<Part>            associatedPartsTable;
    @FXML
    private TableColumn<Part, Integer> associatedPartIDColumn;
    @FXML
    private TableColumn<Part, String>  associatedParttNameColumn;
    @FXML
    private TableColumn<Part, Integer> associatedPartStockColumn;
    @FXML
    private TableColumn<Part, Double>  associatedPartCostColumn;

    // Search buttons/boxes
    @FXML
    private TextField unassociatedPartsSearch;
    @FXML
    private Button    unassociatedPartsSearchButton;
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
    private TextField ID;
    @FXML
    private Button    deleteAssociatedPartButton;
    @FXML
    private Button    saveProductButton;
    @FXML
    private Button    addAssociatedPartButton;


    @FXML
    public void addAssociatedPartButtonPushed(ActionEvent event) {
        Part selectedPart = unassociatedPartsTable.getSelectionModel().getSelectedItem();

        associatedParts.add(selectedPart);
        associatedPartsTable.setItems(associatedParts);
    }
    
    @FXML
    public void deleteAssociatedPartButtonPushed(ActionEvent event) {
        Part selectedPart = associatedPartsTable.getSelectionModel().getSelectedItem();        
        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
        alert.setTitle("Delete associated Part");
        alert.setHeaderText("Are you sure you want to delete?");
        alert.setContentText("Are you sure you want to delete this associated Part?");
        Optional<ButtonType> result = alert.showAndWait();
        if (result.get() == ButtonType.OK){
            associatedParts.remove(selectedPart);
            associatedPartsTable.setItems(associatedParts);
        }        
    }

    @FXML
    public void addProductCancelButtonPushed(ActionEvent event) {
        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
        alert.setTitle("Cancel Add Product");
        alert.setHeaderText("Are you sure you want to cancel?");
        alert.setContentText("Are you sure you want to cancel adding this product?");
        Optional<ButtonType> result = alert.showAndWait();
        if (result.get() == ButtonType.OK){
            ((Stage) (((Button) event.getSource()).getScene().getWindow())).close(); // Close the window
        }
    }

    public void addProductSaveButtonPushed(ActionEvent event) throws IOException {
        Product newProduct = new Product();

        newProduct.setID(Inventory.getProductID());
        newProduct.setName(Name.getText());
        newProduct.setPrice(Double.parseDouble(PriceCost.getText()));
        newProduct.setStock(Integer.parseInt(Inv.getText()));
        newProduct.setMin(Integer.parseInt(Min.getText()));
        newProduct.setMax(Integer.parseInt(Max.getText()));
        newProduct.getAllAssociatedParts(associatedParts);
        Inventory.addProduct(newProduct);
        ((Stage) (((Button) event.getSource()).getScene().getWindow())).close();
    }

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {

        // Initialize unassociated parts table columns
        unassociatedPartIDColumn.setCellValueFactory(new PropertyValueFactory<Part, Integer>("id"));
        unassociatedPartNameColumn.setCellValueFactory(new PropertyValueFactory<Part, String>("name"));
        unassociatedPartStockColumn.setCellValueFactory(new PropertyValueFactory<Part, Integer>("stock"));
        unassociatedPartCostColumn.setCellValueFactory(new PropertyValueFactory<Part, Double>("price"));

        // Load in Parts
        unassociatedPartsTable.setItems(Inventory.allParts);

        // Initialize associated parts table columns
        associatedPartIDColumn.setCellValueFactory(new PropertyValueFactory<Part, Integer>("id"));
        associatedParttNameColumn.setCellValueFactory(new PropertyValueFactory<Part, String>("name"));
        associatedPartStockColumn.setCellValueFactory(new PropertyValueFactory<Part, Integer>("stock"));
        associatedPartCostColumn.setCellValueFactory(new PropertyValueFactory<Part, Double>("price"));

        // Load in Products
        associatedPartsTable.setItems(associatedParts);

        // Filter the Parts
        FilteredList<Part> filteredData = new FilteredList<>(Inventory.allParts, p -> true);

        unassociatedPartsSearch.textProperty().addListener((observable, oldValue, newValue) -> {
                filteredData.setPredicate(
                    Part -> {

                    // If filter text is empty, display all parts.
                        if ((newValue == null) || newValue.isEmpty()) {
                            return true;
                        }

                        // Filter input, then compare with parts in the table
                        String lowerCaseFilter = newValue.toLowerCase();

                        if (Part.getName().toLowerCase().contains(lowerCaseFilter)) {
                            return true;    // Entered seearch matches part
                        }

                        return false;       // Part is not matched, is not displayed.
                    });
            });

        SortedList<Part> sortedData = new SortedList<>(filteredData);

        sortedData.comparatorProperty().bind(unassociatedPartsTable.comparatorProperty());
        unassociatedPartsTable.setItems(sortedData);
    }
}
