package mg.socle.formatter;

import java.util.Locale;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.format.Formatter;
import org.springframework.stereotype.Service;

import mg.socle.domain.Type;
import mg.socle.services.type.TypeService;

/**
 * Conversion type ASP ou Java en objet de la base de données.
 * 
 * @author rija.n.ramampiandra
 * 
 */
@Service("typeFormatter")
public class TypeFormatter implements Formatter<Type> {

	@Autowired(required = true)
	@Qualifier(value = "typeService")
	private TypeService typeService;

	@Override
	public String print(Type object, Locale locale) {
		return Integer.toString(object.getId());
	}

	@Override
	public Type parse(String text, Locale locale)
			throws java.text.ParseException {
		int id = Integer.parseInt(text);
		return typeService.findById(id);
	}
}