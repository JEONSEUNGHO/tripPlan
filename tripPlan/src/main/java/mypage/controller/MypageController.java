package mypage.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("/mypage/mypage")
public class MypageController {

	@RequestMapping(method = RequestMethod.GET)
	public String form() {

		return "view/mypage/mypage";
	}
}