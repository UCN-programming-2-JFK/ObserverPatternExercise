package lanmanager.model;

import java.util.*;

public class Match {

	private List<Player> players = new ArrayList<Player>();
	private Player winner;

	public Match(Player player1, Player player2) {
		players.add(player1);
		players.add(player2);
	}
	
	public Player getPlayerOne() {
		return players.get(0);
	}
	
	public Player getPlayerTwo() {
		return players.get(1);
	}
	
	public Player getWinner() {return winner;}
	public void setWinner(Player player) {winner = player;}
	@Override
	public String toString() {
		return "Match between " + getPlayerOne().getGamerTag() + " and " + getPlayerTwo().getGamerTag() 
				+ (getWinner() == null ? " no winner yet." : ". Winner was " + getWinner().getGamerTag()); 
	}
}