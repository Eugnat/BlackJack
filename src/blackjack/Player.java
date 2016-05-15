package blackjack;

public class Player {
	
	private Hand playerHand;

	public Hand getHand()
	{
		return playerHand;
	}
	
	Player()
	{
		playerHand = new Hand();
	}
}
