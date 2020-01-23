package View_Controller;

import Model.InHousePart;
import Model.Inventory;
import Model.OutsourcedPart;
import Model.Part;
import java.io.IOException;
import java.net.URL;
import java.util.HashSet;
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
import javafx.scene.control.ToggleGroup;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author Jacobi
 */
public class AddPartController implements Initializable {
    @FXML
    private RadioButton PartInHouseRB;
    @FXML
    private Button addPartCancelButton;
    @FXML
    private Button addPartSaveButton;
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
    @FXML
    private RadioButton PartOutsourcedRB;
    @FXML
    private int partID = 1;
    @FXML
    private ToggleGroup sourceRadioButtons;
    
    public void InHouseRBPushed(ActionEvent event) {
        this.SourceDependantLabel.setText("Machine Id");
        this.SourceDependantTextField.setPromptText("Machine ID #");
    }

    public void OutsourcedRBPushed(ActionEvent event) {
        this.SourceDependantLabel.setText("Company Name");
        this.SourceDependantTextField.setPromptText("Company Name");
    }

    public void addPartCancelButtonPushed (ActionEvent event) {
        ((Stage)(((Button)event.getSource()).getScene().getWindow())).close();
    }

    public void addPartSaveButtonPushed (ActionEvent event) throws IOException {
        if (SourceDependantLabel.getText().equals("Machine ID")) {
            InHousePart newIhPart = new InHousePart();
            newIhPart.setId(Inventory.getPartID());
            newIhPart.setName(PartName.getText());
            newIhPart.setPrice(Double.parseDouble(PartCost.getText()));
            newIhPart.setStock(Integer.parseInt(PartStock.getText()));
            newIhPart.setMin(Integer.parseInt(PartMin.getText()));
            newIhPart.setMax(Integer.parseInt(PartMax.getText()));
            newIhPart.setMachineID(Integer.parseInt(SourceDependantTextField.getText()));
            Inventory.addPart(newIhPart);
        }
        else {
            OutsourcedPart newOSPart = new OutsourcedPart();
            newOSPart.setName(PartName.getText());
            newOSPart.setPrice(Double.parseDouble(PartCost.getText()));
            newOSPart.setStock(Integer.parseInt(PartStock.getText()));
            newOSPart.setMin(Integer.parseInt(PartMin.getText()));
            newOSPart.setMax(Integer.parseInt(PartMax.getText()));
            newOSPart.setCompanyName(SourceDependantTextField.getText());
            newOSPart.setId(Inventory.getPartID());
            Inventory.addPart(newOSPart);
        }
        ((Stage)(((Button)event.getSource()).getScene().getWindow())).close();

    }



    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        sourceRadioButtons = new ToggleGroup();
        this.PartInHouseRB.setToggleGroup(sourceRadioButtons);
        this.PartOutsourcedRB.setToggleGroup(sourceRadioButtons);
    }    
    
    }