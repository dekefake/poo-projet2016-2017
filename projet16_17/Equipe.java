package projet16_17;

public class Equipe {
	private Joueur[] titulaires, remplacants;

	public Equipe(int nbTitulaire, int nbRemplacants) {
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
}
