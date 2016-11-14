package projet16_17;

import java.util.Calendar;

public class Match {
	private Equipe equipeA, equipeB;
	private Arbitre mrLArbitre;
	private Calendar heureDebut;
	private final int temps = 45;
	private final int pause = 15;
	private final int nbtemps = 2;
	private final int tempstotal = temps * nbtemps;
	private int [] score = new int [2]; // Score de l'equipe A = score[0], Score de l'equipe A = score[1].. TRIVIAL
}
