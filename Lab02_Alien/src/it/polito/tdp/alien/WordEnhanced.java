package it.polito.tdp.alien;
import java.util.*;

public class WordEnhanced {
	
	private String alienWord;
	private LinkedList<String> translation = new LinkedList<String>();
	
	//Costruttore
	public WordEnhanced(String alienWord,String translation) {
		
		alienWord=alienWord.toLowerCase();	
		this.alienWord = alienWord;
		this.translation.add(translation);
	}
	
	/**
	 * Metodo per verificare se la parola è presente nel dizionario;
	 * return: true se è presente, false altrimenti
	 */
	public boolean equals (Object obj) {
		//Cast
		WordEnhanced s = (WordEnhanced)obj;
		if (this.alienWord.compareTo(s.getAlienWord())==0) return true;
		else return false;
		}

	//GETTERS AND SETTERS
	public String getAlienWord() {
		return alienWord;
	}

	public void setAlienWord(String alienWord) {
		this.alienWord = alienWord;
	}
	
	public LinkedList<String> getTranslation() {
		return translation;
	}

	
}
