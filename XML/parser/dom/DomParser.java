
package parser.dom;

import java.io.File;

import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.DocumentBuilder;

import org.w3c.dom.Document;

import parser.XMLParser;


public class DomParser implements XMLParser {

	private static final DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();

	private DocumentBuilder dBuilder;

	private File inputXmlFile;

	private Document document = null;

	public DomParser() {

		try {

			this.dBuilder = dbFactory.newDocumentBuilder();

		} catch (Exception e) {

			e.printStackTrace();

			// ...
		}
	}

	public DomParser(File srcXml) {

		this();

		setInputXmlFile(srcXml);
	}

	public void setInputXmlFile(File srcXml) {

		this.inputXmlFile = srcXml;
	}

	public void parse() {

		try {

			document = dBuilder.parse(this.inputXmlFile);

		} catch (Exception e) {

			e.printStackTrace();

			// ...
		}
	}

	public Document getDocument() {

		return document;
	}
}