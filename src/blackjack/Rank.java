package blackjack;

public enum Rank {
	TWO(2, 2), THREE(3, 3), FOUR(4, 4), FIVE(5, 5), SIX(6, 6), SEVEN(7, 7),
	EIGHT(8, 8), NINE(9, 9), TEN(10, 10), JACK(10, 10), QUEEN(10, 10), KING(10, 10), ACE(1, 11);
	
	int hardValue, softValue;
	
	
	Rank (int hardValue, int softValue)
	{
		this.hardValue = hardValue;
		this.softValue = softValue;
	}
	
	public int getHardValue() {
		return hardValue;
	}
	
	public int getSoftValue() {
		return softValue;
	}
	
}
