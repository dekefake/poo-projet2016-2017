package projet16_17;

public class Equipe {
	private Joueur[] titulaires, remplacants;
	private Club club;
	private int id; 

	public Equipe(int nbTitulaire, int nbRemplacants) throws IllegalArgumentException {
		if (nbTitulaire < 1) {
			throw new IllegalArgumentException("Le nombre de joueurs titulaires ne peut pas être inferieur à 1.");
		}
		if (nbRemplacants < 1 || nbRemplacants > 5) {
			throw new IllegalArgumentException(
					"Le nombre de joueurs remplacants ne peut pas être inferieur à 1 ou superieur a 5.");
		}

		titulaires = new Joueur[nbTitulaire];
		remplacants = new Joueur[nbRemplacants];
	}

	public boolean estPlein(Joueur[] t) {
		return t[t.length - 1] != null;
	}

	public boolean aUnGardien() {
		int i = 0;
		while (titulaires[i] != null) {
			if (titulaires[i].getPoste() == Poste.GARDIEN) {
				return true;
			}
			i++;
		}
		return false;
	}

	public boolean detientJoueur(Joueur j) {
		int i = 0;
		while (titulaires[i] != null) {
			if (titulaires[i].equals(j)) {
				return true;
			}
		}
		i = 0;
		while (remplacants[i] != null) {
			if (remplacants[i].equals(j)) {
				return true;
			}
		}
		return false;
	}

	public void ajouterJoueurTitulaire(Joueur j) throws IllegalStateException {
		if (aUnGardien() && j.getPoste() == Poste.GARDIEN) {
			throw new IllegalStateException("Depuis quand une equipe de foot a plusieurs gardiens ??");
		}
		if (estPlein(titulaires)) {
			throw new IllegalStateException(
					"Le fair play n'a jamais tué personne. " + (titulaires.length - 1) + " joueurs titulaires max.");
		}
		int i = 0;
		while (titulaires[i] != null) {
			i++;
		}
		while (i < titulaires.length) {
			if (detientJoueur(j)) {
				throw new IllegalStateException(
						"Le joueur " + j.getNumeroDeLicence() + " fait deja partie de l'équipe.");
			}
		}
		titulaires[i] = j;
	}
	
	public void ajouterJoueurRemplacant(Joueur j) throws IllegalStateException {
		if (j.getPoste() == Poste.GARDIEN) {
			throw new IllegalStateException("Depuis quand une equipe de foot a plusieurs gardiens ??");
		}
		if (estPlein(remplacants)) {
			throw new IllegalStateException(
					(remplacants.length - 1) + " joueurs remplacants max.");
		}
		int i = 0;
		while (remplacants[i] != null) {
			i++;
		}
		while (i < remplacants.length) {
			if (detientJoueur(j)) {
				throw new IllegalStateException(
						"Le joueur " + j.getNumeroDeLicence() + " fait deja partie de l'équipe.");
			}
		}
		remplacants[i] = j;
	}
}
