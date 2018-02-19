package mg.socle.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import mg.socle.domain.Person;

public interface PersonService {

	/**
	 * Finds a "page" of persons
	 * 
	 * @param pageable
	 * @return {@link Page} instance
	 */
	Page<Person> findAllPageable(String firstName, Pageable pageable);
}
