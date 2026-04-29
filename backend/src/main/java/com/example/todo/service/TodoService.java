package com.example.todo.service;

import com.example.todo.model.Todo;
import com.example.todo.repository.TodoRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TodoService {

    private final TodoRepository repository;

    public TodoService(TodoRepository repository) {
        this.repository = repository;
    }

    public List<Todo> getAll() {
        return repository.findAll();
    }

    public Todo create(Todo todo) {
        return repository.save(todo);
    }

    public Optional<Todo> toggleComplete(Long id) {
        return repository.findById(id).map(todo -> {
            todo.setCompleted(!todo.isCompleted());
            return repository.save(todo);
        });
    }

    public void delete(Long id) {
        repository.deleteById(id);
    }
}
