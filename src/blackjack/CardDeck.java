package blackjack;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

public class CardDeck {
	
	static List<Card> list = new ArrayList<>();
	
	private final int stopNumber = 17;
	
	CardDeck() {
		createDeck();
	}
	
	private void createDeck()
	{
	for (Suit suit : Suit.values())
		for (Rank rank : Rank.values())
			list.add(new Card(suit, rank));
	
	Collections.shuffle(list, new Random());
	}

	
	public boolean checkStopDeal()
	{
		if (list.size() < stopNumber)
			return true;
		else return false;
	}
	
	public int listSize()
	{
		return list.size();
	}
	
	static public Card dealCard() {
		Card card = list.get(0);
		list.remove(0);
		return card;
	}
	
}
