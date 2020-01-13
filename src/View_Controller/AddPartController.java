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
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author Jacobi
 */
public class AddPartController implements Initializable {
    @FXML
    private RadioButton PartInHouseRB;
    
    public void InHouseRBPushed(ActionEvent event) {
        this.PartInHouseRB.setSelected(true);
        this.PartOutsourcedRB.setSelected(false);
        this.SourceDependantLabel.setText("Machine Id");
        this.SourceDependantTextField.setPromptText("Machine ID #");
    }
    
    @FXML
    private RadioButton PartOutsourcedRB;
    
    public void OutsourcedRBPushed(ActionEvent event) {
        this.PartInHouseRB.setSelected(false);
        this.PartOutsourcedRB.setSelected(true);
        this.SourceDependantLabel.setText("Company Name");
        this.SourceDependantTextField.setPromptText("Company Name");
    }
    
    @FXML
    private Button addPartCancelButton;

    
    @FXML
    private Button addPartSaveButton;
    
    public static int PartCounter = 1;
    
    public void addPartSaveButtonPushed (ActionEvent event) throws IOException {
        
        Inventory inventory = new Inventory();
        if (this.PartInHouseRB.isSelected()) {
            InHousePart newPart = new InHousePart(PartCounter++, PartName.getText(), Double.parseDouble(PartCost.getText()), Integer.parseInt(PartStock.getText()),Integer.parseInt(PartMin.getText()), Integer.parseInt(PartMax.getText()));
            inventory.addPart(newPart);
        }
        else {
            OutsourcedPart newPart = new OutsourcedPart(PartCounter++,PartName.getText(), Double.parseDouble(PartCost.getText()), Integer.parseInt(PartStock.getText()),Integer.parseInt(PartMin.getText()), Integer.parseInt(PartMax.getText()));
            inventory.addPart(newPart);
        }
        ((Stage)(((Button)event.getSource()).getScene().getWindow())).close();

    }
    
    public void addPartCancelButtonPushed (ActionEvent event) {
        ((Stage)(((Button)event.getSource()).getScene().getWindow())).close();
    }


    

    @FXML
    private TextField PartID;
    @FXML
    private TextField PartName;
    @FXML
    private TextField PartMax;
    @FXML
    private TextField PartCost;
    @FXML
    private TextField PartMin;
    @FXML
    private TextField SourceDependantTextField;
    @FXML
    private TextField PartStock;
    @FXML
    private Label SourceDependantLabel;
    
    



    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
    }
