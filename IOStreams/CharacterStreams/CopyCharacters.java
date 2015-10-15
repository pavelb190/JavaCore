
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class CopyCharacters {
	
	private static final String PATH_FILE_SRC = "SomeData.txt";
	private static final String PATH_FILE_DIST = "Result.txt";

	public static void main(String[] args) throws IOException {
		
		FileReader inputStream = null;
		FileWriter outputStream = null;
		
		try {
			
			inputStream = new FileReader(PATH_FILE_SRC);
			outputStream = new FileWriter(PATH_FILE_DIST);
			
			int c;
			while ((c = inputStream.read()) != -1) {
				outputStream.write(c);
			}
		}
		finally {
			if (inputStream != null) {
				inputStream.close();
			}
			if (outputStream != null) {
				outputStream.close();
			}
		}
	}
}