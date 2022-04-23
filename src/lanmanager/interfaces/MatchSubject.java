package lanmanager.interfaces;

import lanmanager.model.Match;

public interface MatchSubject
{
    public void registerMatchObserver(MatchObserver MatchObserver);
    public void unregisterMatchObserver(MatchObserver MatchObserver);
    public void notifyMatchObservers(Match Match);
}