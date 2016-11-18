package projet16_17;

import java.util.Calendar;

public abstract class Licencie {

	private int numeroDeLicence;
	private String nom, prenom;
	private Calendar dateDeValidite;
	private Club club;

	public Licencie(int licence, String nm, String p, Calendar d, Club c) {
		numeroDeLicence = licence;
		nom = nm;
		prenom = p;
		dateDeValidite =d;
		club = c;
	}
	
	public int getNumeroDeLicence() {
		return numeroDeLicence;
	}
	public Club getClub(){
		return club;
	}
	
	public boolean LicenceValide(){
		return dateDeValidite.compareTo(dateDeValidite.getInstance())>=0;
	}
}
