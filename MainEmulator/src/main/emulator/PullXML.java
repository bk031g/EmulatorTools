package main.emulator;

import java.io.IOException;
import java.util.List;

import org.jdom2.Document;
import org.jdom2.Element;
import org.jdom2.JDOMException;
import org.jdom2.input.SAXBuilder;

public class PullXML {
	
	public static Document document;
	public List<Element> sectionList;
	public Element sectionElement;
	
	
	public static void main(String[] args) throws JDOMException, IOException{
        SAXBuilder saxBuilder = new SAXBuilder();
        document = saxBuilder.build("http://10.27.99.62/restapi/jobs/C1A0F034-2EE9-4757-B357-64CF639719CB");
        
        System.out.println(document.getRootElement().getChildText("state"));
        
	}

}
