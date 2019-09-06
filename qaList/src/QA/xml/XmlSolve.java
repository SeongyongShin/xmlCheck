package QA.xml;

import java.io.IOException;
import java.io.StringReader;
import java.util.Stack;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.InputSource;
import org.xml.sax.SAXException;

public class XmlSolve {
	Stack<String> tag;
	Stack<String> name;
	Stack<String> field;
	
	public String solve(String xml) throws ParserConfigurationException, SAXException, IOException {
		String msg = "정상적인 xml 이 아닙니다.";
		InputSource is;
		DocumentBuilderFactory factory;
		DocumentBuilder documentBuilder;
		Document document;
		Element root;
		NodeList children = null;
		try {
			xml = xml.substring(xml.indexOf('<'));
			is = new InputSource(new StringReader(xml));
			factory = DocumentBuilderFactory.newInstance();
			documentBuilder = factory.newDocumentBuilder();
			document = documentBuilder.parse(is);
			root = document.getDocumentElement();
			children = root.getChildNodes();
			for(int i=0;i<children.getLength();i++) {
				getNode(children.item(i));
				System.out.println("-------------");
			}
			msg = "정상 xml 입니다.";
			System.out.println("정상 종료");
		}catch (Exception e) {
			e.printStackTrace();
			System.out.println("정상적인 xml 이 아닙니다.");
		}
		return msg;
	}
	 
	
	public static void getNode(Node n) {

	           for(Node ch=n.getFirstChild(); ch!=null; ch = ch.getNextSibling()) {

	                     if(ch.getNodeType() == Node.ELEMENT_NODE) {
	                    	 //System.out.print( "<" +ch.getNodeName() + ">");
	                    	 System.out.print( "<" +n.getNodeName() + ">");
	                                getNode(ch);
	                     }
	                     else if(ch.getNodeType() == Node.TEXT_NODE &&
	                                           ch.getNodeValue().trim().length() != 0) {
	                    	 
	                    	 System.out.print( "<" +n.getNodeName() + ">");
	                                System.out.println(ch.getNodeValue());
	                                
	                     }

	           }

	}



}
