
package parser.sax;

import java.io.InputStream;

import javax.xml.parsers.SAXParserFactory;
import javax.xml.parsers.SAXParser;

import org.xml.sax.helpers.DefaultHandler;

import parser.SimpleXMLParser;

public class SaxParser extends SimpleXMLParser {

	private static final SAXParserFactory factory = SAXParserFactory.newInstance();

	private SAXParser saxParser;

	private DefaultHandler parseHandler = null;

	public SaxParser(InputStream xml) {

		super(xml);

		try {

			this.saxParser = factory.newSAXParser();

		} catch (Exception e) {

			e.printStackTrace();

			// ...
		}
	}

	public void setParseHandler(DefaultHandler handler) {

		this.parseHandler = handler;
	}

	public void parse() {

		if (parseHandler == null) {

			throw new Excpetion("Parse-Handler not Specified!");
		}

		saxParser.parse(this.getXml(), parseHandler);
	}
}