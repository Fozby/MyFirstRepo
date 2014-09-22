package ken.notken.lol;

public class Card
{
	Suit mySuit;
	Rank myRank;
	String myFilePath;
	
	//Testing
	String name;

	//Testing
	public Card(String name, String filePath)
	{
		this.name = name;
		myFilePath = filePath;
	}
	
	//Testing
	public Card(Suit suit, Rank rank, String filePath, String name)
	{
		this(suit, rank, filePath);
		this.name = name;
	}
	
	public Card(Suit suit, Rank rank, String filePath)
	{
		mySuit = suit;
		myRank = rank;
		myFilePath = filePath;
	}
	
//	public Card(String suit, int rank, String filePath)
//	{
//		myFilePath = filePath;
//		
//		if ("Spades".equals(suit))
//		{
//			mySuit = Suit.SPADES;
//		}
//		else if ("Hearts".equals(suit))
//		{
//			mySuit = Suit.HEARTS;
//		}
//		else if ("Clubs".equals(suit))
//		{
//			mySuit = Suit.CLUBS;
//		}
//		else if ("Diamonds".equals(suit))
//		{
//			mySuit = Suit.DIAMONDS;
//		}
//		
//		switch (rank)
//		{
//			case 2:
//				myRank = Rank.Two;
//			case 3:
//				myRank = Rank.Three;
//			case 4:
//				myRank = Rank.Four;
//			case 5:
//				myRank = Rank.Five;
//			case 6:
//				myRank = Rank.Six;
//			case 7:
//				myRank = Rank.Seven;
//			case 8:
//				myRank = Rank.Eight;
//			case 9:
//				myRank = Rank.Nine;
//			case 10:
//				myRank = Rank.Ten;
//			case 11:
//				myRank = Rank.Jack;
//			case 12:
//				myRank = Rank.Queen;
//			case 13:
//				myRank = Rank.King;
//			case 14:
//				myRank = Rank.Ace;
//		}
//	}
}