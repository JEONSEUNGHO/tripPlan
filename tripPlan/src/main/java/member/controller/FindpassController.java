package member.controller;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;


@Controller
public class FindpassController {

	@RequestMapping(value = "/findpass.do", method = RequestMethod.GET)
	public String form() {
		return "main";
	}
	
	@RequestMapping(value = "/findpass.do", method = RequestMethod.POST)
	public String submit() {
		return "main";
	}

}
