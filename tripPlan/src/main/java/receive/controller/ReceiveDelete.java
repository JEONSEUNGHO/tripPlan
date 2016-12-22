package receive.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import receive.Service.ReceiveService;

@Controller
public class ReceiveDelete {
	@Autowired
	private ReceiveService service;

	public void setService(ReceiveService service) {
		this.service = service;

	}
}
