package cz.my.learn.clickgame.controllers;

import cz.my.learn.clickgame.logic.Hero;
import cz.my.learn.clickgame.logic.managers.HeroManager;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ProgressBar;
import javafx.stage.Stage;

/**
 * FXML Controller class for play's window
 *
 * @author Lukas Kozel
 */
public class PlayWindowController implements Initializable {

    @FXML
    private Button exitButton;
    @FXML
    private Button saveButton;
    @FXML
    private Label actualCashLabel;
    @FXML
    private Label nameLabel;
    @FXML
    private Label level00Label;
    @FXML
    private Label level01Label;
    @FXML
    private Label level02Label;
    @FXML
    private Label level03Label;
    @FXML
    private Label nameWork00Label;
    @FXML
    private Label nameWork01Label;
    @FXML
    private Label nameWork02Label;
    @FXML
    private Label nameWork03Label;
    @FXML
    private Button upgrade00Button;
    @FXML
    private Label cost00Label;
    @FXML
    private Button upgrade01Button;
    @FXML
    private Label cost01Label;
    @FXML
    private Button upgrade02Button;
    @FXML
    private Label cost02Label;
    @FXML
    private Button upgrade03Button;
    @FXML
    private Label cost03Label;
    @FXML
    private ProgressBar progressBar00;
    @FXML
    private ProgressBar progressBar01;
    @FXML
    private ProgressBar progressBar02;
    @FXML
    private ProgressBar progressBar03;
    
            
    
    private HeroManager heroManager;
    private Hero actualHero;
    
    @FXML
    private void exitButtonAction(ActionEvent event) {
        Stage oldStage = (Stage) exitButton.getScene().getWindow();
        oldStage.close();
    }

    @FXML
    private void saveButtonAction(ActionEvent event) {
        // TODO
    }

    @FXML
    private void upgrade00ButtonAction(ActionEvent event) {
        this.actualHero.setCash(this.actualHero.getCash() - this.actualHero.getWorkManager().findWorkById(1L).getCost());
        this.actualHero.getWorkManager().levelUp(1L);
        
        this.actualCashLabel.setText(this.actualHero.getCash().toString());
        this.level00Label.setText(Integer.toString(this.actualHero.getWorkManager().findWorkById(1L).getLevel()));
        this.cost00Label.setText(this.actualHero.getWorkManager().findWorkById(1L).getCost().toString());
        
        this.setDisableUpgrade();
        
        if(this.actualHero.getWorkManager().findWorkById(1L).getLevel() == 1){
            this.startProgress00();
        }
    }

    @FXML
    void upgrade01ButtonAction(ActionEvent event) {
        this.actualHero.setCash(this.actualHero.getCash() - this.actualHero.getWorkManager().findWorkById(2L).getCost());
        this.actualHero.getWorkManager().levelUp(2L);
        
        this.actualCashLabel.setText(this.actualHero.getCash().toString());
        this.level01Label.setText(Integer.toString(this.actualHero.getWorkManager().findWorkById(2L).getLevel()));
        this.cost01Label.setText(this.actualHero.getWorkManager().findWorkById(2L).getCost().toString());
        
        this.setDisableUpgrade();
        
        if(this.actualHero.getWorkManager().findWorkById(2L).getLevel() == 1){
            this.startProgress01();
        }
    }

    @FXML
    void upgrade02ButtonAction(ActionEvent event) {
        this.actualHero.setCash(this.actualHero.getCash() - this.actualHero.getWorkManager().findWorkById(3L).getCost());
        this.actualHero.getWorkManager().levelUp(3L);
        
        this.actualCashLabel.setText(this.actualHero.getCash().toString());
        this.level02Label.setText(Integer.toString(this.actualHero.getWorkManager().findWorkById(3L).getLevel()));
        this.cost02Label.setText(this.actualHero.getWorkManager().findWorkById(3L).getCost().toString());
        
        this.setDisableUpgrade();
        
        if(this.actualHero.getWorkManager().findWorkById(3L).getLevel() == 1){
            this.startProgress02();
        }
    }

