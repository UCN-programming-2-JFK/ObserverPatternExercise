import java.util.*;

import lanmanager.LanManagerMatchSubject;
import lanmanager.interfaces.MatchObserver;
import lanmanager.model.*;
import lanmanager.observers.*;

public class Program {

	
	private static List<Match> matches = new ArrayList<Match>();
	private static Match matchOne = new Match(new Player("DarkW1ngDuck!"), new Player("!B0z0r"));
	private static Match matchTwo = new Match(new Player("L337W1nner"), new Player("Args_n0t_F0und")); 
	private static Match matchThree =new Match(new Player("P1R8K1ller"), new Player("Rand0mBot")); 
	private static LanManagerMatchSubject lanManager = new LanManagerMatchSubject();	
	private static MatchObserver newsAgentObserver = new NewsAgentMatchObserver();
	private static MatchObserver randomMatchEnder = new MatchEnderMatchObserver();
	private static MatchObserver prizeAwarderObserver= new PrizeAwarderMatchObserver(5);
	private static 	MatchObserver nextMatchObserver = new NextMatchObserver(matchTwo, matchThree, matches);
	
	private static void init() {
		matches.add(matchOne);
		matches.add(matchTwo);
		matches.add(matchThree);
		
		matchOne.setWinner(matchOne.getPlayerOne());
		matchTwo.setWinner(matchOne.getPlayerTwo());
	}
	
	public static void main(String[] args) {
		
		init();
		lanManager.registerMatchObserver(newsAgentObserver);	
		lanManager.registerMatchObserver(prizeAwarderObserver);
		notifyAllMatches();
		
		//lanManager.unregisterMatchObserver(newsAgentObserver);
		
		lanManager.registerMatchObserver(randomMatchEnder);
		
		notifyAllMatches();

		lanManager.unregisterMatchObserver(randomMatchEnder);
		
		lanManager.registerMatchObserver(nextMatchObserver);
		
		notifyAllMatches();
		
		System.out.println("Number of matches: " + matches.size());
		Match newMatch = matches.get(3);
		System.out.println("New match: ");
		System.out.println(newMatch);
		System.out.println();

	}

	private static void notifyAllMatches() {
		
		System.out.println("NOTIFYING ALL MATCHES");
		for(int i = 0; i < matches.size(); i++) {
			
			lanManager.notifyMatchObservers(matches.get(i));
		}
		System.out.println();
	}
}