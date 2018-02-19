package mg.socle.utils;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;

import org.apache.commons.lang.StringUtils;

/**
 * Date utils.
 * 
 * @author rija.n.ramampiandra
 * 
 */
public class DateUtils {

	public static final String dd_MM_yyyy = "dd/MM/yyyy";

	public static final String yyyy_MM_dd = "yyyy-MM-dd";

	public static final String dd_MM_yyyy_HH_mm_ss = "dd/MM/yyyy HH:mm:ss";

	/**
	 * Formattage de date.
	 * 
	 * @param date
	 *            the date.
	 * @param pattern
	 *            the pattern.
	 * @return the date formatted.
	 */
	public static String dateFormatter(Date date, String pattern) {
		if (date == null) {
			return StringUtils.EMPTY;
		}

		if (pattern == null) {
			pattern = dd_MM_yyyy;
		}

		SimpleDateFormat dateFormatter = new SimpleDateFormat(pattern, Locale.ENGLISH);
		return dateFormatter.format(date);
	}

	/**
	 * Difference entre deux date.
	 * 
	 * @param dateStart
	 *            the date debut.
	 * @param dateStop
	 *            the date fin.
	 * @return difference en jour.
	 */
	public static long getDateDiff(String dateStart, String dateStop) {
		long diffDays = 0;
		// String dateStart = "01/14/2012 09:29:58";
		// String dateStop = "01/15/2012 10:31:48";

		// HH converts hour in 24 hours format (0-23), day calculation
		SimpleDateFormat format = new SimpleDateFormat(dd_MM_yyyy);

		Date dateDebut = null;
		Date dateFin = null;

		try {
			dateDebut = format.parse(dateStart);
			dateFin = format.parse(dateStop);

			// in milliseconds
			long diff = dateFin.getTime() - dateDebut.getTime();

			long diffSeconds = diff / 1000 % 60;
			long diffMinutes = diff / (60 * 1000) % 60;
			long diffHours = diff / (60 * 60 * 1000) % 24;
			diffDays = diff / (24 * 60 * 60 * 1000);

		} catch (Exception e) {
			e.printStackTrace();
		}
		return diffDays;
	}

	/**
	 * Difference entre deux date.
	 * 
	 * @param d1
	 *            the date debut.
	 * @param d2
	 *            the date fin.
	 * @return difference en jour.
	 */
	public static long getDateDiff(Date d1, Date d2) {
		long diffDays = 0;
		String dateStart = dateFormatter(d1, dd_MM_yyyy);
		String dateStop = dateFormatter(d2, dd_MM_yyyy);

		// HH converts hour in 24 hours format (0-23), day calculation
		SimpleDateFormat format = new SimpleDateFormat(dd_MM_yyyy);

		Date dateDebut = null;
		Date dateFin = null;

		try {
			dateDebut = format.parse(dateStart);
			dateFin = format.parse(dateStop);

			// in milliseconds
			long diff = dateFin.getTime() - dateDebut.getTime();

			diffDays = diff / (24 * 60 * 60 * 1000);

		} catch (Exception e) {
			e.printStackTrace();
		}
		return diffDays;
	}

	/**
	 * Obtenir la numéro de WE à partir de la date donnée.
	 * 
	 * @param date
	 *            the date.
	 * @return the week number.
	 */
	public static int getWeekNumberFromDate(final Date date) {
		if (date == null) {
			return 0;
		}
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(date);
		return calendar.get(Calendar.WEEK_OF_YEAR);
	}

}
