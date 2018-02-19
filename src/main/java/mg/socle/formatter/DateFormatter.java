package mg.socle.formatter;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

import org.springframework.format.Formatter;
import org.springframework.stereotype.Service;

import mg.socle.utils.DateUtils;

/**
 * Conversion date en str et vice versa.
 * 
 * @author rija.n.ramampiandra
 * 
 */
@Service("dateFormatter")
public class DateFormatter implements Formatter<Date> {

//	private String pattern = "yyyy-MM-dd HH:mm:ss";
	private String pattern = "dd/MM/yyyy";

	@Override
	public String print(Date date, Locale locale) {
		return DateUtils.dateFormatter(date, pattern);
	}

	@Override
	public Date parse(String dateStr, Locale locale)
			throws java.text.ParseException {
		try {
			SimpleDateFormat format = new SimpleDateFormat(pattern, Locale.ENGLISH);
			Date date = format.parse(dateStr);
			return date;
		} catch (Exception e) {
			SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss", Locale.ENGLISH);
			Date date = format.parse(dateStr);
			return date;
		}
	}
}