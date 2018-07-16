
public class Notes {
	
	public enum MyNum{
		FIVE, SIX, SEVEN;
	}
	
	public static void main(String[] args) {
		
		MyNum num = MyNum.SIX;
		MyNum newNum = MyNum.SIX;
		
		switch (num)
		{
			case FIVE:
				newNum = MyNum.SEVEN;
			case SIX:
				System.out.println("case  6");
				newNum = MyNum.FIVE;
				System.out.println("num: " + newNum);
			case SEVEN:
				
		}
		
		System.out.println("final num" + newNum);
	}
}
