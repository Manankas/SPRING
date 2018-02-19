package mg.socle.controller;

import java.util.Calendar;
import java.util.List;

import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import mg.socle.domain.Employer;
import mg.socle.domain.Type;
import mg.socle.services.EmployerService;
import mg.socle.services.type.TypeService;
import mg.socle.utils.ViewName;

/**
 * Cette controlleur permet de gerer la mise a jour des employer.
 * 
 * @author rija.n.ramampiandra
 * 
 */
@Controller
@RequestMapping(value = ViewName.PAGE_ADD_OR_EDIT_EMPLOYER)
public class EmployerAddOrEditController {

	@Autowired(required = true)
	@Qualifier(value = "employerService")
	private EmployerService employerService;

	@Autowired(required = true)
	@Qualifier(value = "typeService")
	private TypeService typeService;

	@RequestMapping(value = ViewName.SHOW_ADD_VIEW, method = RequestMethod.GET)
	public ModelAndView ajouterEmployer() {

		ModelAndView model = new ModelAndView();
		model.setViewName(ViewName.PAGE_ADD_OR_EDIT_EMPLOYER);
		Employer dev = new Employer();

		model.addObject("employer", dev);
		model.addObject(ViewName.PAGE, ViewName.PAGE_ADD_OR_EDIT_EMPLOYER);
		model.addObject("add", true);

		return model;
	}

	private ModelAndView generateViewError(Employer employer, String errorName, String errorMessage,
			String viewName) {

		ModelAndView modelToReturn = new ModelAndView(viewName);

		modelToReturn.addObject("employer", employer);
		modelToReturn.addObject(ViewName.PAGE, viewName);
		modelToReturn.addObject(errorName, true);
		modelToReturn.addObject("error", errorMessage);
		modelToReturn.addObject("add", true);
		return modelToReturn;
	}

	@RequestMapping(value = ViewName.ADD_TO_DB, method = RequestMethod.POST)
	public Object ajouterEmployerToDb(@ModelAttribute("employer") Employer employer, ModelMap model) {
		employer.setActif(1);

		if (StringUtils.isEmpty(employer.getNom())) {
			return generateViewError(employer, "errorEmployer", "Nom obligatoire!",
					ViewName.PAGE_ADD_OR_EDIT_EMPLOYER);
		}

		if (employer.getNom() != null) {
			employer.setNom(employer.getNom().toUpperCase());
		}

		if (employer.getDateEmbauche() == null) {
			return generateViewError(employer, "errorDateEmbauche", "Date embauche obligatoire!",
					ViewName.PAGE_ADD_OR_EDIT_EMPLOYER);
		}

		employer.setDate(Calendar.getInstance().getTime());

		employerService.addEmployer(employer);
		return "redirect:" + ViewName.PAGE_LISTE_EMPLOYER;
	}

	@RequestMapping(method = RequestMethod.GET)
	public ModelAndView editEmployer(@RequestParam(value = "id", required = false) String id) {
		if (StringUtils.isEmpty(id)) {
			ModelAndView model = new ModelAndView(ViewName.VIEW_ERROR_PAGE);
			model.addObject("errorMessage", "Dévelopeur obligatoire.");
			model.addObject(ViewName.PAGE, ViewName.VIEW_ERROR_PAGE);
			model.addObject("edit", true);

			return model;

		}

		ModelAndView model = new ModelAndView(ViewName.PAGE_ADD_OR_EDIT_EMPLOYER);
		model.addObject("msg", id);
		int idInt = Integer.valueOf(id);
		Employer employer = employerService.findEmployerById(idInt);
		model.addObject("employer", employer);
		// Utiliser sur le header
		model.addObject(ViewName.PAGE, ViewName.PAGE_ADD_OR_EDIT_EMPLOYER);
		model.addObject("edit", true);

		return model;
	}

	@RequestMapping(value = ViewName.SAVE_TO_DB, method = RequestMethod.POST)
	public String saveEmployerToDB(@ModelAttribute("employer") Employer employer, ModelMap model) {
		if (employer.getNom() != null) {
			employer.setNom(employer.getNom().toUpperCase());
		}
		employerService.updateEmployer(employer);

		return "redirect:" + ViewName.PAGE_LISTE_EMPLOYER;
	}

	@ModelAttribute(ViewName.CHOICE_TEAM)
	public List<Type> populateTypes() {
		return typeService.findAllTypes();
	}

	/**
	 * Sur la suprression entre directement ici.
	 * 
	 * @param id
	 * @return
	 */
	@RequestMapping(value = "/supprimer", method = RequestMethod.GET)
	public String supprimerAssignation(@RequestParam(value = "id", required = false) String id) {
		if (StringUtils.isBlank(id)) {
			return "redirect:" + ViewName.VIEW_ERROR_PAGE;
		}

		int idInt = Integer.valueOf(id);
		final Employer objet = employerService.findEmployerById(idInt);
		if (objet != null) {
			employerService.removeEmployer(idInt);
		}
		return "redirect:" + ViewName.PAGE_LISTE_EMPLOYER;
	}
}