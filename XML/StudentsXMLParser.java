
import java.io.File;

import parser.XMLParser;

public class StudentsXMLParser {

	public static XMLParser create(XMLParser type, File srcXml) {

		type.setInputXmlFile(srcXml);
	}
}