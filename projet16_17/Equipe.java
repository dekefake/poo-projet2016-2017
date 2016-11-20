package projet16_17;

import java.util.Enumeration;
import java.util.Hashtable;

public class Equipe {
	private Hashtable titulaires, remplacants;

	// Hastables (key=Joueur;value=Poste)
	private Club club;
	private int id, nbTitulaires, nbRemplacants, nbTitMax, nbRempMax;

	public Equipe(Club c, int id, int nbTitulairesMax, int nbRMax) {
		club = c;
		this.id = id;
		nbTitulaires = 0;
		nbRemplacants = 0;
		nbTitMax = nbTitulairesMax;
		nbRempMax = nbRMax;
		titulaires = new Hashtable();
		remplacants = new Hashtable();
	}

	public boolean titulairesEstPlein() {
		return nbTitulaires == nbTitMax;
	}

	public boolean remplacantsEstPlein() {
		return nbRempMax == nbRemplacants;
	}

	public boolean aUnGardien() {
		return titulaires.containsValue(Poste.GARDIEN);
	}

	public boolean detientJoueur(Joueur j) {
		return titulaires.containsKey(j) || remplacants.containsValue(j);
	}

	public void ajouterJoueurTitulaire(Joueur j) throws IllegalStateException {
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
			titulaires.put(j, j.getPoste());
			nbTitulaires++;
		}
	}

	public void ajouterJoueurRemplacant(Joueur j) throws IllegalStateException {
		if (j.getClub() != club) {
			throw new IllegalStateException("Ce joueur ne fait pas partie du meme club que l'équipe");
		}
		if (j.getPoste() == Poste.GARDIEN) {
			throw new IllegalStateException("Depuis quand une equipe de foot a plusieurs gardiens ??");
		}
		if (remplacantsEstPlein()) {
			throw new IllegalStateException(nbRempMax + " joueurs remplacants max.");
		}
		if (detientJoueur(j)) {
			throw new IllegalStateException("Le joueur " + j.getNumeroDeLicence() + " fait deja partie de l'équipe.");
		} else {
			remplacants.put(j, j.getPoste());
			nbRemplacants++;
		}
	}
	
	public String toString(){
		return ("Equipe n°"+id+"Représente le club : "+club.getNom()+"\n     Titulaires :\n"+titulaires+"\n     Remplacants :"+remplacants);
	}
}
