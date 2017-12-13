package utility;
import java.util.Random;
public class GenerateData {

	
	StringBuilder sb;
	 public String Generate()
	 {
		 char[] chars = "abcdefghijklmnopqrstuvwxyz".toCharArray();
		 StringBuilder sb = new StringBuilder();
		 Random random = new Random();
		 for (int i = 0; i < 7; i++) {
	     char c = chars[random.nextInt(chars.length)];
		 sb.append(c); 
	  }
		 String first = sb.toString();
		 return first;	 
}

	public CharSequence Zip()
		 {
			 char[] chars = "9876543210".toCharArray();
			 StringBuilder sb = new StringBuilder();
			 Random random = new Random();
			 for (int i = 0; i < 5; i++) {
		     char c = chars[random.nextInt(chars.length)];
			 sb.append(c); 
		  }
			 String Z = sb.toString();
			 return Z;	 
	}
	public CharSequence Mob() {
			 char[] chars = "1234567890".toCharArray();
			 StringBuilder sb = new StringBuilder();
			 Random random = new Random();
			 for (int i = 0; i < 10; i++) {
		     char c = chars[random.nextInt(chars.length)];
			 sb.append(c); 
		  }
			 String N = sb.toString();
			 return N;	 
}
	}