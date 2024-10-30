package com.todo.springboot.myfirstwebapp.todo;

import java.time.LocalDate;
import java.util.List;
import java.util.ArrayList;


import org.springframework.stereotype.Service;

@Service
public class TodoService {
	
	private static List<Todo> todos;
	static {
		todos=new ArrayList<Todo>();
		todos.add(new Todo(1, "deepak", "Learn coding", LocalDate.now().plusYears(1)
				, false));
		todos.add(new Todo(1, "deepak", "Learn React", LocalDate.now().plusYears(2)
				, false));
		todos.add(new Todo(1, "deepak", "Learn SpringBoot", LocalDate.now().plusYears(3)
				, false));
	}
	
	public List<Todo> findByUsername(String username){
		return todos;
	}
}
