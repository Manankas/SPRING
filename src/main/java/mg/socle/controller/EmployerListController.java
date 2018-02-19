package mg.socle.controller;

import java.util.List;

import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import mg.socle.domain.Employer;
import mg.socle.domain.Pager;
import mg.socle.domain.Person;
import mg.socle.service.PersonService;
import mg.socle.services.EmployerService;
import mg.socle.utils.ViewName;

@Controller
public class EmployerListController {

	private static final int BUTTONS_TO_SHOW = 5;
	private static final int INITIAL_PAGE = 0;
	private static final int INITIAL_PAGE_SIZE = 5;
	private static final int[] PAGE_SIZES = { 5, 10, 20 };

	@Autowired(required = true)
	@Qualifier(value = "employerService")
	private EmployerService employerService;

	@Autowired(required = true)
	@Qualifier(value = "personService")
	private PersonService personService;

	@RequestMapping(value = ViewName.PAGE_LISTE_EMPLOYER, method = RequestMethod.GET)
	public ModelAndView getRequest() {

		ModelAndView map = new ModelAndView();
		map.setViewName(ViewName.PAGE_LISTE_EMPLOYER);

		List<Employer> list = employerService.findAllEmployers();
		map.addObject("listEmployer", list);
		// Utiliser sur le header
		map.addObject(ViewName.PAGE, ViewName.PAGE_LISTE_EMPLOYER);

		return map;
	}

	@RequestMapping(value = "/listPersons/filtre", method = RequestMethod.POST)
	public Object ajouterEmployerToDb(@RequestParam(value = "pageSize", required = false) Integer pageSize,
			@RequestParam(value = "page", required = false) Integer page,
			@ModelAttribute("employer") Employer employer) {
		ModelAndView modelAndView = new ModelAndView("persons");

		modelAndView.addObject("employer", employer);

		// Evaluate page size. If requested parameter is null, return initial
		// page size
		int evalPageSize = INITIAL_PAGE_SIZE;
		if (pageSize != null) {
			evalPageSize = orElse(pageSize, INITIAL_PAGE_SIZE);
		}
		// Evaluate page. If requested parameter is null or less than 0 (to
		// prevent exception), return initial size. Otherwise, return value of
		// param. decreased by 1.
		int evalPage = INITIAL_PAGE;
		if (page != null) {
			evalPage = (orElse(page, 0) < 1) ? INITIAL_PAGE : page - 1;
		}

		Page<Person> persons = personService.findAllPageable(employer.getNom(),
				new PageRequest(evalPage, evalPageSize));
		Pager pager = new Pager(persons.getTotalPages(), persons.getNumber(), BUTTONS_TO_SHOW);

		modelAndView.addObject("persons", persons);
		modelAndView.addObject("selectedPageSize", evalPageSize);
		modelAndView.addObject("pageSizes", PAGE_SIZES);
		modelAndView.addObject("pager", pager);
		return modelAndView;
	}

	@RequestMapping(value = "/listPersons", method = RequestMethod.GET)
	public ModelAndView getPersons(@RequestParam(value = "pageSize", required = false) Integer pageSize,
			@RequestParam(value = "page", required = false) Integer page,
			@RequestParam(value = "nom", required = false) String firstName,
			@ModelAttribute("employer") Employer employer) {
		ModelAndView modelAndView = new ModelAndView("persons");
		Employer dev = new Employer();
		if (employer != null) {
			dev = employer;
		}

		modelAndView.addObject("employer", dev);

		// Evaluate page size. If requested parameter is null, return initial
		// page size
		int evalPageSize = INITIAL_PAGE_SIZE;
		if (pageSize != null) {
			evalPageSize = orElse(pageSize, INITIAL_PAGE_SIZE);
		}

		// Evaluate page. If requested parameter is null or less than 0 (to
		// prevent exception), return initial size. Otherwise, return value of
		// param. decreased by 1.
		int evalPage = INITIAL_PAGE;
		if (page != null) {
			evalPage = (orElse(page, 0) < 1) ? INITIAL_PAGE : page - 1;
		}

		final Page<Person> persons = personService.findAllPageable(dev.getNom(),
				new PageRequest(evalPage, evalPageSize));

		Pager pager = new Pager(persons.getTotalPages(), persons.getNumber(), BUTTONS_TO_SHOW);

		modelAndView.addObject("persons", persons);
		modelAndView.addObject("selectedPageSize", evalPageSize);
		modelAndView.addObject("pageSizes", PAGE_SIZES);
		modelAndView.addObject("pager", pager);
		return modelAndView;
	}

	/**
	 * Return the value if present, otherwise return {@code other}.
	 *
	 * @param other
	 *            the value to be returned if there is no value present, may be
	 *            null
	 * @return the value, if present, otherwise {@code other}
	 */
	public Integer orElse(Integer value, Integer other) {
		return value != null ? value : other;
	}

}