package se.lexicon.todoapi.service;

import se.lexicon.todoapi.exception.ObjectNotFoundException;
import se.lexicon.todoapi.model.dto.TodoItemDto;

import java.util.List;

public interface TodoItemService {

    TodoItemDto create(TodoItemDto dto);

    TodoItemDto findById(Integer TodoItemId) throws ObjectNotFoundException;

    List<TodoItemDto> findAll();
}
