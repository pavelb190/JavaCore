
import java.util.Arrays;


public class Task1 {
	
	private static final String textString = "Some Big String of Text.";
	
	public static void main(String[] args) {
		if (args.length >= 2) {
			
			System.out.println(replaceChar(textString, args[0].charAt(0), Integer.parseInt(args[1])));
		}
		else {
			
			System.out.println("Some parameter not Specified!");
		}
	}
	private static String replaceChar(final String src, char ch, int k) {
		
		StringBuilder dist = new StringBuilder();
		
		String[] words = src.split("\\s+");
		char[] chars = new char[0];
		for(int i = 0; i < words.length; i++) {
			if (k <= words[i].length()) {
				chars = words[i].toCharArray();
				chars[k - 1] = ch;
				words[i] = new String(chars);
			}
		}
		
		for(String word : words) {
		
			dist.append(word + " ");
		}
		dist.trimToSize();
		
		return dist.toString();
	}
}