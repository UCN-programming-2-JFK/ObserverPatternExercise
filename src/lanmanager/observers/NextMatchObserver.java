package lanmanager.observers;

import java.util.ArrayList;
import java.util.List;

import lanmanager.interfaces.MatchObserver;
import lanmanager.model.Match;
import lanmanager.model.Player;

public class NextMatchObserver implements MatchObserver {

	private List<Match> matchesToWatch = new ArrayList<Match>();
	private List<Match> finishedMatches = new ArrayList<Match>();
	private List<Match> allMatches;

	public NextMatchObserver(Match matchOne, Match matchTwo, List<Match> allMatches) {
		matchesToWatch.add(matchOne);
		matchesToWatch.add(matchTwo);
		this.allMatches = allMatches;
	}

	@Override
	public void notifyObserver(Match match) {
		if (!finishedMatches.contains(match) && matchesToWatch.contains(match) && match.getWinner() != null) {
			finishedMatches.add(match);

			if (finishedMatches.size() == 2) {
				Player winnerOfMatchOne = finishedMatches.get(0).getWinner();
				Player winnerOfMatchTwo = finishedMatches.get(1).getWinner();
				Match newMatch = new Match(winnerOfMatchOne, winnerOfMatchTwo);
				allMatches.add(newMatch);
			}
		}
	}
}