    @FXML
    void upgrade03ButtonAction(ActionEvent event) {
        this.actualHero.setCash(this.actualHero.getCash() - this.actualHero.getWorkManager().findWorkById(4L).getCost());
        this.actualHero.getWorkManager().levelUp(4L);
        
        this.actualCashLabel.setText(this.actualHero.getCash().toString());
        this.level03Label.setText(Integer.toString(this.actualHero.getWorkManager().findWorkById(4L).getLevel()));
        this.cost03Label.setText(this.actualHero.getWorkManager().findWorkById(4L).getCost().toString());
        
        this.setDisableUpgrade();
        
        if(this.actualHero.getWorkManager().findWorkById(4L).getLevel() == 1){
            this.startProgress03();
        }
    }
    //TODO spravneukoncovatvlakna???
    //TODO pres label na tlacitku se neda kliknout na tlacitko
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        this.saveButton.setDisable(true);
        this.progressBar00.setProgress(0.0);
        this.progressBar01.setProgress(0.0);
        this.progressBar02.setProgress(0.0);
        this.progressBar03.setProgress(0.0);
        // TODO dodelat save
    }  

    public void setHeroManager(HeroManager heroManager, Hero hero) {
        this.heroManager = heroManager;
        this.actualHero = hero;
    }

    public void setDisableUpgrade(){
        Long cash = this.actualHero.getCash();
        
        if(cash.compareTo(this.actualHero.getWorkManager().findWorkById(1L).getCost()) < 0){
            this.upgrade00Button.setDisable(true);
        } else {
            this.upgrade00Button.setDisable(false);
        }
        
        if(cash.compareTo(this.actualHero.getWorkManager().findWorkById(2L).getCost()) < 0){
            this.upgrade01Button.setDisable(true);
        } else {
            this.upgrade01Button.setDisable(false);
        }
        
        if(cash.compareTo(this.actualHero.getWorkManager().findWorkById(3L).getCost()) < 0){
            this.upgrade02Button.setDisable(true);
        } else {
            this.upgrade02Button.setDisable(false);
        }
        
        if(cash.compareTo(this.actualHero.getWorkManager().findWorkById(4L).getCost()) < 0){
            this.upgrade03Button.setDisable(true);
        } else {
            this.upgrade03Button.setDisable(false);
        }
    }
    
    public void setTextLabel() {
        this.actualCashLabel.setText(this.actualHero.getCash().toString());
        this.nameLabel.setText(this.actualHero.getName());
        
        this.level00Label.setText(Integer.toString(this.actualHero.getWorkManager().findWorkById(1L).getLevel()));
        this.level01Label.setText(Integer.toString(this.actualHero.getWorkManager().findWorkById(2L).getLevel()));
        this.level02Label.setText(Integer.toString(this.actualHero.getWorkManager().findWorkById(3L).getLevel()));
        this.level03Label.setText(Integer.toString(this.actualHero.getWorkManager().findWorkById(4L).getLevel()));
                
        this.nameWork00Label.setText(this.actualHero.getWorkManager().findWorkById(1L).getName());
        this.nameWork01Label.setText(this.actualHero.getWorkManager().findWorkById(2L).getName());
        this.nameWork02Label.setText(this.actualHero.getWorkManager().findWorkById(3L).getName());
        this.nameWork03Label.setText(this.actualHero.getWorkManager().findWorkById(4L).getName());
        
        this.cost00Label.setText(this.actualHero.getWorkManager().findWorkById(1L).getCost().toString());
        this.cost01Label.setText(this.actualHero.getWorkManager().findWorkById(2L).getCost().toString());
        this.cost02Label.setText(this.actualHero.getWorkManager().findWorkById(3L).getCost().toString());
        this.cost03Label.setText(this.actualHero.getWorkManager().findWorkById(4L).getCost().toString());
    }

    private void startProgress00() {
        Thread th = new Thread(new bg_Thread00(this.actualHero.getWorkManager().findWorkById(1L).getTime()));
        th.start();        
    }
    private void startProgress01() {
        Thread th = new Thread(new bg_Thread01(this.actualHero.getWorkManager().findWorkById(2L).getTime()));
        th.start();        
    }
    private void startProgress02() {
        Thread th = new Thread(new bg_Thread02(this.actualHero.getWorkManager().findWorkById(3L).getTime()));
        th.start();        
    }
    private void startProgress03() {
        Thread th = new Thread(new bg_Thread03(this.actualHero.getWorkManager().findWorkById(4L).getTime()));
        th.start();        
    }
    
    class bg_Thread00 implements Runnable{

        private int time;
        
        public bg_Thread00(int time) {
            this.time = time;
        }

        @Override
        public void run() {
            while(true){
                for(int i = 0; i < 100; i++){
                    progressBar00.setProgress(i / 100.0);
                    try {
                        Thread.sleep(time);
                    } catch (InterruptedException ex) {
                        Logger.getLogger(PlayWindowController.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
                actualHero.setCash(actualHero.getCash() + actualHero.getWorkManager().findWorkById(1L).getReward());
                
                Platform.runLater(new Runnable() {
                    @Override
                    public void run() {
                        drawActualCash();
                        setDisableUpgrade();
                    }
                });
                progressBar00.setProgress(0.0);
            }
        }        
    }
    class bg_Thread01 implements Runnable{

        private int time;
        
        public bg_Thread01(int time) {
            this.time = time;
        }

        @Override
        public void run() {
            while(true){
                for(int i = 0; i < 100; i++){
                    progressBar01.setProgress(i / 100.0);
                    try {
                        Thread.sleep(time);
                    } catch (InterruptedException ex) {
                        Logger.getLogger(PlayWindowController.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
                actualHero.setCash(actualHero.getCash() + actualHero.getWorkManager().findWorkById(2L).getReward());
                
                Platform.runLater(new Runnable() {
                    @Override
                    public void run() {
                        drawActualCash();
                        setDisableUpgrade();
                    }
                });
                progressBar01.setProgress(0.0);
            }
        }        
    }
    class bg_Thread02 implements Runnable{

        private int time;
        
        public bg_Thread02(int time) {
            this.time = time;
        }

        @Override
        public void run() {
            while(true){
                for(int i = 0; i < 100; i++){
                    progressBar02.setProgress(i / 100.0);
                    try {
                        Thread.sleep(time);
                    } catch (InterruptedException ex) {
                        Logger.getLogger(PlayWindowController.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
                actualHero.setCash(actualHero.getCash() + actualHero.getWorkManager().findWorkById(3L).getReward());
                
                Platform.runLater(new Runnable() {
                    @Override
                    public void run() {
                        drawActualCash();
                        setDisableUpgrade();
                    }
                });
                progressBar02.setProgress(0.0);
            }
        }        
    }
    class bg_Thread03 implements Runnable{

        private int time;
        
        public bg_Thread03(int time) {
            this.time = time;
        }

        @Override
        public void run() {
            while(true){
                for(int i = 0; i < 100; i++){
                    progressBar03.setProgress(i / 100.0);
                    try {
                        Thread.sleep(time);
                    } catch (InterruptedException ex) {
                        Logger.getLogger(PlayWindowController.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
                actualHero.setCash(actualHero.getCash() + actualHero.getWorkManager().findWorkById(4L).getReward());
                
                Platform.runLater(new Runnable() {
                    @Override
                    public void run() {
                        drawActualCash();
                        setDisableUpgrade();
                    }
                });
                progressBar01.setProgress(0.0);
            }
        }        
    }
    
    private void drawActualCash() {
        actualCashLabel.setText(actualHero.getCash().toString());
    }
}
    
    