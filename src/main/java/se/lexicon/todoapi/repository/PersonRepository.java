package se.lexicon.todoapi.repository;

import org.springframework.data.repository.CrudRepository;
import se.lexicon.todoapi.model.entity.Person;

import java.util.List;

public interface PersonRepository extends CrudRepository<Person, Integer> {

    List<Person> findAll();


    List<Person> findByFirstNameAndLastName(String firstname, String lastname);
    List<Person> findByFirstNameIgnoreCaseAndLastNameIgnoreCase(String firstname, String lastname);


}
