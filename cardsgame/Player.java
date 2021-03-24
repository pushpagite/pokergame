package cardsgame;

import java.util.ArrayList;

public class Player {
	String playerName;
	boolean isSameColor;
	boolean isSameNumber;
	int point;

	// Empty array for cards in hand of the player
	Card inHandCard[] = new Card[3];

	// Assigning the Player name
	public Player(String playerName) {
		this.playerName = playerName;
	}

	// Shows Cards in hand of the Player
	public void showInhandCard() {
		for (int i = 0; i < inHandCard.length; i++) {
			System.out.println(inHandCard[i]);
		}
	}

}
