package se.lexicon.todoapi.service;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import se.lexicon.todoapi.exception.ObjectNotFoundException;
import se.lexicon.todoapi.model.dto.PersonDto;
import se.lexicon.todoapi.model.entity.Person;
import se.lexicon.todoapi.repository.PersonRepository;

import java.util.List;
@Service
public class PersonServiceImpl implements PersonService{

    PersonRepository personRepository;
    ModelMapper modelMapper;

    @Autowired
    public PersonServiceImpl(PersonRepository personRepository, ModelMapper modelMapper) {
        this.personRepository = personRepository;
        this.modelMapper = modelMapper;
    }

    @Override
    public PersonDto create(PersonDto dto) {
        if (dto == null) throw new IllegalArgumentException("Person dto is null");
        if (dto.getPersonId() != null) throw new IllegalArgumentException("person dto id should be null");
        Person convertedToEntity = modelMapper.map(dto, Person.class);
        Person createdPerson = personRepository.save(convertedToEntity);
        PersonDto convertedToDto = modelMapper.map(createdPerson, PersonDto.class);
        return convertedToDto;
    }

    @Override
    public PersonDto findById(Integer personId) throws ObjectNotFoundException {
        return null;
    }

    @Override
    public List<PersonDto> findAll() {
        return null;
    }
}
