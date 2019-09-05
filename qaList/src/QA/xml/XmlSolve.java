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
		xml = xml.substring(xml.indexOf('<'));
		
		InputSource is = new InputSource(new StringReader(xml));
		DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
		DocumentBuilder documentBuilder = factory.newDocumentBuilder();
		Document document = documentBuilder.parse(is);
		Element root = document.getDocumentElement();
		NodeList children = root.getChildNodes();
		
		getNode(children.item(0));
//		for(int i = 0; i < children.getLength(); i++){
//			Node node = children.item(i);
//			System.out.println(node.getNodeType());
//			if(node.getNodeType() == Node.ELEMENT_NODE){ // 해당 노드의 종류 판정(Element일 때)
//				Element ele = (Element)node;
//				String nodeName = ele.getNodeName();
//				System.out.println("노드 이름: <" + nodeName +">");
//					System.out.println("node attribute: " + ele.getAttribute("name"));
//					System.out.println("asd"+ele.getChildNodes());
//			}
//		}
		System.out.println("종료");
		return xml;
	}
	 

	public static void getNode(Node n) {

	           for(Node ch=n.getFirstChild(); ch!=null; ch = ch.getNextSibling()) {

	                     if(ch.getNodeType() == Node.ELEMENT_NODE) {

	                                System.out.println("<" + ch.getNodeName() + ">");

	                                getNode(ch);

	                     }

	                     else if(ch.getNodeType() == Node.TEXT_NODE &&

	                                           ch.getNodeValue().trim().length() != 0) {

	                                System.out.println(ch.getNodeValue());

	                     }

	           }

	}



}
