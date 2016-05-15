package blackjack;

import java.util.LinkedList;
import java.util.List;

public class Hand {
	
	private List<Card> handList;
	
	private boolean busted = false;
	private boolean blackJack = false;
	private int bestValue;
	
	public Hand() {
		handList = new LinkedList<>();
	}
	
	
	
	public void addCard()
	{
		handList.add(CardDeck.dealCard());
	}
	
	public int getHandHardValue()
	{
		int handHardValue = 0;
		
		for (Card card : handList)
			 handHardValue += card.getRank().getHardValue();
		
		return handHardValue;
	}
	
	public int getHandSoftValue()
	{
		int handSoftValue = 0;
		for (Card card : handList)
			handSoftValue += card.getRank().getSoftValue();
		
		return handSoftValue;
	}
	
	public boolean checkBusted()
	{
		busted = getBestValue() > 21;
		return busted;
	}

	public boolean checkBlackJack()
	{
		blackJack = getBestValue() == 21;
		return blackJack;
	}
	
	public int getBestValue()
	{
		bestValue = getHandSoftValue() <= 22 ? getHandSoftValue() : getHandHardValue();
		return bestValue;
	}
	
	public void displayHand()
	{
		for (Card card : handList)
			System.out.println(card);
	}
	
	public void displayFirstCard()
	{
		System.out.println(handList.get(0));
	}
	
	
	
}
