

public class Task4 {
	public static void main(String[] args) {
		final String str = "Aaa bBbb cCCcc 		dDdd  eEEE f";
		String resStr = removeWordsStartWithConsonant(str, 4);
		System.out.println(resStr);
	}
	private static boolean isConsonant(char ch) {
		
		return ("bcdfghjklmnpqrstvwxz".indexOf(Character.toLowerCase(ch)) > -1);
	}
	private static String removeWordsStartWithConsonant(final String src, int n) {
		StringBuilder str = new StringBuilder();
		String[] words = src.split("\\s+");
		for(int i = 0; i < words.length; i++) {
			if (!(isConsonant(words[i].charAt(0)) && n == words[i].length())) {
				str.append(words[i] + " ");
			}
		}
		str.trimToSize();
		
		return str.toString();
	}
}