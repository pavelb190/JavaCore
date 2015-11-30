
package parser.stax;

import java.io.InputStream;

import java.xml.stream.XMLInputFactory;
import java.xml.stream.XMLEventReader;

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

	public void parse() {

		// Must be overrided for each implementing subclass!..
	}
}