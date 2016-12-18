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
	private int scoreA, scoreB;
	
	public Match(Equipe eqA, Equipe eqB){
		equipeA=eqA;
		equipeB=eqB;
	}
	
	public int getRandScore(){
		int v=0;
		double x=Math.random();
		if(x>=0 && x<0.3){
			v=0;
		}
		if(x>0.3 && x<0.7){
			v=1;
		}
		if(x>0.7 && x<0.88){
			v=2;
		}
		if(x>0.88 && x>1){
			v=(int)(x-0.8)*50;
		}
		return v;
	}
	
	public void concoursJongles(){
		int a=0,b=0;
		do {
			a=(int)Math.random()*1000;
			b=(int)Math.random()*1000;
		} while(a==b);
		if(a<b){
			scoreB++;
		} else {
			scoreA++;
		}
	}
	
	public Equipe jouerMatch(){ // Retourne l'equipe gagnante
		scoreA=getRandScore();
		scoreB=getRandScore();
		if(scoreA==scoreB){
			concoursJongles();
		}
		if(scoreA>scoreB){
			return equipeA;
		} else {
			return equipeB;
		}
	}
}
