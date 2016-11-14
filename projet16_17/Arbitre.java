package projet16_17;

import java.util.Calendar;

public class Arbitre extends Licencie {
	private int categorie;

	public Arbitre(int licence, String nm, String p, Calendar d, Club c, int cat) throws IllegalArgumentException {
		super(licence, nm, p, d, c);
		if (cat < 1 || cat > 3) {
			throw new IllegalArgumentException(
					"Le niveau de l'arbitre est incorrect. Les niveaux valables vont de 1 à 3.");
		} else {
			categorie = cat;
		}
	}
}
