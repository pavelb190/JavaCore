
public class Task7 {
	public static void main(String[] args) {
		final String str = "aaa   BBBcccc";
		System.out.println(toCompress(str));
	}
	private static String toCompress(final String src) {
		StringBuilder dist = new StringBuilder();
		char[] chars = src.toCharArray();
		int c, i, j;
		for(i = 0; i < chars.length - 1; i++) {
			c = 1;
			for(j = i + 1; j < chars.length; j++) {
				if (chars[i] == chars[j]) {
					
					c++;
				}
				else {
					
					break;
				}
			}
			dist.append("" + chars[i] + c);
			i = --j;
		}
		
		return (src.length() < dist.length() ? src : dist.toString());
	}
}