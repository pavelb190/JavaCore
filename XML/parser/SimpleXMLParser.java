
package parser;

import java.io.InputStream;

public abstract class SimpleXMLParser implements XMLParser {

	private InputStream xml;

	public SimpleXMLParser(InputStream xml) {

		this.xml = xml;
	}

	public InputStream getXml() {

		return xml;
	}

	/* public void parse() must be implemented in subclasses!.. */
}