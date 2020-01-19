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

/**
 * FXML Controller class
 *
 * @author Jacobi
 */
public class AddProductController implements Initializable {
    public static int ProductCounter = 1;
    //Parts Table
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
    @FXML
    public void addAssociatedPartButtonPushed (ActionEvent event) {
        Part selectedPart = unassociatedPartsTable.getSelectionModel().getSelectedItem();
        associatedParts.add(selectedPart);
        associatedPartsTable.setItems(associatedParts);    
    }
    public void addProductSaveButtonPushed (ActionEvent event) throws IOException {
        Inventory newInventory = new Inventory();
        Product newProduct = new Product(ProductCounter++, Name.getText(), Double.parseDouble(PriceCost.getText()), Integer.parseInt(Inv.getText()),Integer.parseInt(Min.getText()), Integer.parseInt(Max.getText()));
        newProduct.getAllAssociatedParts(associatedParts);
        newInventory.addProduct(newProduct);
        ((Stage)(((Button)event.getSource()).getScene().getWindow())).close();
        System.out.print(newProduct);

    }
    
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

    @FXML
    private void modifyProductSaveButtonPushed(ActionEvent event) {
    }

    @FXML
    private void modifyProductCancelButtonPushed(ActionEvent event) {
    }
    
    
    
    
}
