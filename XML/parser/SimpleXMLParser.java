
package parser;

import java.io.InputStream;

public abstract class SimpleXMLParser implements XMLParser {

	private InputStream xml;

	private StringBuilder xmlStringBuilder = new StringBuilder();

	public SimpleXMLParser(InputStream xml) {

		this.xml = xml;
	}

	public InputStream getXml() {

		return xml;
	}

	public StringBuilder getXmlStringBuilder() {

		return xmlStringBuilder;
	}

	/* public void parse() must be implemented in subclasses!.. */

	public String getResult() {

		return xmlStringBuilder.toString();
	}
}