package one.digitalinnovation.personAPI.repository;

import one.digitalinnovation.personAPI.entity.Person;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PersonRepository extends JpaRepository<Person, Long> {


}
