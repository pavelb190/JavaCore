
import parser.DomParser;

import java.io.File;

import org.w3c.dom.Document;

public class TestDemo {

	public static void main(String[] args) {

		DomParser domParser = new DomParser(new File("Students.xml"));

		domParser.parse();

		Document doc = domParser.getDocument();

		System.out.println(doc.getDocumentElement().getNodeName());
	}
}