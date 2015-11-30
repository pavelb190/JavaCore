
package parser.dom;

import java.io.InputStream;

import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.DocumentBuilder;

import org.w3c.dom.Document;

import parser.SimpleXMLParser;


public class DomParser extends SimpleXMLParser {

	private static final DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();

	private DocumentBuilder dBuilder;

	private Document document = null;

	public DomParser(InputStream xml) {

		super(xml);

		try {

			this.dBuilder = dbFactory.newDocumentBuilder();

		} catch (Exception e) {

			e.printStackTrace();

			// ...
		}
	}

	public void parse() {

		try {

			document = dBuilder.parse(this.getXml());

		} catch (Exception e) {

			e.printStackTrace();

			// ...
		}
	}

	public Document getDocument() {

		return document;
	}
}