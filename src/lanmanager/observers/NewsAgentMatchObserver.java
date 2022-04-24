package lanmanager.observers;

import lanmanager.interfaces.MatchObserver;
import lanmanager.model.Match;

public class NewsAgentMatchObserver implements MatchObserver {

	@Override
	public void notifyObserver(Match match) {
		if(match.getWinner() != null) {
			
			System.out.println("[NEWS] The match between " + match.getPlayerOne().getGamerTag() + " and " + match.getPlayerTwo().getGamerTag() + " is over! " + match.getWinner().getGamerTag() + " won the match!");
			return;
		}
		System.out.println("[NEWS] The match between " + match.getPlayerOne().getGamerTag() + " and " + match.getPlayerTwo().getGamerTag() + " is still being played! " );
	}
}