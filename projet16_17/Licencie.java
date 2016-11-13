package projet16_17;

import java.util.Calendar;

public abstract class Licencie {
	private int numeroDeLicence;
	private String nom,prenom;
	private Calendar dateDeValidite;
	private Club club;
	
	public Licencie(int licence, String nm, String p, Calendar d, Club c){
		numeroDeLicence=licence;
		nom=nm;
		prenom=p;
		dateDeValidite=(Calendar)d.clone(); // Par souci de sécurité, ne pas lier certaines choses en mémoire..
		club=c;
	}
}
