package atmg;

import java.io.IOException;
import java.io.InputStream;
import java.net.URL;

import javax.swing.JOptionPane;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

public class weatherlogindisplay {
    	weathergui gui;
    	void setweathergui(weathergui gui)
    	{
    		this.gui = gui;
    	}

        public void generateXML(String code) throws IOException {

            String url = null;
            String XmlData = null;

            // creating the URL
            url = "http://weather.yahooapis.com/forecastrss?w=" + code;
            URL xmlUrl = new URL(url);
            InputStream in = xmlUrl.openStream();

            // parsing the XmlUrl
           // Document doc = parse(in);
            Document doc = null;
            DocumentBuilderFactory domFactory;
            DocumentBuilder builder;

            try {
                domFactory = DocumentBuilderFactory.newInstance();
                domFactory.setValidating(false);
                domFactory.setNamespaceAware(false);
                builder = domFactory.newDocumentBuilder();

                doc = builder.parse(in);
            } catch (Exception ex) {
                System.err.println("unable to load XML: " + ex);
            }
            WeatherDisplay disp = new WeatherDisplay();
            disp.setweathergui(gui);
            disp.getConditions(doc);

        }
        
        public class WeatherDisplay {

        	weathergui gui;
        	String condition;
        	String forecast;
        	StringBuilder builder = new StringBuilder("");
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
                                    builder.append("\n\n" + "City Is                           : " + city);

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
                                    builder.append("\n" +"Temperature              :" + e3.getAttribute("temp") + " "
                                            + unit);
                                }
                            }

                            NodeList nl4 = eElement
                                    .getElementsByTagName("yweather:atmosphere");

                            for (int tempr = 0; tempr < nl4.getLength(); tempr++) {

                                Node n4 = nl4.item(tempr);

                                if (nNode.getNodeType() == Node.ELEMENT_NODE) {

                                    Element e4 = (Element) n4;
                                    builder.append("\n" +"The Humidity              :" + e4.getAttribute("humidity"));
                                }
                            }
                            
                            NodeList nl5 = eElement
                                    .getElementsByTagName("yweather:condition");

                            for (int tempr = 0; tempr < nl5.getLength(); tempr++) {

                                Node n5 = nl5.item(tempr);

                                if (nNode.getNodeType() == Node.ELEMENT_NODE) {

                                    Element e5 = (Element) n5;
                                    builder.append("\n" +"Weather Condition   :"  + e5.getAttribute("text"));
                                    condition =e5.getAttribute("text");
                                    System.out.println(condition);
                                    //checkbank(condition);
                                    //builder.append(" soon");
                                    //builder.append("\n                       or");
                                }
                            }
                            
                            NodeList nl6 = eElement
                                    .getElementsByTagName("yweather:forecast");

                            for (int tempr = 0; tempr < nl5.getLength(); tempr++) {

                                Node n6 = nl6.item(tempr);

                                if (nNode.getNodeType() == Node.ELEMENT_NODE) {

                                    Element e6 = (Element) n6;
                                    builder.append("\n" +"Weather Forecast    :"  + e6.getAttribute("text"));
                                    //forecast = e6.getAttribute("text");
                                    //checkbank(forecast);
                                    //builder.append(" in some time");
                                }
                            }

                        }
                    }
                   JOptionPane.showMessageDialog(null,builder);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }

        }

	}
	