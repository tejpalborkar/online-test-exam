package com.crossover.tejpal.cotroller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.context.support.XmlWebApplicationContext;
import org.springframework.web.servlet.ModelAndView;

import com.crossover.tejpal.model.Exam;
import com.crossover.tejpal.model.User;
import com.crossover.tejpal.service.ExamService;

@Controller
public class AppController {

	@Autowired
	private ExamService examService;
	
	@Autowired(required = true)
	@Qualifier(value = "examService")
	public void setExamService(ExamService es) {
		this.examService = es;
	}

	@RequestMapping(value = "/", method = RequestMethod.GET)
	public ModelAndView listPersons() {
		ModelAndView mav = new ModelAndView("index");
		Exam e = examService.getExamById(1);
		mav.addObject("exam", e);
		mav.addObject("user", new User());
		return mav;
	}

	/*@RequestMapping(value = "/persons", method = RequestMethod.GET)
	public String listPersons(Model model) {
		model.addAttribute("person", new Person());
		model.addAttribute("listPersons", this.personService.listPersons());
		return "person";
	}

	// For add and update person both
	@RequestMapping(value = "/person/add", method = RequestMethod.POST)
	public String addPerson(@ModelAttribute("person") Person p) {

		if (p.getId() == 0) {
			// new person, add it
			this.personService.addPerson(p);
		} else {
			// existing person, call update
			this.personService.updatePerson(p);
		}

		return "redirect:/persons";

	}

	@RequestMapping("/remove/{id}")
	public String removePerson(@PathVariable("id") int id) {

		this.personService.removePerson(id);
		return "redirect:/persons";
	}

	@RequestMapping("/edit/{id}")
	public String editPerson(@PathVariable("id") int id, Model model) {
		model.addAttribute("person", this.personService.getPersonById(id));
		model.addAttribute("listPersons", this.personService.listPersons());
		return "person";
	}*/

	public static void main(String[] args) {
		XmlWebApplicationContext c = new XmlWebApplicationContext();
		c.getBeanDefinitionNames();
		c.close();
	}
}
