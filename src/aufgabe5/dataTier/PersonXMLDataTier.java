package aufgabe5.dataTier;

import java.io.File;

import javax.faces.bean.ApplicationScoped;
import javax.faces.bean.ManagedBean;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import aufgabe5.model.Person;

@ManagedBean(name="personDataTier")
@ApplicationScoped
public class PersonXMLDataTier extends CacheDataTier<Person> {

	private String XML = "C:/Users/Andre Schriever/Documents/GitHub/webprog2/WebContent/aufgabe5/persons.xml";

	public PersonXMLDataTier() {
		searchUser("");
	}
	public void searchUser(String gogo) {
		try {

			File fXmlFile = new File(XML);
			DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
			DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
			Document doc = dBuilder.parse(fXmlFile);

			doc.getDocumentElement().normalize();

			NodeList nList = doc.getElementsByTagName("person");

			String vorname = "";
			String nachname = "";
			String residence = "";
			String children = "";

			for (int temp = 0; temp < nList.getLength(); temp++) {

				Node nNode = nList.item(temp);

				if (gogo != "") {

//					if (nNode.getNodeType() == Node.ELEMENT_NODE) {
//						Element eElement = (Element) nNode;
//
//						// Vorname
//						vorname = eElement.getElementsByTagName("firstname").item(0).getTextContent();
//
//						if (vorname.equals(gogo)) {
//							names.put("vorname", vorname);
//							// nachname
//							if (eElement.getElementsByTagName("lastname").item(0) != null) {
//								nachname = eElement.getElementsByTagName("lastname").item(0).getTextContent();
//								names.put("nachname", nachname);
//							} else {
//								nachname = "*";
//								names.put("nachname", nachname);
//							}
//
//							if (eElement.getElementsByTagName("residence").item(0) != null) {
//								residence = eElement.getElementsByTagName("residence").item(0).getTextContent();
//								names.put("Wohnort", residence);
//							} else {
//								residence = "*";
//								names.put("Wohnort", residence);
//							}
//
//							// if
//							// (eElement.getElementsByTagName("children").item(0)
//							// != null) {
//							//
//							// if()
//							// names.put("Kind", children);
//							// }
//							// else {
//							// children = "*";
//							// names.put("Kind", children);
//							// }
//
//						}
//					}
				} else {
					
					Person person = new Person();
							
					if (nNode.getNodeType() == Node.ELEMENT_NODE) {

						Element eElement = (Element) nNode;
						vorname = eElement.getElementsByTagName("firstname").item(0).getTextContent();

						person.setVorname(vorname);
						
						if (eElement.getElementsByTagName("lastname").item(0) != null) {
							nachname = eElement.getElementsByTagName("lastname").item(0).getTextContent();
							person.setNachname(nachname);
						} else
							person.setNachname("*");

//						id = eElement.getElementsByTagName("person id").item(0).getTextContent();
//						person.setId(id++);
						
					}
					
					add(person);
					//names.put(vorname, nachname);
				}

			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
