package it.polito.tdp.alien;

/**
 * Sample Skeleton for 'Alien.fxml' Controller Class
 */

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
    private TextField txtWord;
    @FXML
    private TextArea txtResult;
    @FXML
    private Button btnTranslate;
    @FXML
    private Button btnReset;
        
    
    @FXML // This method is called by the FXMLLoader when initialization is complete
    void initialize() {
    	assert txtWord != null : "fx:id=\"txtWord\" was not injected: check your FXML file 'Alien.fxml'.";
    	assert txtResult != null : "fx:id=\"txtResult\" was not injected: check your FXML file 'Alien.fxml'.";
    	assert btnTranslate != null : "fx:id=\"bntTranslate\" was not injected: check your FXML file 'Alien.fxml'.";
    	assert btnReset != null : "fx:id=\"btnReset\" was not injected: check your FXML file 'Alien.fxml'.";
    	
    }
  
    AlienDictionary A = new AlienDictionary();
    
    @FXML
    void doTranslate(ActionEvent event) {
   
    	
    	    if (txtWord.getText().contains(" ")){
    		String parole[] = txtWord.getText().split(" ");
    		
    		String alienWord = parole[0];
    		String translation = parole[1];
    		
    		//Controllo sull'input di 2 parole (DEVE essere alfanumerico)
    		if (alienWord.matches("[a-zA-Z]+") && translation.matches("[a-zA-Z]+")) {	
    			
    		A.addWord(alienWord, translation);
    		txtResult.setText("Parola aggiunta al dizionario");
    		}
    		
    		else txtResult.setText("Formato dell'input non valido!");
    	}

    	//Controllo sull'input di 1 parola
    	    else if (txtWord.getText().matches("[a-zA-Z]+")){
    		String risultato = A.translateWord(txtWord.getText().toLowerCase());
    		
    		if (risultato==null) txtResult.setText("Parola non presente nel dizionario!");
    		
    		else txtResult.setText(risultato);
    	    }
    	
    	    //altrimenti errore sull'input
    	    else txtResult.setText("Formato dell'input non valido!");
    	
    	txtWord.clear();
    }
    
    
    @FXML
    void doReset(ActionEvent event) {

    	txtWord.clear();
    	txtResult.clear();
    	
    }
    
}
