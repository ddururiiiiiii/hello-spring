package hello.hellospring.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class helloController {
	
	@GetMapping("hello")
	public String hello (Model model) {
		model.addAttribute("data", "hello!");
		return "hello";
	}
	
	@GetMapping("hello-mvc")
    public String helloMvc(@RequestParam("name") String name, Model model) {
        model.addAttribute("name", name);
        return "hello-template";
    }
	
	//@ResponseBody : http 프로토콜의 바디 부분에 직접 넣어주겠다.view-resolver사용 안함. 
	//xml이 무겁고 불편해서 json으로 반환한다 보통.
	@GetMapping("hello-string")
	@ResponseBody
	public String helloString(@RequestParam("name") String name) {
		return "hello " + name;
	}
	
	@GetMapping("hello-api")
	@ResponseBody
	public Hello helloApi(@RequestParam("name") String name) {
		Hello Hello = new Hello();
		Hello.setName(name);
		return Hello;
	}
	
	static class Hello {
		
        private String name;
        
        public String getName() {
            return name;
        }
        
        public void setName(String name) {
            this.name = name;
        } 
        
	}
	
}
