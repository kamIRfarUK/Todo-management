package com.springboot_project.mywebapp.todo;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

import org.springframework.stereotype.Service;

import jakarta.validation.Valid;

@Service
public class TodoService {

	
	private static List<Todo> todos=new ArrayList<>();
	
	private static int todosCount=0;
	
	static {
		todos.add(new Todo(++todosCount,"in28min","Learn AWS in 30 days",LocalDate.now().plusYears(1),false));
		todos.add(new Todo(++todosCount,"jermiah","Learn docker masterclass",LocalDate.now().plusYears(1),false));
		todos.add(new Todo(++todosCount,"firmpong","Learn java 8 new features",LocalDate.now().plusYears(1),false));
		todos.add(new Todo(++todosCount,"basersk","Learn spring framework",LocalDate.now().plusYears(1),false));
		
	}
	
	public List<Todo> findByUsername(String username){
		Predicate<? super Todo> predicate = todo -> todo.getUsername().equalsIgnoreCase(username);
		return todos.stream().filter(predicate).toList();
	}
	
	public void addTodo(String username,String description,LocalDate targetDate,boolean done) {
		Todo todo=new Todo(++todosCount,username,description,targetDate,done);
		todos.add(todo);
	}

	public void deleteById(int id) {
		Predicate<? super Todo> predicate = todo -> todo.getId() == id;
		todos.removeIf(predicate);
		
	}

	public Todo findById(int id) {
		Predicate<? super Todo> predicate = todo -> todo.getId() == id;
		Todo todo = todos.stream().filter(predicate).findFirst().get();
		return todo;
	}

	public void updateTodo(@Valid Todo todo) {
		deleteById(todo.getId());
		todos.add(todo);
		
	}


}
