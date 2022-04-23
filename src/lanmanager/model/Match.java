package lanmanager.model;

import java.util.*;

public class Match {

	private List<Player> players = new ArrayList<Player>();
	private Player winner;

	public Match(Player player1, Player player2) {
		players.add(player1);
		players.add(player2);
	}
	
	public Player getWinner() {return winner;}
	public void setWinner(Player player) {winner = player;}
	
}