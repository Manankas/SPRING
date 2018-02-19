package mg.socle.dao.type;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import mg.socle.domain.Type;
import mg.socle.services.ServiceMetier;

/**
 * DAO implementation.
 * 
 * @author rija.n.ramampiandra
 * 
 */
@ServiceMetier
public class TypeDAOImpl implements TypeDAO {

	private static final Logger logger = LoggerFactory.getLogger(TypeDAOImpl.class);

	@Autowired
	private TypeRepository typeRepository;

	@Override
	public void addType(Type p) {
		typeRepository.save(p);
		logger.info("Type saved successfully, Type Details=" + p);
	}

	@Override
	public void update(Type p) {
		typeRepository.save(p);
		logger.info("Type updated successfully, Type Details=" + p);
	}

	@Override
	public List<Type> findAll() {
		return typeRepository.findAll();
	}

	@Override
	public Type findById(int id) {
		return typeRepository.findOne(new Integer(id));
	}

	@Override
	public void remove(int id) {
		typeRepository.delete(id);
	}

}
