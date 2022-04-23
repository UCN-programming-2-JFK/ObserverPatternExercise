package lanmanager.interfaces;

import lanmanager.model.Match;

public interface MatchObserver {
	abstract public void notify(Match Match);
}