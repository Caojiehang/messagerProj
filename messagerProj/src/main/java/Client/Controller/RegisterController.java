package Client.Controller;


import Client.MainApp;
import Client.model.ClientModel;
import Dao.AccountDaoImpl;
import Utils.ControllerStage;
import Utils.StageController;
import bean.Account;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.GridPane;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javafx.stage.WindowEvent;
import lombok.extern.slf4j.Slf4j;

import javax.swing.*;
import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;

/**
* @Author: Jiehang CAO
* @Description: RegisterView Controller
* @Date: 17:41 2019-03-06
*/
@Slf4j
public class RegisterController implements ControllerStage, Initializable {



    StageController stageController;


    @FXML
    private TextField username;
    @FXML
    private PasswordField passwordField;

    @FXML
    private PasswordField confirmPass;
    @FXML
    private TextField email;

    static  private String wrongMessage;

    @FXML TextField ipAddress;

    ClientModel model;

    /**
     * register button click event
     * check register and go to chat page after success
     * @param actionEvent
     */
    @FXML
    protected  synchronized void registermethod(ActionEvent actionEvent) {
        StringBuffer buffer = new StringBuffer();
          if(model.CheckRegister(username.getText(),ipAddress.getText(),passwordField.getText(),email.getText(),buffer)) {
            goToMain();
          }
    }

    /**
     * go to chat view
     */
    public void goToMain() {
        stageController.loadStage(MainApp.mainViewID,MainApp.mainRes);
        stageController.setStage(MainApp.mainViewID,MainApp.registerViewID);
        stageController.getStage(MainApp.mainViewID).setOnCloseRequest(new EventHandler<WindowEvent>() {
            @Override
            public void handle(WindowEvent event) {
                model.disConnect();
            }
        });
    }

    /**
     * back to login page
     * @param actionEvent
     * @throws IOException
     */
    @FXML
    protected void backmethod(ActionEvent actionEvent) throws IOException {
        stageController.setStage(MainApp.loginViewID,MainApp.registerViewID);
    }


    public void setStageController(StageController stageController) {
       this.stageController = stageController;
       model = ClientModel.getInstance();
    }

    public void initialize(URL location, ResourceBundle resources) {

    }

}
