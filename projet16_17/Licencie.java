package projet16_17;

import java.text.DateFormat;
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
	
	public static String CalendarToString(Calendar c){
		DateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
        String date = formatter.format(c.getTime());
        return date;
	}
	
	public String toString(){
		SimpleDateFormat formatDate = new SimpleDateFormat("dd-MM-yyyy");
		return ("Licencié n°"+numeroDeLicence+"\n"+nom+nom+" "+prenom+prenom+"\nInscrit depuis le :"+CalendarToString(dateInscription)+"\nAffilié au club de "+club.getNom());
	}
}
