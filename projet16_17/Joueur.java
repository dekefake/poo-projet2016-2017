package projet16_17;

import java.util.Calendar;

public class Joueur extends Licencie {
	private Poste poste;
	
	public Joueur(int licence, String nm, String p, Calendar d, Club c, Poste pst){
		super(licence,nm,p,d,c);
		poste=pst;
	}
}
