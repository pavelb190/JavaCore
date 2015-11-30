
//import parser.dom.DomParser;

import java.io.File;

import parser.XMLParser;

import org.w3c.dom.Document;

public class TestDemo {

	public static void main(String[] args) {

		StudentsParser studentsParser = StudentsXMLParser.create(new StudentsDOMParser(), new File("Students.xml"));

		System.out.println("Result: " + studentsParser.getResult());
	}
}