package se.lexicon.todoapi.service;

import org.hibernate.ObjectNotFoundException;
import se.lexicon.todoapi.model.dto.UserDto;

public interface UserService {

    UserDto register(UserDto dto) throws ObjectNotFoundException, se.lexicon.todoapi.exception.ObjectNotFoundException;

    UserDto findByUsername(String username) throws ObjectNotFoundException, se.lexicon.todoapi.exception.ObjectNotFoundException;

    void disableUserByUsername(String username) throws ObjectNotFoundException, se.lexicon.todoapi.exception.ObjectNotFoundException;

    void enableUserByUsername(String username) throws ObjectNotFoundException, se.lexicon.todoapi.exception.ObjectNotFoundException;
}
