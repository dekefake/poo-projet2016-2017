package projet16_17;

import java.io.Serializable;

public enum Poste implements Serializable{
	GARDIEN, DEFENSEUR, MILIEU, ATTAQUANT;

	public boolean isPoste(String s) {
		return (s.equals("Gardien") || s.equals("Defenseur") || s.equals("Milieu") || s.equals("Attaquant"));
	}

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
