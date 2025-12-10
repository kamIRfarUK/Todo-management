package com.springboot_project.mywebapp;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;


@Controller
public class helloController {
	
//return string to url	
	@RequestMapping("say-hello")
	@ResponseBody
	public String sayHello() {
		return "Hello!!";
	}
	
//return HTML to url
	@RequestMapping("say-hello-html")
	@ResponseBody
	public String sayHelloHTML() {
		StringBuffer sb = new StringBuffer();
		sb.append("<html>");
		sb.append("<head>");
		sb.append("<title> My HTML Page </title>");
		sb.append("</head>");
		sb.append("<body>");
		sb.append("my HTML page - body");
		sb.append("</body>");
		sb.append("</html>");
		
		return sb.toString();	
	
	}
	
	
// return JSP to url 
//@ResponseBody-not required as its not view	
//add dependency-tomcat embed to run JSP in tomcat server	
	@RequestMapping("say-hello-jsp")
	public String sayHelloJSP() {
		return "sayHello";
	}
	
}
