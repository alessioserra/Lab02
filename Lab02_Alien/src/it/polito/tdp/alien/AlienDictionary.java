package it.polito.tdp.alien;
import java.util.*;

public class AlienDictionary {
	
    LinkedList<WordEnhanced> dictionary = new LinkedList<WordEnhanced>();
	TreeMap<String,WordEnhanced> mappa = new TreeMap<String,WordEnhanced>();
	
    //Costruttore
	public AlienDictionary() {
	}

    //Getter and Setter
	public List<WordEnhanced> getDictionary() {
		return dictionary;
	}

	public void setDictionary(List<WordEnhanced> dictionary) {
		this.dictionary = (LinkedList<WordEnhanced>) dictionary;
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
		WordEnhanced w = new WordEnhanced(aw,t);
		
		//Controllo che AlienWord 
		if (mappa.containsKey(aw)) {
			
			WordEnhanced w_old = mappa.get(aw);
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
