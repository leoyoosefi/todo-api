package se.lexicon.todoapi.service;

import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import se.lexicon.todoapi.exception.ObjectNotFoundException;
import se.lexicon.todoapi.model.dto.TodoItemDto;
import se.lexicon.todoapi.model.entity.TodoItem;
import se.lexicon.todoapi.repository.TodoItemRepository;

import java.util.List;
@Service
public class TodoItemServiceImpl implements TodoItemService{

    TodoItemRepository todoItemRepository;
    ModelMapper modelMapper;

    @Autowired
    public TodoItemServiceImpl(TodoItemRepository todoItemRepository, ModelMapper modelMapper) {
        this.todoItemRepository = todoItemRepository;
        this.modelMapper = modelMapper;
    }

    @Override
    public TodoItemDto create(TodoItemDto dto) {
        if (dto==null)throw new IllegalArgumentException("todoItem dto is null");
        if (dto.getTodoId()!=null)throw new IllegalArgumentException("todoItem id should be null");
        TodoItem convertedToEntity = modelMapper.map(dto, TodoItem.class);
        TodoItem createdItem = todoItemRepository.save(convertedToEntity);
        TodoItemDto convertedToDto = modelMapper.map(createdItem, TodoItemDto.class);
        return convertedToDto;
    }

    @Override
    public TodoItemDto findById(Integer TodoItemId) throws ObjectNotFoundException {
        if (TodoItemId==null)throw new IllegalArgumentException("todoItem id is null");
        TodoItem result = todoItemRepository.findById(TodoItemId).orElseThrow(()-> new ObjectNotFoundException("todoItem id should be null"));
        return modelMapper.map(result, TodoItemDto.class);
    }

    @Override
    public List<TodoItemDto> findAll() {
        return modelMapper.map(todoItemRepository.findAll() , new TypeToken<List<TodoItemDto>>() {}.getType());
    }
}
