package com.todo.springboot.myfirstwebapp.todo;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

import org.springframework.stereotype.Service;

import jakarta.validation.Valid;

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
		Predicate<Todo> predicate=todo->todo.getUsername().equalsIgnoreCase(username);
		return todos.stream().filter(predicate).toList();
	}

	public void addTodo(String username, String description, LocalDate targetDate, boolean done) {
		Todo todo=new Todo(++todosCount, username, description, targetDate, done);
		todos.add(todo);
	}
	
	public void removeTodo(int id) {
		Predicate<Todo> predicate=todo->todo.getId()==id;
		todos.removeIf(predicate);
		
//		Alternatively
//		Todo toRemove=null;
//		for(Todo todo: todos) {
//			if(todo.getId()==id) {
//				toRemove=todo;
//				break;
//			}
//		}
//		if(toRemove!=null)
//			todos.remove(toRemove);
	}

	public Todo getTodoById(int id) {
		// TODO Auto-generated method stub
		for(Todo todo: todos) {
			if(todo.getId()==id)
				return todo;
		}
		return null;
	}

	public void updateTodo(@Valid Todo todo) {
		// TODO Auto-generated method stub
		removeTodo(todo.getId());
		todos.add(todo);
	}
}
