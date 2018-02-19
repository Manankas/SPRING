package mg.socle.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import mg.socle.domain.Employer;
import mg.socle.services.ServiceRepository;


@ServiceRepository
public interface EmployerRepository extends JpaRepository<Employer, Integer> {

}
