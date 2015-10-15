
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class CopyBytes {

	private static final String PATH_FILE_SRC = "SomeData.txt";
	private static final String PATH_FILE_DIST = "Result.txt";
	
	public static void main(String[] args) throws IOException {
	
		FileInputStream in = null;
		FileOutputStream out = null;
		
		try {
			
			in = new FileInputStream(PATH_FILE_SRC);
			out = new FileOutputStream(PATH_FILE_DIST);
			
			int c;
			while ((c = in.read()) != -1) {
				out.write(c);
			}
		}
		finally {
			if (in != null) {
				in.close();
			}
			if (out != null) {
				out.close();
			}
		}
	}
}