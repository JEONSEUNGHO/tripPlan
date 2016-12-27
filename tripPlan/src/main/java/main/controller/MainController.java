package main.controller;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;


@Controller
public class MainController {

	@RequestMapping(value = "/main.do", method = RequestMethod.GET)
	public String form2() {
		return "main";
	}
	
	@RequestMapping(value ="/mainIndex.do", method = RequestMethod.GET)
	public String main(){
		return "myPage";
	}

}
