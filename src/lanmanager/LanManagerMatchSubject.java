package lanmanager;

import java.util.ArrayList;

import lanmanager.interfaces.MatchObserver;
import lanmanager.interfaces.MatchSubject;
import lanmanager.model.Match;

public class LanManagerMatchSubject implements MatchSubject{

	private ArrayList<MatchObserver> observerList = new ArrayList<MatchObserver>();

	@Override
	public void registerMatchObserver(MatchObserver observer) {
		observerList.add(observer);
	}

	@Override
	public void unregisterMatchObserver(MatchObserver observer) {
		observerList.remove(observer);
	}

	@Override
	public void notifyMatchObservers(Match match) {
		for (MatchObserver observer : observerList) {
			observer.notifyObserver(match);
		}
	}
}