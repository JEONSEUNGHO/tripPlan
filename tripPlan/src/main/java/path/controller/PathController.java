package path.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class PathController {

	@RequestMapping(value="/path", method = RequestMethod.GET)
	public String submit(){
		return "path"; 
	}
}
