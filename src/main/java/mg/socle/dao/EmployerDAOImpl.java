package mg.socle.dao;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import mg.socle.domain.Employer;
import mg.socle.services.ServiceMetier;

/**
 * DAO implementation.
 * 
 * @author rija.n.ramampiandra
 * 
 */
@ServiceMetier
public class EmployerDAOImpl implements EmployerDAO {

	private static final Logger logger = LoggerFactory.getLogger(EmployerDAOImpl.class);

	@Autowired
	private EmployerRepository employerRepository;

	@Override
	public void addEmployer(Employer p) {
		employerRepository.save(p);
		logger.info("Employer saved successfully, Employer Details=" + p);
	}

	@Override
	public void updateEmployer(Employer p) {
		employerRepository.save(p);
		logger.info("Employer updated successfully, Employer Details=" + p);
	}

	@Override
	public List<Employer> findAllEmployer() {
		return employerRepository.findAll();
	}

	@Override
	public Employer findEmployerById(int id) {
		return employerRepository.findOne(new Integer(id));
	}

	@Override
	public void removeEmployer(int id) {
		employerRepository.delete(id);
	}

}
