
public class Task3 {
	public static void main(String[] args) {
		final String str = "I'm living in Minsk, Pushkina 20. (Temporally.)";
		System.out.println(removeAllNonLetters(str));
	}
	private static String removeAllNonLetters(final String src) {
		StringBuilder dist = new StringBuilder(src);
		//char[] chars = src.toCharArray();
		char ch = 0;
		for(int i = 0; i < dist.length(); i++) {
			ch = dist.charAt(i);
			if (!Character.isLetter(ch) && !Character.isWhitespace(ch)) {
				dist.deleteCharAt(i);
				i--;
			}
		}
		return dist.toString();
	}
}