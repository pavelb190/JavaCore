
import java.util.Arrays;


public class Task2 {
	public static void main(String[] args) {
		final String str = "Some string of text.";
		//showResult(str);
		replaceLettersByNumbers(str);
		//System.out.println(replaceLettersByNumbers(str));
	}
	public static String replaceLettersByNumbers(final String str) {
		
		int[] positions = getLettersPositions(str);
		
		showResult(str, positions);
		
		return null;
	}
	private static void showResult(final String str, int[] positions) {
		char[] chars = str.toCharArray();
		for(int i = 0; i < chars.length; i++) {
			System.out.printf("%2c ", chars[i]);
		}
		System.out.println();
		for(int i = 0; i < positions.length; i++) {
			System.out.printf("%2d ", positions[i]);
		}
	}
	private static int[] getLettersPositions(final String str) {
		char[] chars = str.toCharArray();
		int[] positions = new int[chars.length];
		for(int i = 0; i < chars.length; i++) {
			positions[i] = getNumberInAlphabet(chars[i]);
		}
		return positions;
	}
	private static int getNumberInAlphabet(char ch) {
		
		final String alphabet = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
		
		return alphabet.indexOf(Character.toUpperCase(ch)) + 1;
	}
}