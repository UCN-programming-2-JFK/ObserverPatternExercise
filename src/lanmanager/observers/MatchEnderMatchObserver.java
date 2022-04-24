package lanmanager.observers;

import java.util.Random;
import lanmanager.interfaces.MatchObserver;
import lanmanager.model.Match;

public class MatchEnderMatchObserver implements MatchObserver {

	@Override
	public void notifyObserver(Match match) {
		if(match.getWinner()== null) {
			Random rnd = new Random();
			if(rnd.nextInt(2) == 0) {
				System.out.println("[MATCH ENDER] setting winner to player one");
				match.setWinner(match.getPlayerOne());
				return;
			}
			System.out.println("[MATCH ENDER] setting winner to player two");
			match.setWinner(match.getPlayerTwo());
		}
	}
}