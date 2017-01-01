package projet16_17;

import java.io.Serializable;

public class Club implements Serializable{
	
	private String nom, ville;

	public Club(String n, String v) {
		nom = n;
		ville = v;
	}
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Club other = (Club) obj;
		if (nom == null) {
			if (other.nom != null)
				return false;
		} else if (!nom.equals(other.nom))
			return false;
		if (ville == null) {
			if (other.ville != null)
				return false;
		} else if (!ville.equals(other.ville))
			return false;
		return true;
	}
	public String getNom(){
		return nom;
	}
}