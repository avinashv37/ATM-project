package atmg;

import java.io.IOException;
import java.io.InputStream;
import java.io.StringWriter;
import java.net.URL;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import org.w3c.dom.Document;

    public class WeatherProcess {

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
    }
