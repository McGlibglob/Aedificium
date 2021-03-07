package com.aedificium.model.service;

import java.io.*;  
import javax.xml.parsers.*;  
import org.w3c.dom.*;

import com.aedificium.model.service.exceptions.FileLoadException;

public class DOMFactory {
	
	
	
	public Document getDocument() throws FileLoadException {
	DocumentBuilderFactory factory =  DocumentBuilderFactory.newInstance();
	
	try {
		
			DocumentBuilder parser =factory.newDocumentBuilder();
			Document document =parser.parse(new FileInputStream("src/main/resources/services.xml"));
			return document;
		}catch(Exception e) {
			throw new FileLoadException ("Failed to load .XML");
		}
	
	}//End of getDocument() method.
	
	
	public Element getRoot() throws FileLoadException {
		Element root;
		Document doc = getDocument();
		root = doc.getDocumentElement();
		return root;
	}//End of getRoot() method.
	
	
	public NodeList getNodeList() throws FileLoadException {
		Element root;
		root = getRoot();
		NodeList nodes = root.getChildNodes();
		
		return nodes;
	}//End of getNodeList() method
	
	
	public String getAttribute(String serviceName) throws FileLoadException {
		NodeList nodes = getNodeList();
		String implName = new String();
		
		
		for (int i=0;i<nodes.getLength();i++) {
			Node node = nodes.item(i);
			if(node instanceof Element) {
				Element element = (Element) node;
				String elementName = element.getTagName();
				
				//Check for match of Service Name.
				boolean nameMatch = elementName == serviceName;
				
				if (nameMatch) {
					implName = element.getAttribute("impl");
				}
				
			}
			
		}
		
		if (implName != null) {
			
		}
		return implName;
		
	}

}
