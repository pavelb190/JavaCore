

public class Task6 {
	public static void main(String[] args) {
		final String str1 = "abcdef";
		final String str2 = "fedcba";
		System.out.println(isReversed(str1, str2));
	}
	private static boolean isReversed(final String str1, final String str2) {
		char[] chars1 = str1.toCharArray();
		char[] chars2 = str2.toCharArray();
		int n = chars1.length;
		for(int i = 0; i < n; i++) {
			if (chars1[i] != chars2[n - i - 1]) {
				
				return false;
			}
		}
		return true;
	}
}