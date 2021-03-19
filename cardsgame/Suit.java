package cardsgame;

import java.util.HashMap;
import java.util.Map;

public enum Suit {
	CLUBS("Clubs"), DIAMONDS("Diamonds"), HEARTS("Hearts"), SPADES("Spades");

	// Private fields
	private final String suitText;

	// Constructor
	Suit(String suitText) {
		this.suitText = suitText;
	}

	private static final Map<String, Suit> suit = new HashMap<String, Suit>();

	static {
		for (Suit d : Suit.values()) {
			suit.put(d.getSuit(), d);
		}
	}

	public static Suit get(String abbreviation) {
		return suit.get(abbreviation);
	}

	/**
	 * Method getSuit
	 * 
	 * @return suit value
	 */
	public String getSuit() {
		return this.suitText;
	}
}
