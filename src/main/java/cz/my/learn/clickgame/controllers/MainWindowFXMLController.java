package cz.my.learn.clickgame.controllers;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;


/**
 * FXML Controller class for main window
 * 
 * @author Lukas Kozel
 */
public class MainWindowFXMLController implements Initializable {
    
    @FXML
    private Button newGameButton;
    @FXML
    private Button loadButton;
    @FXML
    private Button exitButton;
    
    @FXML
    private void newGameButtonAction(ActionEvent event) throws IOException {
        
        Parent root = FXMLLoader.load(getClass().getResource("/fxml/NewPlayerWindow.fxml"));
            
        Scene scene = new Scene(root);
        Stage stage = new Stage();
           
        stage.setTitle("Click Game 0.1");
        stage.setScene(scene);
        stage.show();
        
        Stage oldStage = (Stage) newGameButton.getScene().getWindow();
        oldStage.close();
    }
    
    @FXML
    private void exitButtonAction(ActionEvent event){
        Stage oldStage = (Stage) exitButton.getScene().getWindow();
        oldStage.close();
    }
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        this.loadButton.setDisable(true);
        // TODO zmenit load
    }    
}
