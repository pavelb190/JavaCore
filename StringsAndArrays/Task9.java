
import java.util.Arrays;


public class Task9 {
	public static void main(String[] args) {
		final String s1 = "waterbottle";
		final String s2 = "erbottlewat";
		System.out.println(isSubstring(s1, s2));
	}
	private static boolean isSubstring(final String src, final String from) {
		char[] srcChars = src.toCharArray();
		char[] fromChars = from.toCharArray();
		char firstCh = 0;
		for(int i = 0; i < srcChars.length; i++) {
			if (Arrays.equals(srcChars, fromChars)) {
				
				return true;
			}
			else {
				/* Move to the Left side (easier ;)*/
				firstCh = srcChars[0];
				for(int j = 0; j < srcChars.length - 1; j++) {
					srcChars[j] = srcChars[j + 1];
				}
				srcChars[srcChars.length - 1] = firstCh;
			}
		}
		return false;
	}
}