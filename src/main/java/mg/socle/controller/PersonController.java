package mg.socle.controller;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import mg.socle.domain.Pager;
import mg.socle.domain.Person;
import mg.socle.service.PersonService;
import mg.socle.utils.ViewName;

/**
 * @author Branislav Lazic
 */
@Controller
@RequestMapping(value = "/listPersons")
public class PersonController {

	private static final int BUTTONS_TO_SHOW = 5;
	private static final int INITIAL_PAGE = 0;
	private static final int INITIAL_PAGE_SIZE = 5;
	private static final int[] PAGE_SIZES = { 5, 10, 20 };

	private PersonService personService;

	public PersonController(PersonService studentService) {
		this.personService = studentService;
	}

	/**
	 * Handles all requests
	 * 
	 * @param pageSize
	 * @param page
	 * @return model and view
	 */
//	@GetMapping("/listPersons")
	public ModelAndView showPersonsPage(@RequestParam("pageSize") Integer pageSize,
			@RequestParam("page") Integer page) {
		ModelAndView modelAndView = new ModelAndView("persons");

		// Evaluate page size. If requested parameter is null, return initial
		// page size
		// int evalPageSize = pageSize.orElse(INITIAL_PAGE_SIZE);
		int evalPageSize = INITIAL_PAGE_SIZE;
		// Evaluate page. If requested parameter is null or less than 0 (to
		// prevent exception), return initial size. Otherwise, return value of
		// param. decreased by 1.
		// int evalPage = (page.orElse(0) < 1) ? INITIAL_PAGE : page.get() - 1;
		int evalPage = INITIAL_PAGE;

		Page<Person> persons = personService.findAllPageable(null, new PageRequest(evalPage, evalPageSize));
		Pager pager = new Pager(persons.getTotalPages(), persons.getNumber(), BUTTONS_TO_SHOW);

		modelAndView.addObject("persons", persons);
		modelAndView.addObject("selectedPageSize", evalPageSize);
		modelAndView.addObject("pageSizes", PAGE_SIZES);
		modelAndView.addObject("pager", pager);
		return modelAndView;
	}

}