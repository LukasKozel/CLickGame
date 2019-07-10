package cz.my.learn.clickgame.controllers;

import cz.my.learn.clickgame.exception.ValidException;
import cz.my.learn.clickgame.logic.managers.HeroManager;
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
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

/**
 * FXML Controller class for create new player
 *
 * @author Lukas Kozel
 */
public class NewPlayerWindowController implements Initializable {

    @FXML
    private Label wrongNameLabel;

    @FXML
    private TextField newNameTextField;

    @FXML
    private Button okButton;
    
    private HeroManager heroManager = new HeroManager();
    
    
    
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }  
    
    @FXML
    private void okButtonAction(ActionEvent event) throws IOException, ValidException {
        try{
            String text = this.newNameTextField.getText();
            
            this.heroManager.createHero(text);
                       
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/fxml/PlayWindow.fxml"));
            Parent root = (Parent) loader.load();
            
            PlayWindowController playWindowController = loader.getController();
            playWindowController.setHeroManager(this.heroManager, this.heroManager.findHeroByName(text));
            playWindowController.setTextLabel();
            playWindowController.setDisableUpgrade();
            
            Scene scene = new Scene(root);
            Stage stage = new Stage();
            
            stage.setTitle("Click Game 0.1");
            stage.setScene(scene);
            stage.show();
            
            Stage oldStage = (Stage) okButton.getScene().getWindow();
            oldStage.close();
            
        } catch(ValidException ex){
            this.wrongNameLabel.setText("Wrong name");
        } catch(Exception ex){
            System.out.println(ex);
        }

    }
    
    
}
