package com.todo.springboot.myfirstwebapp.todo;

import java.time.LocalDate;
import java.util.List;
import java.util.ArrayList;

import org.springframework.stereotype.Service;

@Service
public class TodoService {

	private static List<Todo> todos;
	private static int todosCount = 0;
	static {
		todos = new ArrayList<Todo>();
		todos.add(new Todo(++todosCount, "deepak", "Learn coding", LocalDate.now().plusYears(1), false));
		todos.add(new Todo(++todosCount, "deepak", "Learn React", LocalDate.now().plusYears(2), false));
		todos.add(new Todo(++todosCount, "deepak", "Learn SpringBoot", LocalDate.now().plusYears(3), false));
	}

	public List<Todo> findByUsername(String username) {
		return todos;
	}

	public void addTodo(String username, String description, LocalDate targetDate, boolean done) {
		Todo todo=new Todo(++todosCount, username, description, targetDate, done);
		todos.add(todo);
	}
}
