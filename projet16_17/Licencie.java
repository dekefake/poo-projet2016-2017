package projet16_17;

import java.io.Serializable;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;

public abstract class Licencie implements Serializable{

	private int numeroDeLicence;
	private String nom, prenom;
	private Calendar dateValiditeLicence;
	private Club club;

	public Licencie(int licence, String nm, String p, Calendar d, Club c) {
		numeroDeLicence = licence;
		nom = nm;
		prenom = p;
		dateValiditeLicence =d;
		club = c;
	}
	
	public int getNumeroDeLicence() {
		return numeroDeLicence;
	}
	public Club getClub(){
		return club;
	}
	
	public boolean LicenceValide(){
		return dateValiditeLicence.compareTo(Calendar.getInstance())>=0;
	}
	
	public static String CalendarToString(Calendar c){
		DateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
        String date = formatter.format(c.getTime());
        return date;
	}
	
	public String toString(){
		return ("Licencié n°"+numeroDeLicence+" Nom : "+nom+" Prenom : "+prenom+" Licence valide jusqu'au :"+CalendarToString(dateValiditeLicence)+" Affilié au club de "+club.getNom());
	}
}
