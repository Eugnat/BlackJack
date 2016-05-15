package blackjack;

public class Dealer {
	
	private Hand dealerHand;

	public Hand getHand()
	{
		return dealerHand;
	}
	
	Dealer()
	{
		dealerHand = new Hand();
	}

}
