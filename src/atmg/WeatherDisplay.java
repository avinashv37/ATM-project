package atmg;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

public class WeatherDisplay {

	weathergui gui;
	void setweathergui(weathergui gui)
	{
		this.gui = gui;
	}
    void getConditions(Document doc) {

        String city = null;
        String unit = null;

        try {

            doc.getDocumentElement().normalize();

            NodeList nList = doc.getElementsByTagName("rss");

            for (int temp = 0; temp < nList.getLength(); temp++) {

                Node nNode = nList.item(temp);

                if (nNode.getNodeType() == Node.ELEMENT_NODE) {

                    Element eElement = (Element) nNode;

                    NodeList nl = eElement
                            .getElementsByTagName("yweather:location");

                    for (int tempr = 0; tempr < nl.getLength(); tempr++) {

                        Node n = nl.item(tempr);

                        if (nNode.getNodeType() == Node.ELEMENT_NODE) {

                            Element e = (Element) n;
                            city = e.getAttribute("city");
                            gui.formattedTextField.append("\n\n" + "The City Is : " + city);

                        }
                    }

                    NodeList nl2 = eElement
                            .getElementsByTagName("yweather:units");

                    for (int tempr = 0; tempr < nl2.getLength(); tempr++) {

                        Node n2 = nl2.item(tempr);

                        if (nNode.getNodeType() == Node.ELEMENT_NODE) {

                            Element e2 = (Element) n2;
                            unit = e2.getAttribute("temperature");

                        }
                    }

                    NodeList nl3 = eElement
                            .getElementsByTagName("yweather:condition");

                    for (int tempr = 0; tempr < nl3.getLength(); tempr++) {

                        Node n3 = nl3.item(tempr);

                        if (nNode.getNodeType() == Node.ELEMENT_NODE) {

                            Element e3 = (Element) n3;
                            gui.formattedTextField.append("\n" +"The Temperature In " + city
                                    + " Is : " + e3.getAttribute("temp") + " "
                                    + unit);
                        }
                    }

                    NodeList nl4 = eElement
                            .getElementsByTagName("yweather:atmosphere");

                    for (int tempr = 0; tempr < nl4.getLength(); tempr++) {

                        Node n4 = nl4.item(tempr);

                        if (nNode.getNodeType() == Node.ELEMENT_NODE) {

                            Element e4 = (Element) n4;
                            gui.formattedTextField.append("\n" +"The Humidity In " + city
                                    + " Is : " + e4.getAttribute("humidity"));
                        }
                    }
                    
                    NodeList nl5 = eElement
                            .getElementsByTagName("yweather:condition");

                    for (int tempr = 0; tempr < nl5.getLength(); tempr++) {

                        Node n5 = nl5.item(tempr);

                        if (nNode.getNodeType() == Node.ELEMENT_NODE) {

                            Element e5 = (Element) n5;
                            gui.formattedTextField.append("\n" +"The Condition In " + city
                                    + " Is : " + e5.getAttribute("text"));
                        }
                    }
                    
                    NodeList nl6 = eElement
                            .getElementsByTagName("yweather:forecast");

                    for (int tempr = 0; tempr < nl5.getLength(); tempr++) {

                        Node n6 = nl6.item(tempr);

                        if (nNode.getNodeType() == Node.ELEMENT_NODE) {

                            Element e6 = (Element) n6;
                            gui.formattedTextField.append("\n" +"The Forecast In " + city
                                    + " Is : " + e6.getAttribute("text"));
                        }
                    }

                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
