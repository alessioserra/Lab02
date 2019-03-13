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
   
    	    //Gestisto il caso senza "?"
    	    if (!txtWord.getText().contains("?")) {
    	    
    	    if (txtWord.getText().contains(" ")){
    		String parole[] = txtWord.getText().split(" ");
    		
    		String alienWord = parole[0];
    		String translation = parole[1];
    		
    		//Controllo sull'input di 2 parole (DEVE essere alfanumerico)
    		if (alienWord.matches("[a-zA-Z]+") && translation.matches("[a-zA-Z]+")) {	
    			
    		A.addWord(alienWord, translation);
    		txtResult.appendText("Parola aggiunta al dizionario\n");
    		}
    		
    		else txtResult.appendText("Formato dell'input non valido!\n");
    	}

    	//Controllo sull'input di 1 parola
    	    else if (txtWord.getText().matches("[a-zA-Z]+")){
    		String risultato = A.translateWord(txtWord.getText().toLowerCase());
    		
    		if (risultato==null) txtResult.appendText("Parola non presente nel dizionario!\n");
    		
    		else txtResult.appendText(risultato+"\n");
    	    }
    	
    	    //altrimenti errore sull'input
    	    else txtResult.appendText("Formato dell'input non valido!\n");
    	
    	txtWord.clear();
    	    }
    	    
    	    //Gestione dell'esercizio opzionale
    	    else {
    	      
    	    	String parola = txtWord.getText().trim();
    	    	
    	    	//Se il "?" è ad inizio parola
    	    	if (parola.substring(0, 1).compareTo("?")==0) {
    	    		parola = parola.substring(1,parola.length());
    	    		for (Word w : A.getDictionary()) {
    	    			if ( w.getAlienWord().substring(1, w.getAlienWord().length()).compareTo(parola)==0 )
    	    				txtResult.appendText(w.getTranslation());
    	    		}
    	    	}
    	    	
    	    	//Se il "?" è ad fine parola parola
    	    	if (parola.substring(parola.length()-1, parola.length()).compareTo("?")==0) {
    	    		parola = parola.substring(0,parola.length()-1);
    	    		
    	    		for (Word w : A.getDictionary()) {
    	    			if ( w.getAlienWord().substring(0, w.getAlienWord().length()-1).compareTo(parola)==0 )
    	    				txtResult.appendText(w.getTranslation());
    	    		}
    	    	}
    	    	
    	    	//Se il "?" è in mezzo
    	    	else {
    	    		parola=parola.replace("?", "-");
    	    		String array[] = parola.split("-");
    	    		
    	    		String uno = array[0];
    	    		String due = array[1];
    	    		
    	    		for (Word w : A.getDictionary()) {
    	    			if (w.getAlienWord().contains(uno) && w.getAlienWord().contains(due))
    	    				txtResult.appendText(w.getTranslation()+"\n");
    	    		}
    	    	}
    	    	txtWord.clear();
    	    }
    }
    
    
    @FXML
    void doReset(ActionEvent event) {

    	txtWord.clear();
    	txtResult.clear();
    	
    }
    
}
