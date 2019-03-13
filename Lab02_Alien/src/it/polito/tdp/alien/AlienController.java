package it.polito.tdp.alien;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

public class AlienController {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private TextField txtInput;

    @FXML
    private Button handleTranslate;

    @FXML
    private TextArea txtMessaggi;

    @FXML
    private Button handleClearText;

    @FXML
    void doClearText(ActionEvent event) {

    }

    @FXML
    void doTranslate(ActionEvent event) {

    }

    @FXML
    void initialize() {
        assert txtInput != null : "fx:id=\"txtInput\" was not injected: check your FXML file 'Alien.fxml'.";
        assert handleTranslate != null : "fx:id=\"handleTranslate\" was not injected: check your FXML file 'Alien.fxml'.";
        assert txtMessaggi != null : "fx:id=\"txtMessaggi\" was not injected: check your FXML file 'Alien.fxml'.";
        assert handleClearText != null : "fx:id=\"handleClearText\" was not injected: check your FXML file 'Alien.fxml'.";

    }
}

