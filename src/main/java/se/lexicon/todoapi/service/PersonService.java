package se.lexicon.todoapi.service;

import se.lexicon.todoapi.exception.ObjectNotFoundException;
import se.lexicon.todoapi.model.dto.PersonDto;

import java.util.List;

public interface PersonService {

    PersonDto create(PersonDto dto);

    PersonDto findById(Integer personId) throws ObjectNotFoundException;

    List<PersonDto> findAll();


}
