
public class TheStringTask {
	public static void main(String[] args) {
		final String str = "This is my looooOOOoong String!!!..";
		System.out.println("Source string: " + str + " (" + str.length() + ")");
		//System.out.println("The String-length is: " + str.length());
		int middle = (str.length() - 1) / 2;	//The middle position on str. ((int)result);
		String part1 = str.substring(0, middle);
		String part2 = str.substring(middle);
		System.out.println("Part #1: " + part1 + " (" + part1.length() + ")");
		System.out.println("Part #2: " + part2 + " (" + part2.length() + ")");
	}
}