package lanmanager.observers;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import lanmanager.interfaces.MatchObserver;
import lanmanager.model.Match;

public class PrizeAwarderMatchObserver implements MatchObserver {

	
	List<Match> matchesGivenPrizes = new ArrayList<Match>();
	private int numberOfPrizesInStock;
	
	public PrizeAwarderMatchObserver(int numberOfPrizesInStock) {
		setNumberOfPrizesInStock(numberOfPrizesInStock);
	}
	
	@Override
	public void notifyObserver(Match match) {
		if(match.getWinner() != null && !matchesGivenPrizes.contains(match)) {
			System.out.println("[PRIZE] Awarding prize to " + match.getWinner().getGamerTag());
			matchesGivenPrizes.add(match);
			numberOfPrizesInStock--;
		}
	}
	public int getNumberOfPrizesInStock() {
		return numberOfPrizesInStock;
	}
	
	public void setNumberOfPrizesInStock(int numberOfPrizesInStock) {
		this.numberOfPrizesInStock = numberOfPrizesInStock;
	}
	
}