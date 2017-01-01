package projet16_17;

import java.util.Calendar;

public class Joueur extends Licencie {

	private Poste poste;
	private int numeroDeMaillot;

	public Joueur(int licence, String nm, String p, Calendar d, Club c, Poste pst, int nMaillot) {
		super(licence, nm, p, d, c);
		poste = pst;
		numeroDeMaillot=nMaillot;
	}

	public Poste getPoste() {
		return poste;
	}
	
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Joueur other = (Joueur) obj;
		return other.getNumeroDeLicence()==getNumeroDeLicence();
	}
	
	public String toString(){
		return super.toString()+" Qualité : Joueur Poste : "+poste+" Maillot n°"+numeroDeMaillot;
	}
}
