package atmg;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

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
                            gui.formattedTextField.append("\n" +"The Forecast In " + city
                                    + " Is : " + e6.getAttribute("text"));
                            //forecast = e6.getAttribute("text");
                            //checkbank(forecast);
                            //builder.append(" in some time");
                        }
                    }

                }
            }
           // JOptionPane.showMessageDialog(null,builder);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    void checkbank(String status)
    {
    	if(condition.compareTo("Partly Cloudy")==0)
        {
        	builder.append("\n You can go to bank");
        }
    	else if(condition.compareTo("Showers Early")==0)
    	{
    		builder.append("\n It may start Showering if you start to bank");
    	}
    	else if(condition.compareTo("Cloudy")==0)
        {
        	builder.append("\n Hurry to bank it may rain");
        }
    	else if(condition.compareTo("heavy snow")==0)
    	{
    		builder.append("\n avoid going to bank you may face heavy snow");
    	}
    	else if(condition.compareTo("clear")==0)
    	{
    		builder.append("\n Its a pleasent day you may go to bank");
    	}
    	else if(condition.compareTo("fair")==0)
    	{
    		builder.append("\n Its a good day you may go to bank");
    	}
    	else if(condition.compareTo("Sunny")==0)
    	{
    		builder.append("\n Sunny day ahead you may go to bank");
    	}
    	else if(condition.compareTo("thundershowers")==0)
    	{
    		builder.append("\n Its not safe to go to bank");
    	}
    	else if(condition.compareTo("hot")==0)
    	{
    		builder.append("\n Its a hot day stay hydrated before you start to bank");
    	}
    	else if(condition.compareTo("scattered thunderstorms")==0)
    	{
    		builder.append("\n Be carefull if you start to bank");
    	}
    }

}
