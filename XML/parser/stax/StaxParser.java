
package parser.stax;

import java.io.InputStream;

import javax.xml.stream.XMLInputFactory;
import javax.xml.stream.XMLEventReader;

import parser.SimpleXMLParser;

public class StaxParser extends SimpleXMLParser {

	private static final XMLInputFactory factory = XMLInputFactory.newInstance();

	private XMLEventReader eventReader;

	public StaxParser(InputStream xml) {

		super(xml);

		try {

			this.eventReader = factory.createXMLEventReader(xml);

		} catch (Exception e) {

			e.printStackTrace();

			// ...
		}
	}

	public XMLEventReader getEventReader() {

		return eventReader;
	}

	public void parse() {

		// Must be overrided by each implementing subclass!..
	}
}