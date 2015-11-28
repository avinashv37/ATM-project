package atmg;

import java.util.Date;
import java.text.DateFormat;
import java.text.SimpleDateFormat;

public class CurrentDate {
	String Date;

	public CurrentDate() {

	}

	Date getDate() {
		Date date = new Date();
		return date;
	}

	String gettime() {
		DateFormat timeFormat = new SimpleDateFormat("HH:mm:ss");
		Date date = new Date();
		return (timeFormat.format(date));
	}

}
