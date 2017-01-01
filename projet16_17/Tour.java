package projet16_17;

import java.io.Serializable;
import java.util.*;

public class Tour implements Serializable{
	private static ArrayList<Match> matchs;
	
	public Tour(ArrayList<Match> m){
		matchs=m;
	}
	
	public Equipe executerTournoi(){ // retourne lequipe gagnante
		Iterator<Match> i= matchs.iterator();
		Equipe a, b, w=null;
		ArrayList<Match> prochainTour=null;
		if(matchs.size()>=2){
			while(i.hasNext()){
				a=((Match)i.next()).jouerMatch();
				b=((Match)i.next()).jouerMatch();
				prochainTour.add(new Match(a,b));
			}
			matchs=prochainTour;
			executerTournoi();
		} else { // FINALE !!
			if(i.hasNext()){
				w=((Match)i.next()).jouerMatch();
			}
		}
		return w;
	}
}