package se.lexicon.todoapi.repository;

import org.springframework.data.repository.CrudRepository;
import se.lexicon.todoapi.model.entity.TodoItem;

import java.util.List;

public interface TodoItemRepository extends CrudRepository<TodoItem, Integer> {

    List<TodoItem> findByTitle(String title);
    List<TodoItem> findByTitleContains(String title);

}
