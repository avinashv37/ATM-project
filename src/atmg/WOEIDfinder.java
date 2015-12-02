package atmg;

import java.io.IOException;
import java.io.InputStream;
import java.net.URL;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

public class WOEIDfinder {

	static String WOEID = null;
	weathergui gui;

	/*
	 * public static void main(String[] args) throws IOException {
	 * 
	 * 
	 * WOEIDfinder find = new WOEIDfinder(); find.generateXML("melbourne");
	 * 
	 * 
	 * }
	 */
	void setweathergui(weathergui gui) {
		this.gui = gui;
	}

	public void generateXML(String city) throws IOException {

		String url = null;
		String XmlData = null;

		// creating the URL
		url = "http://where.yahooapis.com/v1/places.q('" + city
				+ "')?appid=dj0yJmk9TWM1UlZJZWJXTUhNJmQ9WVdrOVpXUmpVRmxITm5FbWNHbzlNQS0tJnM9Y29uc3VtZXJzZWNyZXQmeD02ZA--";

		URL xmlUrl = new URL(url);
		InputStream in = xmlUrl.openStream();

		// parsing the XmlUrl
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

		disp.getConditions(doc);
		// return doc;

	}

	public class WeatherDisplay {

		void getConditions(Document doc) throws IOException {

			// String unit = null;

			try {

				doc.getDocumentElement().normalize();

				// System.out.println("Root element :" +
				// doc.getDocumentElement().getNodeName());

				NodeList nList = doc.getElementsByTagName("places");

				for (int temp = 0; temp < nList.getLength(); temp++) {

					Node nNode = nList.item(temp);

					if (nNode.getNodeType() == Node.ELEMENT_NODE) {

						Element eElement = (Element) nNode;

						WOEID = eElement.getElementsByTagName("woeid").item(0).getTextContent();
						System.out.println("The WOEID Is : " + WOEID);

						WeatherProcess weather = new WeatherProcess();
						weather.setweathergui(gui);
						weather.generateXML(WOEID);
					}
				}
			} catch (Exception e) {
				e.printStackTrace();
			}

		}

	}
}
