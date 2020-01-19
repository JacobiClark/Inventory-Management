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
    public static int idCounter = 1;
    
    public void InHouseRBPushed(ActionEvent event) {
        this.PartInHouseRB.setSelected(true);
        this.PartOutsourcedRB.setSelected(false);
        this.SourceDependantLabel.setText("Machine Id");
        this.SourceDependantTextField.setPromptText("Machine ID #");
    }

    public void OutsourcedRBPushed(ActionEvent event) {
        this.PartInHouseRB.setSelected(false);
        this.PartOutsourcedRB.setSelected(true);
        this.SourceDependantLabel.setText("Company Name");
        this.SourceDependantTextField.setPromptText("Company Name");
    }

    public void addPartCancelButtonPushed (ActionEvent event) {
        ((Stage)(((Button)event.getSource()).getScene().getWindow())).close();
    }

    public void addPartSaveButtonPushed (ActionEvent event) throws IOException {
        Inventory inventory = new Inventory();
        if (SourceDependantLabel.getText().equals("Machine ID")) {
            InHousePart newIhPart = new InHousePart();
            newIhPart.setName(PartName.getText());
            newIhPart.setPrice(Double.parseDouble(PartCost.getText()));
            newIhPart.setStock(Integer.parseInt(PartStock.getText()));
            newIhPart.setMin(Integer.parseInt(PartMin.getText()));
            newIhPart.setMax(Integer.parseInt(PartMax.getText()));
            newIhPart.setMachineID(Integer.parseInt(SourceDependantTextField.getText()));
            newIhPart.setId(idCounter++);
            inventory.addPart(newIhPart);
        }
        else {
            OutsourcedPart newOSPart = new OutsourcedPart();
            newOSPart.setName(PartName.getText());
            newOSPart.setPrice(Double.parseDouble(PartCost.getText()));
            newOSPart.setStock(Integer.parseInt(PartStock.getText()));
            newOSPart.setMin(Integer.parseInt(PartMin.getText()));
            newOSPart.setMax(Integer.parseInt(PartMax.getText()));
            newOSPart.setCompanyName(SourceDependantTextField.getText());
            newOSPart.setId(idCounter++);
            inventory.addPart(newOSPart);
        }
        ((Stage)(((Button)event.getSource()).getScene().getWindow())).close();

    }



    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        this.PartInHouseRB.setSelected(true);
        this.PartOutsourcedRB.setSelected(false);
        this.SourceDependantLabel.setText("Machine Id");
        this.SourceDependantTextField.setPromptText("Machine ID #");
    }    
    
    }