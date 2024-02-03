package ca.sheridancollege.vutran.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import ca.sheridancollege.vutran.repo.AccountRepo;
import ca.sheridancollege.vutran.repo.StudentRepo;
import lombok.AllArgsConstructor;

@Controller
@AllArgsConstructor
public class HomeController {
	private StudentRepo sr;
	private AccountRepo ar;
	@GetMapping("/")
	public String indexHTML(Model model) {
		System.out.println("List: " + sr.findByAccount_IdIsNotNull());		
		model.addAttribute("studentList", sr.findByAccount_IdIsNotNull());
		return "index";
	}
}
