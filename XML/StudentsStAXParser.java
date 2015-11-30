
import java.io.InputStream;

import javax.xml.stream.XMLEventReader;

import javax.xml.stream.XMLStreamConstants;

import javax.xml.stream.events.XMLEvent;

import javax.xml.stream.events.StartElement;

import javax.xml.stream.events.Characters;

import parser.stax.StaxParser;


public class StudentsStAXParser extends StaxParser {

	private boolean bFirstName = false;
	private boolean bLastName = false;
	private boolean bAge = false;

	public StudentsStAXParser(InputStream xml) {

		super(xml);
	}

	public void parse() {

		StringBuilder xmlString = this.getXmlStringBuilder();

		XMLEventReader eventReader = this.getEventReader();

		int i = 0;

		try {

			while (eventReader.hasNext()) {

				XMLEvent event = eventReader.nextEvent();

				switch (event.getEventType()) {

					case XMLStreamConstants.START_ELEMENT:

						StartElement startElement = event.asStartElement();

						String qName = startElement.getName().getLocalPart();

						if (qName.equalsIgnoreCase("student")) {

							xmlString.append("Current element - student (" + (++i) + "): \n");

						} else if (qName.equalsIgnoreCase("first-name")) {

							bFirstName = true;

						} else if (qName.equalsIgnoreCase("last-name")) {

							bLastName = true;

						} else if (qName.equalsIgnoreCase("age")) {

							bAge = true;
						}

						break;

					case XMLStreamConstants.CHARACTERS:

						Characters characters = event.asCharacters();

						if (bFirstName) {

							xmlString.append("\t- First Name: "

									+ characters.getData()

								+ "\n");

							bFirstName = false;
						}

						if (bLastName) {

							xmlString.append("\t- Last Name: "

									+ characters.getData()

								+ "\n");

							bLastName = false;
						}

						if (bAge) {

							xmlString.append("\t- Age: "

									+ characters.getData()

								+ "\n");

							bAge = false;
						}

						break;

					case XMLStreamConstants.END_ELEMENT:

						// ...
				}
			}

		} catch (Exception e) {

			e.printStackTrace();

			// ...
		}
	}
}