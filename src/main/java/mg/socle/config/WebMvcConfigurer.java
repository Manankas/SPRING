package mg.socle.config;

import java.util.Locale;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.format.FormatterRegistry;
import org.springframework.web.servlet.LocaleResolver;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.springframework.web.servlet.i18n.LocaleChangeInterceptor;
import org.springframework.web.servlet.i18n.SessionLocaleResolver;

import mg.socle.formatter.DateFormatter;
import mg.socle.formatter.EmployerFormatter;
import mg.socle.formatter.TypeFormatter;

@Configuration
public class WebMvcConfigurer extends WebMvcConfigurerAdapter {

	@Autowired
	private DateFormatter dateFormatter;

	@Autowired
	private TypeFormatter typeFormatter;

	@Autowired
	private EmployerFormatter employerFormatter;

	@Bean
	public LocaleResolver localeResolver() {
		SessionLocaleResolver slr = new SessionLocaleResolver();
		slr.setDefaultLocale(Locale.FRANCE);
		return slr;
	}

	@Bean
	public LocaleChangeInterceptor localeChangeInterceptor() {
		LocaleChangeInterceptor lci = new LocaleChangeInterceptor();
		lci.setParamName("lang");
		return lci;
	}

	@Override
	public void addInterceptors(InterceptorRegistry registry) {
		registry.addInterceptor(localeChangeInterceptor());
	}

	@Override
	public void addFormatters(FormatterRegistry registry) {
		registry.addFormatter(dateFormatter);
		registry.addFormatter(typeFormatter);
		registry.addFormatter(employerFormatter);
	}
}
