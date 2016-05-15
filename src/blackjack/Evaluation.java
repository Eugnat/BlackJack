package blackjack;

public class Evaluation {
	
public boolean evaluatePlayer(Player player, Dealer dealer, CardDeck deck)
	{
		if (player.getHand().checkBlackJack() && !dealer.getHand().checkBlackJack())
		{	
			System.out.println("Player wins: black jack.");
		    return true;
		}
		
		if (player.getHand().checkBusted())
		{
			System.out.println("Player busted: too much.");
			return true;
		}
		
		if (deck.checkStopDeal())
		{
			System.out.println("Stop game: too few cards.");
			return true;
		}
		
		return false;
	}
		
public void evaluateDealer (Dealer dealer, Player player)
	{
		if (dealer.getHand().checkBusted())
		  {
				System.out.printf("Dealer busted: %d. Player wins.%n", dealer.getHand().getBestValue());
				dealer.getHand().displayHand();
				return;
		  }
			
		  if (dealer.getHand().checkBlackJack())
		  {
				System.out.println("Dealer wins: black jack.");
				dealer.getHand().displayHand();
				return;
		  }

		  if (dealer.getHand().getBestValue() > player.getHand().getBestValue())
		  {
			  System.out.printf("Dealer wins: %d%n", dealer.getHand().getBestValue());
			  dealer.getHand().displayHand();
			  return;
		  }
		  
		  if (dealer.getHand().getBestValue() == player.getHand().getBestValue())
		  {
			  System.out.println("Push. No one wins.");
			  dealer.getHand().displayHand();
			  return;
		  }
		  
		  if (dealer.getHand().getBestValue() < player.getHand().getBestValue())
		  {
			  System.out.printf("Dealer hand: %d. Player wins.%n", dealer.getHand().getBestValue());
			  dealer.getHand().displayHand();
			  return;
		  } 
	}

}
