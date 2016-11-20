package projet16_17;

import java.text.SimpleDateFormat;
import java.util.Calendar;

public abstract class Licencie {

	private int numeroDeLicence;
	private String nom, prenom;
	private Calendar dateInscription;
	private Club club;

	public Licencie(int licence, String nm, String p, Calendar d, Club c) {
		numeroDeLicence = licence;
		nom = nm;
		prenom = p;
		dateInscription =d;
		club = c;
	}
	
	public int getNumeroDeLicence() {
		return numeroDeLicence;
	}
	public Club getClub(){
		return club;
	}
	
	public boolean LicenceValide(){
		return dateInscription.compareTo(dateInscription.getInstance())>=0;
	}
	
	public String toString(){
		SimpleDateFormat formatDate = new SimpleDateFormat("dd-MM-yyyy");
		return ("Licencié n°"+numeroDeLicence+"\n"+nom+nom+" "+prenom+prenom+"\nInscrit depuis le :"+formatDate.format(dateInscription.getTime())+"\nAffilié au club de "+club.getNom());
	}
}
