package com.todo.springboot.myfirstwebapp.hello;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

record MyClass(int rollno, String name) {}

@Controller
public class SayHelloController {
	@RequestMapping("say-hello")
	@ResponseBody
	public String sayHello() {
		return "Hello world! It's Deepak";
	}
}
