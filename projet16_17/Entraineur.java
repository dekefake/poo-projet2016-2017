package projet16_17;

import java.util.Calendar;

public class Entraineur extends Licencie {
	private int niveau;
	
	public Entraineur(int licence, String nm, String p, Calendar d, Club c, int niv) throws IllegalArgumentException{
		super(licence,nm,p,d,c);
		if(niv<1 || niv>5){
			throw new IllegalArgumentException("Le niveau de l'entraineur est incorrect. Les niveaux valables vont de 1 à 5.");
		} else {
			niveau=niv;
		}
	}

}
