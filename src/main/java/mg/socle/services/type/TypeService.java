package mg.socle.services.type;

import java.util.List;

import mg.socle.domain.Type;

/**
 * Service to manage type.
 * 
 * @author rija.n.ramampiandra
 * 
 */
public interface TypeService {

	/**
	 * Add type to DB.
	 * 
	 * @param p
	 *            the type.
	 */
	public void addType(Type p);

	/**
	 * Maj type.
	 * 
	 * @param p
	 *            the type.
	 * 
	 */
	public void updateType(Type p);

	/**
	 * Liste des types.
	 * 
	 * @return the list.
	 */
	public List<Type> findAllTypes();

	/**
	 * Get type by id.
	 * 
	 * @param id
	 *            the id.
	 * @return the type.
	 */
	public Type findById(int id);

	/**
	 * Removo type.
	 * 
	 * @param id
	 *            the id.
	 */
	public void removeType(int id);

}
