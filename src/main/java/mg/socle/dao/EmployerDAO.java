package mg.socle.dao;

import java.util.List;

import mg.socle.domain.Employer;

/**
 * Acces to DB to manage employer.
 * 
 * @author rija.n.ramampiandra
 * 
 */
public interface EmployerDAO {

	/**
	 * Ajout employer.
	 * 
	 * @param p
	 */
	public void addEmployer(Employer p);

	/**
	 * Maj employer.
	 * 
	 * @param p
	 *            the employer.
	 */
	public void updateEmployer(Employer p);

	/**
	 * Liste employer.
	 * 
	 * @return the list.
	 */
	public List<Employer> findAllEmployer();

	/**
	 * Obtenir la employerne par ID.
	 * 
	 * @param id
	 *            the id.
	 * @return the employer.
	 */
	public Employer findEmployerById(int id);

	/**
	 * Delete employer.
	 * 
	 * @param id
	 *            the id.
	 */
	public void removeEmployer(int id);
}
