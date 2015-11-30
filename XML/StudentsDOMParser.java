
import java.io.InputStream;

import parser.dom.DomParser;

import org.w3c.dom.Document;
import org.w3c.dom.NodeList;
import org.w3c.dom.Node;
import org.w3c.dom.Element;


public class StudentsDOMParser extends DomParser {

	public StudentsDOMParser(InputStream xml) {

		super(xml);
	}

	public void parse() {

		super.parse();

		Document doc = this.getDocument();

		//doc.getDocumentElement().normalize();

		StringBuilder xmlString = this.getXmlStringBuilder();

		xmlString.setLength(0);

		xmlString.append("Root element: " + doc.getDocumentElement().getNodeName() + "\n");

		NodeList nList = doc.getElementsByTagName("student");

		xmlString.append("---------------------------------\n");

		for(int i = 0; i < nList.getLength(); i++) {

			Node nNode = nList.item(i);

			xmlString.append("Current element - " + nNode.getNodeName() + " (" + (i + 1) + "): \n");

			if (nNode.getNodeType() == Node.ELEMENT_NODE) {

				Element eElement = (Element) nNode;

				xmlString.append("\t- First Name: "

					+ eElement.getElementsByTagName("first-name")
						.item(0)
						.getTextContent()

					+ "\n");

				xmlString.append("\t- Last Name: "

					+ eElement.getElementsByTagName("last-name")
						.item(0)
						.getTextContent()

					+ "\n");

				xmlString.append("\t- Age: "
					+ eElement.getElementsByTagName("age")
						.item(0)
						.getTextContent()

					+ "\n");
			}
		}
	}
}