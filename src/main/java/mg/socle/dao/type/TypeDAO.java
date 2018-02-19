package mg.socle.dao.type;

import java.util.List;

import mg.socle.domain.Type;

/**
 * Acces to DB to manage type.
 * 
 * @author rija.n.ramampiandra
 * 
 */
public interface TypeDAO {

	/**
	 * Ajout type.
	 * 
	 * @param p
	 */
	public void addType(Type p);

	/**
	 * Maj type.
	 * 
	 * @param p
	 *            the type.
	 */
	public void update(Type p);

	/**
	 * Liste type.
	 * 
	 * @return the list.
	 */
	public List<Type> findAll();

	/**
	 * Obtenir la typene par ID.
	 * 
	 * @param id
	 *            the id.
	 * @return the type.
	 */
	public Type findById(int id);

	/**
	 * Delete type.
	 * 
	 * @param id
	 *            the id.
	 */
	public void remove(int id);
}
