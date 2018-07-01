package com.crossover.tejpal.cotroller;

import java.util.List;
import java.util.UUID;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.context.support.XmlWebApplicationContext;
import org.springframework.web.servlet.ModelAndView;

import com.crossover.tejpal.model.Exam;
import com.crossover.tejpal.model.Test;
import com.crossover.tejpal.model.User;
import com.crossover.tejpal.model.UserTestResult;
import com.crossover.tejpal.service.ExamService;
import com.crossover.tejpal.service.TestService;
import com.crossover.tejpal.service.UserService;

@Controller
public class UserController {
	
	@Autowired
    private UserService userService;
	
	@Autowired
	private ExamService examService;
	
	@Autowired
	private TestService testService;
	
	@Autowired(required = true)
	@Qualifier(value = "examService")
	public void setExamService(ExamService es) {
		this.examService = es;
	}
	@Autowired(required=true)
	@Qualifier(value="userService")
	public void setUserService(UserService us){
		this.userService = us;
	}
	@RequestMapping(value = "/users", method = RequestMethod.GET)
	public String listPersons(Model model) {
		model.addAttribute("user", new User());
		model.addAttribute("userList", this.userService.listUsers());
		return "UserList";
	}
	
	@RequestMapping(value = "/users/new", method = RequestMethod.GET)
	public ModelAndView newUser(Model model) {
		ModelAndView mav = new ModelAndView("UserForm"); 
		mav.addObject("user", new User());
		return mav;
	}
	//For add and update person both
	@RequestMapping(value= "/users/add", method = RequestMethod.POST)
	public String addPerson(@ModelAttribute("user") User user){

		User userFetched = this.userService.getUserByName(user.getUserName());
		if (userFetched == null) {
			if (user.getUserId() == 0) {
				this.userService.addUser(user);
			} else {
				this.userService.updateUser(user);
			}
		}else{
			
		}
		return "redirect:/users";
		
	}
	@RequestMapping(value= "/user/login", method = RequestMethod.POST)
	public String userLogin(@ModelAttribute("user") User user, HttpServletRequest request){
		
		User userFetched = this.userService.getUserByName(user.getUserName());
		if (userFetched == null) {
			if (user.getUserId() == 0) {
				this.userService.addUser(user);
			} else {
				this.userService.updateUser(user);
			}
		}else{
			user = userFetched;
		}
		String testId=  UUID.randomUUID().toString();
		HttpSession session = request.getSession();
		Exam exam =examService.getExamById(1);
		Test test=new Test(testId,exam.getExamName(), exam.getExamId(),5);
		test.setTestid(testId);
		userService.createTestForUser(test);

		session.setAttribute("user", user);
		session.setAttribute("test",test);
		
		
		return "redirect:/question/getQuestions";
		
	}
	
	@RequestMapping(value = "/finishTest", method = RequestMethod.GET)
	public ModelAndView finishTest(HttpSession session) {
		
		
		Test test=(Test) session.getAttribute("test");
		List<UserTestResult> attemtedQuestions=testService.getAllQuestionsByTestId(test.getTestid());
		
		ModelAndView mav = new ModelAndView("endExam"); 
		mav.addObject("totalQuestionsAnswered", attemtedQuestions.size());
		mav.addObject("totalUnAnswered", test.getTotalQuestions()- attemtedQuestions.size());
		
		return mav;
	}
	@RequestMapping(value = "/confirmSubmission", method = RequestMethod.GET)
	public ModelAndView confirmTestSubmission(HttpSession session) {
		Test test=(Test) session.getAttribute("test");
		List<UserTestResult> attemtedQuestions=testService.getAllQuestionsByTestId(test.getTestid());
		int score=testService.getScoreByValidatingAnswers(attemtedQuestions);
		System.out.println("Your Score is "+score);
		ModelAndView mav = new ModelAndView("endExam"); 
		mav.addObject("message", score);
		return mav;
	}
	
	
	
	public static void main(String[] args) {
		XmlWebApplicationContext c=new XmlWebApplicationContext();
		c.getBeanDefinitionNames();
		c.close();
	}

}
