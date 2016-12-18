package projet16_17;

import java.util.*;

public class Tour {
	private ArrayList<Match> matchs;
	
	public Tour(ArrayList<Match> m){
		matchs=m;
	}
	
	public Tour executerTour(){
		Iterator i= matchs.iterator();
		Equipe a, b, w;
		ArrayList<Match> prochainTour=null;
		if(matchs.size()>=2){
			while(i.hasNext()){
				a=((Match)i.next()).jouerMatch();
				b=((Match)i.next()).jouerMatch();
				prochainTour.add(new Match(a,b));
			}
		} else { // FINALE !!
			if(i.hasNext()){
				w=((Match)i.next()).jouerMatch();
				prochainTour.add(new Match(w,w));
			}
		}
		return new Tour(prochainTour);
	}
}