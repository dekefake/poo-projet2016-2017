package projet16_17;

public class Equipe {
	private Joueur[] titulaires, remplacants;

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

	public void ajouterJoueur(Joueur j) throws IllegalStateException {
		if (j.getPoste() == Poste.GARDIEN) {
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
			if (j.getNumeroDeLicence() == titulaires[i].getNumeroDeLicence()) {
				throw new IllegalStateException(
						"Le joueur " + j.getNumeroDeLicence() + " fait deja partie de l'équipe.");
			}
		}
		titulaires[i] = j;
	}
}
