/*
    IceCreamController.java
    Author: Nick De Luca
    Date: August 7th 2020
    Description
    This class controls the FXML nodes by accessing their fx:id values,
    implements Initializable, and handles button events for read and write.
*/
package delunico;

import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import java.net.URL;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.fxml.*;
import java.util.*;
import java.io.*;
import model.*;

/**
 * FXML Controller class
 *
 * @author Nick De Luca
 */
public class IceCreamController implements Initializable {

    @FXML
    private ComboBox<String> cmbFlavours;
    @FXML
    private TextField txfPrice;
    @FXML
    private Label lblQuantity;
    @FXML
    private TextField txfQuantity;
    @FXML
    private TextArea txaDisplay;
    @FXML
    private Button btnSave;
    @FXML
    private Button btnShowInventory;
    @FXML
    private Button btnExit;
    @FXML
    private VBox pnlMain;
    @FXML
    private HBox pnlPrice;
    @FXML
    private HBox pnlQuantity;

    private IceCreamFlavour[] flavours = IceCreamFlavour.values();
    ObservableList<String> flavourList;
    @FXML
    private Label lblPrice;
    @FXML
    private Button btnReset;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        pnlMain.getStyleClass().add("pnlMainPadding");
        pnlPrice.getStyleClass().add("nodePadding");
        pnlQuantity.getStyleClass().add("nodePadding");
        flavourList = cmbFlavours.getItems();
        cmbFlavours.getSelectionModel().select("Select A Flavour");
        cmbFlavours.setOnAction(event -> {
            int index = cmbFlavours.getSelectionModel().getSelectedIndex();
            if (index != -1) {
                Double price = new Double(flavours[index].getPrice());
                txfPrice.setText(price.toString());
            }
        });
    }
    /**
     * This method controls accessing and modifying the inventory determined by
     * the source of the given event object, and controls exiting.
     * @param event the given event object to control each action.
     */
    @FXML
    private void InventorySystem(ActionEvent event) {
        File file = new File("inventory.txt");
        if (event.getSource() == btnShowInventory) {
            printHeader();
            readInventory(file);
        }
        if (event.getSource() == btnSave) {
            saveInventory();
        }
        if (event.getSource() == btnExit) {
            System.exit(0);
        }
    }
    /**
     * This method clears all input values and resets the interface.
     * @param event the event object given from the source 
     */
    @FXML
    private void clear(ActionEvent event) {
        cmbFlavours.getSelectionModel().select(-1);
        txfPrice.clear();
        txfQuantity.clear();
        txaDisplay.clear();
        lblQuantity.getStyleClass().remove("error");
    }
    /**
     * This method prints the header of the inventory printout to form labels.
     */
    private void printHeader() {
        txaDisplay.setText(String.format("%-3s%-15s%-7s%-6s%-5s%n",
                "ID", "Flavour", "Price", "Qty", "Cost"));
        txaDisplay.appendText("=====================================\n");
    }
    /**
     * This method saves all input values to the inventory file and handles
     * exceptions thrown for invalid file names, quantities,and flavours.
     */
    private void saveInventory() {
        try {
            int index = cmbFlavours.getSelectionModel().getSelectedIndex();
            IceCreamFlavour flavour = flavours[index];

            int id = flavour.getId();
            double price = Double.parseDouble(txfPrice.getText());
            int quantity = Integer.parseInt(txfQuantity.getText());

            File file = new File("inventory.txt");
            FileWriter fw = new FileWriter(file, true);
            PrintWriter pw = new PrintWriter(fw);
            pw.print(id);
            pw.print("|" + flavour.name());
            pw.print("|" + price);
            pw.print("|" + quantity);
            pw.print("|");
            pw.print("\r\n");
            pw.close();
            txaDisplay.setText(flavour.getFlavour() + " was saved . . ");
            lblQuantity.getStyleClass().remove("error");
        } catch (IOException e) {
            txaDisplay.setText("File not found" + e.getMessage());
        } catch (NumberFormatException n) {
            txaDisplay.setText("invalid quantity . . .");
            lblQuantity.getStyleClass().add("error");
        } catch (IndexOutOfBoundsException b) {
            txaDisplay.setText("Please select a flavour");
        }
    }
    /**
     * This method reads an inventory file and prints its data in separate lines
     * @param file the given inventory file to read.
     */
    private void readInventory(File file) {
        try {
            Scanner input = new Scanner(file);
            input.useDelimiter("\\|\\s*");
            while (input.hasNext()) {
                int id = input.nextInt();
                String flavour = input.next();
                double price = input.nextDouble();
                int quantity = input.nextInt();
                IceCreamFlavour iceCreamFlavour = flavours[
                        flavourList.indexOf(flavour)];
                IceCream item = new IceCream(iceCreamFlavour, price, quantity);
                txaDisplay.appendText(item.toString());
                txaDisplay.appendText("\r\n");
            }
            input.close();
        } catch (FileNotFoundException e) {
            txaDisplay.setText("File not found" + e.getMessage());
        }
    }
}
