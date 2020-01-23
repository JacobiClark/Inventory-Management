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
public class ModifyPartController implements Initializable {
    @FXML
    private RadioButton PartInHouseRB;
    @FXML
    private Button modifyPartCancelButton;
    @FXML
    private Button modifyPartSaveButton;
    @FXML
    private TextField PartID;
    @FXML
    private TextField PartName;
    @FXML
    private TextField PartMax;
    @FXML
    private TextField PartMin;
    @FXML
    private TextField PartCost;
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
    @FXML
    private Part selectedPart;
    @FXML
    private ToggleGroup sourceRadioButtons;
    @FXML
    private int partID = 1;

    
    public void InHouseRBPushed() {
        this.SourceDependantLabel.setText("Machine ID");
        this.SourceDependantTextField.setPromptText("Machine ID #");
    }

    public void OutsourcedRBPushed() {
        this.SourceDependantLabel.setText("Company Name");
        this.SourceDependantTextField.setPromptText("Company Name");
    }
    
    public void modifyPartCancelButtonPushed (ActionEvent event) {
        ((Stage)(((Button)event.getSource()).getScene().getWindow())).close();
    }
    
    public void setPart(Part part) {
        selectedPart = part;
        PartID.setText(new String(String.valueOf(selectedPart.getId())));
        PartName.setText(new String (selectedPart.getName()));
        PartStock.setText((new String(String.valueOf(selectedPart.getStock()))));
        PartCost.setText(new String(String.valueOf(selectedPart.getPrice())));
        PartMin.setText(new String(String.valueOf(selectedPart.getMin())));
        PartMax.setText(new String(String.valueOf(selectedPart.getMax())));
        if (selectedPart instanceof InHousePart) {
            InHouseRBPushed();
            this.SourceDependantTextField.setText(Integer.toString(((InHousePart)(part)).getMachineID()));
            PartInHouseRB.setSelected(true);
        }
        else if (selectedPart instanceof OutsourcedPart) {
            PartInHouseRB.setSelected(true);
            OutsourcedRBPushed();
            this.SourceDependantTextField.setText(((OutsourcedPart)(part)).getCompanyName());
        }
     }
    
    public void modifyPartSaveButtonPushed (ActionEvent event) throws IOException {
        if (SourceDependantLabel.getText().equals("Machine ID")) {
            InHousePart newIhPart = new InHousePart();
            newIhPart.setName(PartName.getText());
            newIhPart.setPrice(Double.parseDouble(PartCost.getText()));
            newIhPart.setStock(Integer.parseInt(PartStock.getText()));
            newIhPart.setMin(Integer.parseInt(PartMin.getText()));
            newIhPart.setMax(Integer.parseInt(PartMax.getText()));
            newIhPart.setMachineID(Integer.parseInt(SourceDependantTextField.getText()));
            newIhPart.setId(Inventory.getPartID());
            Inventory.updatePart(newIhPart);
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
            Inventory.updatePart(newOSPart);
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
