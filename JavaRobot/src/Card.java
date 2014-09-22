public class Card
{
	public enum Suit
	{
		SPADES, HEARTS, CLUBS, DIAMONDS
	}
	
	public enum Rank
	{
		Two, Three, Four, Five, Six, Seven, Eight, Nine, Ten, Jack, Queen, King, Ace
	}
	
	Suit mySuit;
	Rank myRank;
	String myFilePath;
	
	public Card(String suit, int rank)
	{
		if ("Spades".equals(suit))
		{
			mySuit = Suit.SPADES;
		}
		else if ("Hearts".equals(suit))
		{
			mySuit = Suit.HEARTS;
		}
		else if ("Clubs".equals(suit))
		{
			mySuit = Suit.CLUBS;
		}
		else if ("Diamonds".equals(suit))
		{
			mySuit = Suit.DIAMONDS;
		}
	}
}