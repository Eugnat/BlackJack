package blackjack;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		
		CardDeck deck = new CardDeck();
		Dealer dealer = new Dealer();
		Player player = new Player();
		Evaluation evaluation = new Evaluation();
		
		
		for (int i = 0; i < 2; i++)
		{
			player.getHand().addCard();
			dealer.getHand().addCard();
		}
		
		System.out.printf("Player hand: %d%n", player.getHand().getBestValue());
		player.getHand().displayHand();
		System.out.println();
		
		System.out.println("Dealer hand:");
		dealer.getHand().displayFirstCard();
		
		try (Scanner sc = new Scanner(System.in);)
{
			
cycle:	while (true)
	{
		
		if (evaluation.evaluatePlayer(player, dealer, deck))
			break cycle;
		
		String action;
		System.out.println("Choose required action: H - hit, S - stand, D - double down, X - surrender.");
		action = sc.next();
		
		switch(action)
		{
			case "H": player.getHand().addCard();
					  System.out.printf("Player hand: %d%n", player.getHand().getBestValue());
					  player.getHand().displayHand();
					  break;
			case "S": while (dealer.getHand().getBestValue() <= 17)
						{
							dealer.getHand().addCard();	
						}

					  evaluation.evaluateDealer(dealer, player);
					  break cycle;
			case "D": player.getHand().addCard();
			  		  System.out.printf("Player hand: %d%n", player.getHand().getBestValue());
			  		  player.getHand().displayHand();
			  		  
			  		  if (evaluation.evaluatePlayer(player, dealer, deck))
			  			  break cycle;
			  		  
				  	  while (dealer.getHand().getBestValue() <= 17)
				  	  {
						dealer.getHand().addCard();	
					  }
				  	  
				  	  evaluation.evaluateDealer(dealer, player);
				  	  break cycle;
			case "X": System.out.println("Player loses. Game over.");
			     	  break cycle;
			default:  break cycle;
		}
	}
}
		catch (InputMismatchException e)
		{
			System.out.println(e.getMessage());
		}
		

	}
	
}
