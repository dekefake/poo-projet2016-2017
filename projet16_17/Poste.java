package projet16_17;

public enum Poste {
	GARDIEN, DEFENSEUR, MILIEU, ATTAQUANT;

	public String toString() {
		switch (this) {
		case GARDIEN:
			return "Gardien";
		case DEFENSEUR:
			return "Defenseur";
		case MILIEU:
			return "Milieu";
		case ATTAQUANT:
			return "Attaquant";
		default:
			return "";
		}

	}
}
