# Observer Pattern Exercise
This repository contains the solution to an exercise, where the student must implement the subscriber/listener classes for a system which manages a LAN gaming event.

<img src="https://github.com/UCN-programming-2-JFK/ObserverPatternExercise/assets/3811290/fc1992ca-72e6-4992-863b-e9d1408a813e" width="300"/>


The solution uses the software design pattern [Observer](https://en.wikipedia.org/wiki/Observer_pattern) to solve the challenge. 

# Classes
The solution contains 
- the model classes [Match](https://github.com/UCN-programming-2-JFK/ObserverPatternExercise/blob/master/src/lanmanager/model/Match.java) and [Player](https://github.com/UCN-programming-2-JFK/ObserverPatternExercise/blob/master/src/lanmanager/model/Player.java)
- the Subject class (the publisher of match events) [LanManagerMatchSubject](https://github.com/UCN-programming-2-JFK/ObserverPatternExercise/blob/master/src/lanmanager/LanManagerMatchSubject.java)
- the interface [MatchObserver](https://github.com/UCN-programming-2-JFK/ObserverPatternExercise/blob/master/src/lanmanager/interfaces/MatchObserver.java), which describes the subscribers that can be notified when a change in a match occurs 
```java
    public interface MatchObserver {
	          abstract public void notifyObserver (Match match);
    }
```
- four implementing observer classes
  - [MatchEnderMatchObserver](https://github.com/UCN-programming-2-JFK/ObserverPatternExercise/blob/master/src/lanmanager/observers/MatchEnderMatchObserver.java) which, when called check whether there is a winner on the supplied Match argument, and if not, then sets a random winner.
  - [NewsAgentMatchObserver](https://github.com/UCN-programming-2-JFK/ObserverPatternExercise/blob/master/src/lanmanager/observers/NewsAgentMatchObserver.java) which simulates notifying a news media by printing the winner to the console
  - [NextMatchObserver](https://github.com/UCN-programming-2-JFK/ObserverPatternExercise/blob/master/src/lanmanager/observers/NextMatchObserver.java) which observes two matches and when they are done, starts a new match with the winners of the two previous matches. This could be useful for managing a cup style event, where winners of the previous two matches meet each other in a new match.
  - [PrizeAwarderMatchObserver](https://github.com/UCN-programming-2-JFK/ObserverPatternExercise/blob/master/src/lanmanager/observers/PrizeAwarderMatchObserver.java) which keeps track of how many prizes are left for the competitions.
