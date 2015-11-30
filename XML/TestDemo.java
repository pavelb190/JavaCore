
//import parser.dom.DomParser;

import java.io.File;
import java.io.FileInputStream;

import parser.XMLParser;

import org.w3c.dom.Document;

public class TestDemo {

	public static void main(String[] args) {

		StudentsStAXParser studentsParser = null;
		//StudentsDOMParser studentsParser = null;
		//DomParser domParser = null;

		try {

			studentsParser = new StudentsStAXParser(new FileInputStream(new File("Students.xml")));
			//studentsParser = new StudentsDOMParser(new FileInputStream(new File("Students.xml")));
			//domParser = new DomParser(new FileInputStream(new File("Students.xml")));

		} catch (Exception e) {

			e.printStackTrace();

			// ...
		}

		studentsParser.parse();
		//domParser.parse();

		//StudentsParser studentsParser = StudentsXMLParser.create(new StudentsDOMParser(), new File("Students.xml"));

		System.out.println("[Result]: \n" + studentsParser.getResult());
	}
}