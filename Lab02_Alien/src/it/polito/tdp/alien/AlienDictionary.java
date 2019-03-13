package it.polito.tdp.alien;
import java.util.*;

public class AlienDictionary {
	
    LinkedList<Word> dictionary = new LinkedList<Word>();
	TreeMap<String,Word> mappa = new TreeMap<String,Word>();
	
    //Costruttore
	public AlienDictionary() {
	}

    //Getter and Setter
	public List<Word> getDictionary() {
		return dictionary;
	}

	public void setDictionary(List<Word> dictionary) {
		this.dictionary = (LinkedList<Word>) dictionary;
	}

	/** 
	 *Metodo per aggiungere una parola al dizionario
	 * @param alienWord parola aliena
	 * @param translation parola tradotta
	 */
	public void addWord(String alienWord, String translation) {	
		
		//ToLowerCase
		String aw = alienWord.toLowerCase();
		String t = translation.toLowerCase();
		
		//Creo oggetto Word
		Word w = new Word(aw,t);
		
		//Controllo che AlienWord 
		if (mappa.containsKey(aw)) {
			
			Word w_old = mappa.get(aw);
			mappa.replace(aw, w);
			
			dictionary.remove(w_old);
			dictionary.add(w);
			
			System.out.println("Parola aggiornata");
		}
		
		else {
		dictionary.add(w);
		mappa.put(aw, w);
		}
	}
	
	public String translateWord(String alienWord) {
		
		String aw = alienWord.toLowerCase();
		if (mappa.containsKey(aw)) return mappa.get(aw).getTranslation();
		return null;
		
	}
}
