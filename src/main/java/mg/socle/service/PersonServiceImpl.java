package mg.socle.service;

import org.apache.commons.lang.StringUtils;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import mg.socle.dao.PersonRepository;
import mg.socle.domain.Person;
import mg.socle.specification.PersonSpecifications;

@Service("personService")
public class PersonServiceImpl implements PersonService {

	private PersonRepository personRepository;

	public PersonServiceImpl(PersonRepository personRepository) {
		this.personRepository = personRepository;
	}

	@Transactional
	@Override
	public Page<Person> findAllPageable(String firstName, Pageable pageable) {
		if (StringUtils.isNotEmpty(firstName)) {
			return personRepository.findAll(PersonSpecifications.PersonHasFirstnameLike(firstName.trim()), pageable);
		}
		return personRepository.findAll(pageable);
	}
}
