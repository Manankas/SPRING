package mg.socle.dao.type;

import org.springframework.data.jpa.repository.JpaRepository;

import mg.socle.domain.Type;
import mg.socle.services.ServiceRepository;


@ServiceRepository
public interface TypeRepository extends JpaRepository<Type, Integer> {

}
