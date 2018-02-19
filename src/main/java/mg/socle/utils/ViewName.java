package mg.socle.utils;

/**
 * Constant utiliser par l'application.
 * 
 * @author rija.n.ramampiandra
 * 
 */
public interface ViewName {
	/**
	 * Page racine.
	 */
	String PAGE_RACINE = "/";

	/**
	 * Page index.
	 */
	String PAGE_INDEX = "/index";

	/**
	 * Page employer.
	 */
	String PAGE_LISTE_EMPLOYER = "/employerListe";

	/**
	 * Page employer.
	 */
	String PAGE_LISTE_PDC = "/pdcListe";

	/**
	 * page edit employer.
	 */
	String PAGE_ADD_OR_EDIT_EMPLOYER = "/employerAddOrEdit";

	/**
	 * page ajout/edit mantis.
	 */
	String PAGE_AJOUT_EDIT_MANTIS = "/mantisAjoutEdit";

	/**
	 * page ajout/edit assignation.
	 */
	String PAGE_AJOUT_EDIT_ASSIGNATION = "/assignationAjoutEdit";

	/**
	 * Page liste mantis.
	 */
	String PAGE_LISTE_MANTIS = "/mantisListe";

	/**
	 * Page liste mantis.
	 */
	String PAGE_LISTE_ASSIGNATION = "/assignationListe";

	/**
	 * page edit mantis.
	 */
	String PAGE_EDIT_ASSIGNATION = "/assignationEdit";

	/**
	 * page edit mantis.
	 */
	String PAGE_EDIT_MANTIS = "/mantisEdit";

	/**
	 * page ajout mantis.
	 */
	String PAGE_AJOUT_MANTIS = "/mantisAjout";

	/**
	 * page ajout assignation.
	 */
	String PAGE_AJOUT_ASSIGNATION = "/assignationAjout";

	/**
	 * Page.
	 */
	String PAGE = "page";

	/**
	 * Page erreur custom.
	 */
	String PAGE_ERROR_PAGE = "errorPage";

	/**
	 * Page erreur general.
	 */
	String PAGE_GENERAL_ERROR_PAGE = "generalErrorPage";

	/**
	 * Page erreur Java.
	 * <ul>
	 * <li>NumberFormatException.java</li>
	 * </ul>
	 */
	String PAGE__ERROR_THROWABLE_PAGE = "errorThrowable";

	/**
	 * Appel fichier index.html.
	 */
	String VIEW_INDEX = "index";

	/**
	 * Appel fichier errorPage.html.
	 */
	String VIEW_ERROR_PAGE = "error/errorPage";

	/**
	 * Appel fichier error/general-error.html.
	 */
	String VIEW_GENERAL_ERROR_PAGE = "error/general-error";

	/**
	 * Afficher la vue ajout.
	 */
	String SHOW_ADD_VIEW = "/ajouter";

	/**
	 * Ajout action dans le DB.
	 */
	String ADD_TO_DB = "/addAction";

	/**
	 * Sauvegarder les données dans la base de données.
	 */
	String SAVE_TO_DB = "/saveedit";

	/**
	 * Choix run ou build.
	 */
	String CHOICE_RUN_OR_BUILD = "choixRunOrBuild";

	/**
	 * Choix
	 * <ul>
	 * <li>OUI</li>
	 * <li>NON</li>
	 * </ul>
	 */
	String CHOICE_ACTIF_OR_NOT = "choixActifOuNon";

	/**
	 * Choix statut mantis.
	 * <ul>
	 * <li>
	 * statut.mantis.-1 =</li>
	 * <li>
	 * statut.mantis.1 = En cours</li>
	 * <li>
	 * statut.mantis.2 = Bloquer</li>
	 * <li>
	 * statut.mantis.3 = Livrer ACN</li>
	 * <li>
	 * statut.mantis.4 = Livrer Client</li>
	 * <li>
	 * statut.mantis.5 = En intég</li>
	 * <li>
	 * statut.mantis.6 = En recette</li>
	 * <li>
	 * statut.mantis.7 = UAT</li>
	 * </ul>
	 */
	String MANTIS_STATUS = "choixStatutMantis";

	/**
	 * Choix equipe : JAVA ou ASP.
	 */
	String CHOICE_TEAM = "allTypes";
	
	String EMPLOYER_ID = "employerId";
	
	String WEEK_NUMBER = "weekNumber";
}
