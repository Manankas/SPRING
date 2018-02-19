package mg.socle.services;

import java.util.List;

import mg.socle.domain.Employer;

/**
 * Service to manage employer.
 * 
 * @author rija.n.ramampiandra
 * 
 */
public interface EmployerService {

	/**
	 * Add employer to DB.
	 * 
	 * @param p
	 *            the employer.
	 */
	public void addEmployer(Employer p);

	/**
	 * Maj employer.
	 * 
	 * @param p
	 *            the employer.
	 * 
	 */
	public void updateEmployer(Employer p);

	/**
	 * Liste des employers.
	 * 
	 * @return the list.
	 */
	public List<Employer> findAllEmployers();

	/**
	 * Get employer by id.
	 * 
	 * @param id
	 *            the id.
	 * @return the employer.
	 */
	public Employer findEmployerById(int id);

	/**
	 * Removo employer.
	 * 
	 * @param id
	 *            the id.
	 */
	public void removeEmployer(int id);

}
