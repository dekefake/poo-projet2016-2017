package projet16_17;

import java.io.Serializable;
import java.util.Enumeration;
import java.util.Hashtable;
import java.util.Iterator;

public class Equipe implements Serializable{
	private Hashtable<Integer, Joueur> titulaires, remplacants;

	private Club club;
	private int id, nbTitulaires, nbRemplacants, nbTitMax, nbRempMax;

	public Equipe(Club c, int id, int nbTitulairesMax, int nbRMax) {
		club = c;
		this.id = id;
		nbTitulaires = 0;
		nbRemplacants = 0;
		nbTitMax = nbTitulairesMax;
		nbRempMax = nbRMax;
		titulaires = new Hashtable<Integer, Joueur>(); // Key=licenceNum, Value=joueur
		remplacants = new Hashtable<Integer, Joueur>(); // Key=licenceNum, Value=joueur
	}
	
	public Club getClub(){
		return club;
	}

	public boolean titulairesEstPlein() {
		return nbTitulaires == nbTitMax;
	}

	public boolean remplacantsEstPlein() {
		return nbRempMax == nbRemplacants;
	}

	public boolean aUnGardien() {
		Enumeration<Integer> keys = titulaires.keys();
		Joueur j;
		while(keys.hasMoreElements()){
			int key = keys.nextElement();
			j=(Joueur)titulaires.get(key);
			if(j.getPoste()==Poste.GARDIEN){
				return true;
			}
		}
		return false;
	}

	public boolean detientJoueur(Joueur j) {
		return titulaires.containsValue(j) || remplacants.containsValue(j);
	}

	public void ajouterJoueurTitulaire(Joueur j) throws IllegalStateException {
		if(!j.LicenceValide()){
			throw new IllegalStateException("La licence de ce joueur n'est plus valide");
		}
		if (j.getClub() != club) {
			throw new IllegalStateException("Ce joueur ne fait pas partie du meme club que l'équipe");
		}
		if (aUnGardien() && j.getPoste() == Poste.GARDIEN) {
			throw new IllegalStateException("Depuis quand une equipe de foot a plusieurs gardiens ??");
		}
		if (titulairesEstPlein()) {
			throw new IllegalStateException(
					"Le fair play n'a jamais tué personne. " + nbTitMax + " joueurs titulaires max.");
		}
		if (detientJoueur(j)) {
			throw new IllegalStateException("Le joueur " + j.getNumeroDeLicence() + " fait deja partie de l'équipe.");
		} else {
			titulaires.put(j.getNumeroDeLicence(), j);
			nbTitulaires++;
		}
	}

	public void ajouterJoueurRemplacant(Joueur j) throws IllegalStateException {
		if(!j.LicenceValide()){
			throw new IllegalStateException("La licence de ce joueur n'est plus valide");
		}
		if (j.getClub() != club) {
			throw new IllegalStateException("Ce joueur ne fait pas partie du meme club que l'équipe");
		}
		if (remplacantsEstPlein()) {
			throw new IllegalStateException(nbRempMax + " joueurs remplacants max.");
		}
		if (detientJoueur(j)) {
			throw new IllegalStateException("Le joueur " + j.getNumeroDeLicence() + " fait deja partie de l'équipe.");
		} else {
			remplacants.put(j.getNumeroDeLicence(), j);
			nbRemplacants++;
		}
	}
	
	public String toString(){
		return ("Equipe n°"+id+"  Représente le club : "+club.getNom()+"\n     Titulaires :\n"+Tournoi.MapToString(titulaires)+"\n     Remplacants :\n"+Tournoi.MapToString(remplacants));
	}
}
