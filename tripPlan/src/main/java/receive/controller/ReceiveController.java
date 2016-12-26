package receive.controller;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class ReceiveController {

	@RequestMapping(value = "/receive.do")
	public String form() {
		
		return "receive/receive";
	}


}
