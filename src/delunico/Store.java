/*
    Name:  Nick De Luca
    Assignment:  Assignment 6
    Program: Prog 24178
    Date:  August 7th 2020

    Description:
    This class extends Application and implements its start method to 
    load an FXML file and its controller using the MVC design principle
*/
package delunico;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

/**
 * This class loads and starts fxml with its mvc design to run this application.
 * @author Nick De Luca
 */
public class Store extends Application {

    /**
     * The main method of this application
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }
     /**
     * The implementation of Application's abstract start method that builds
     * the gui of this application and displays it to the screen. 
     * @param stage
     * @throws Exception 
     */
    @Override
    public void start(Stage stage) throws Exception {
        Parent root = FXMLLoader.load(getClass().getResource("FXMLIceCream.fxml"));
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.setTitle("Ice Cream Inventory");
        stage.show();
        
    }

}
