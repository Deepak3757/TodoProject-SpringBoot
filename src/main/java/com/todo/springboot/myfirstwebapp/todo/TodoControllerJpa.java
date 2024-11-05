package com.todo.springboot.myfirstwebapp.todo;

import java.time.LocalDate;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;

import jakarta.validation.Valid;

@Controller
@SessionAttributes("name")
public class TodoControllerJpa {
	
	private TodoRepository todoRepo;
	
	

	public TodoControllerJpa(TodoRepository todoRepo) {
		super();
		this.todoRepo = todoRepo;
	}

	@RequestMapping("list-todos")
	public String listAllTodos(ModelMap model) {	
		model.put("todos", todoRepo.findByUsername(getLoggedinUsername()));
		return "listTodos";
	}
	
	
	private String getLoggedinUsername() {
		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
		return authentication.getName();
	}

	@RequestMapping(value="add-todo", method=RequestMethod.GET)
	public String showNewTodoPage(ModelMap model) {
		String username=(String)model.getAttribute("name");
		
		Todo todo=new Todo(0, username, "", LocalDate.now().plusYears(1), false);
		model.put("todo", todo);
		return "todo";
	}
	@RequestMapping(value="add-todo", method=RequestMethod.POST)
	public String addNewTodoPage(ModelMap model, @Valid Todo todo, BindingResult result) {
		if(result.hasErrors()) {
			return "todo";
		}
		
		String username=getLoggedinUsername();
		todo.setUsername(username);
		todoRepo.save(todo);
		
		return "redirect:list-todos";
	}
	
	@RequestMapping("delete-todo")
	public String deleteTodo(@RequestParam int id) {	
		todoRepo.deleteById(id);
		
		return "redirect:list-todos";
	}
	
	@RequestMapping(value="update-todo", method=RequestMethod.GET)
	public String updateTodo(@RequestParam int id, ModelMap model) {	
		Todo todo=todoRepo.findById(id).get();
		model.addAttribute("todo", todo);
		return "todo";
	}
	@RequestMapping(value="update-todo", method=RequestMethod.POST)
	public String updateTodo(ModelMap model, @Valid Todo todo, BindingResult result) {	
		if(result.hasErrors()) {
			return "todo";
		}
		
		String username=getLoggedinUsername();
		todo.setUsername(username);
		todoRepo.save(todo);
		
		return "redirect:list-todos";
	}
	
	
	
}
