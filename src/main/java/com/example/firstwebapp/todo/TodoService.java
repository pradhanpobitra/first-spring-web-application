package com.example.firstwebapp.todo;

import jakarta.validation.Valid;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class TodoService {
    private static List<Todo> todos;

    static {
        todos = new ArrayList<>();
        todos.add(
                new Todo(1L, "ppradhan", "Learn AWS", LocalDate.now().plusMonths(6L), false)
        );
        todos.add(
                new Todo(2L, "ppradhan", "Learn DevOps", LocalDate.now().plusMonths(6L), false)
        );
        todos.add(
                new Todo(3L, "ppradhan", "Learn GCP", LocalDate.now().plusMonths(6L), false)
        );
    }

    public List<Todo> findByUserName(String userName) {
        return todos.stream().filter(
                todo -> todo.getUserName().equalsIgnoreCase(userName)
        ).toList();
    }

    public void addTodoToList(String username, String description, LocalDate date) {
        Long todosSize = (long) todos.size() + 1;
        Todo newTodo = new Todo(todosSize, username, description, date, false);
        todos.add(newTodo);
    }

    public void deleteTodoById(Long id) {
        todos.removeIf(
                todo -> todo.getId().equals(id)
        );
    }

    public Todo findById(Long id) {
        return todos.stream().filter(
                todo -> todo.getId().equals(id)
        ).findFirst().get();
    }

    public void updateTodo(Todo todo) {
        todos.removeIf(
                td -> td.getId().equals(todo.getId())
        );
        todos.add(todo);
    }
}
