

public class Task5 {
	
	public static void main(String[] args) {
		final String str = "a b c d e f g h";
		System.out.println(isAllCharsOccurOnce(str));
	}
	
	private static boolean isAllCharsOccurOnce(final String str) {
		char[] chars = str.toCharArray();
		for(int i = 0; i < chars.length; i++) {
			/* Exclude empty spaces;*/
			if (chars[i] != ' ') {
				for(int j = i + 1; j < chars.length - 1; j++) {
					if (chars[i] == chars[j]) {
						
						return false;
					}
				}
			}
		}
		return true;
	}
}