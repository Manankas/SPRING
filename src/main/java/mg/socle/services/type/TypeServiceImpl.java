package mg.socle.services.type;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import mg.socle.dao.type.TypeDAO;
import mg.socle.domain.Type;

@Service("typeService")
public class TypeServiceImpl implements TypeService {


	@Autowired
	private TypeDAO typeDAO;

	public TypeDAO getTypeDAO() {
		return typeDAO;
	}
	public void setTypeDAO(TypeDAO typeDAO) {
		this.typeDAO = typeDAO;
	}

	@Override
	@Transactional
	public void addType(Type p) {
		this.typeDAO.addType(p);
	}

	@Override
	@Transactional
	public void updateType(Type p) {
		this.typeDAO.update(p);
	}

	@Override
	@Transactional
	public List<Type> findAllTypes() {
		return this.typeDAO.findAll();
	}

	@Override
	@Transactional
	public Type findById(int id) {
		return this.typeDAO.findById(id);
	}

	@Override
	@Transactional
	public void removeType(int id) {
		this.typeDAO.remove(id);
	}

}
