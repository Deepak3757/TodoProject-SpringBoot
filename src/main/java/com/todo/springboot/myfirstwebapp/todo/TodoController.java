package com.todo.springboot.myfirstwebapp.todo;

import java.time.LocalDate;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;

@Controller
@SessionAttributes("name")
public class TodoController {
	
	private TodoService todoService;
	
	public TodoController(TodoService todoService) {
		super();
		this.todoService = todoService;
	}

	@RequestMapping("list-todos")
	public String listAllTodos(ModelMap model) {	
		model.put("todos", todoService.findByUsername("deepak"));
		return "listTodos";
	}
	
	@RequestMapping(value="add-todo", method=RequestMethod.GET)
	public String showNewTodoPage() {	
		return "todo";
	}
	@RequestMapping(value="add-todo", method=RequestMethod.POST)
	public String addNewTodoPage(@RequestParam String description, ModelMap model) {	
		
		String username=(String)model.get("name");
		todoService.addTodo(username, description, LocalDate.now().plusYears(1), false);
		
		return "redirect:list-todos";
	}
	
	
}
