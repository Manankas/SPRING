package mg.socle.formatter;

import java.util.Locale;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.format.Formatter;
import org.springframework.stereotype.Service;

import mg.socle.domain.Employer;
import mg.socle.services.EmployerService;

/**
 * Conversion employer ASP ou Java en objet de la base de données.
 * 
 * @author rija.n.ramampiandra
 * 
 */
@Service("employerFormatter")
public class EmployerFormatter implements Formatter<Employer> {

	@Autowired(required = true)
	@Qualifier(value = "employerService")
	private EmployerService employerService;

	@Override
	public String print(Employer object, Locale locale) {
		return Integer.toString(object.getId());
	}

	@Override
	public Employer parse(String text, Locale locale)
			throws java.text.ParseException {
		int id = Integer.parseInt(text);
		return employerService.findEmployerById(id);
	}
}