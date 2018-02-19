package mg.socle.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import mg.socle.dao.EmployerDAO;
import mg.socle.domain.Employer;

@Service("employerService")
public class EmployerServiceImpl implements EmployerService {


	@Autowired
	private EmployerDAO employerDAO;

	public EmployerDAO getEmployerDAO() {
		return employerDAO;
	}
	public void setEmployerDAO(EmployerDAO employerDAO) {
		this.employerDAO = employerDAO;
	}

	@Override
	@Transactional
	public void addEmployer(Employer p) {
		this.employerDAO.addEmployer(p);
	}

	@Override
	@Transactional
	public void updateEmployer(Employer p) {
		this.employerDAO.updateEmployer(p);
	}

	@Override
	@Transactional
	public List<Employer> findAllEmployers() {
		return this.employerDAO.findAllEmployer();
	}

	@Override
	@Transactional
	public Employer findEmployerById(int id) {
		return this.employerDAO.findEmployerById(id);
	}

	@Override
	@Transactional
	public void removeEmployer(int id) {
		this.employerDAO.removeEmployer(id);
	}

}
