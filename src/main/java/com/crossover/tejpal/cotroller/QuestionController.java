package com.crossover.tejpal.cotroller;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.crossover.tejpal.model.Question;
import com.crossover.tejpal.model.Test;
import com.crossover.tejpal.model.User;
import com.crossover.tejpal.model.UserTestResult;
import com.crossover.tejpal.service.QuestionService;
import com.crossover.tejpal.service.TestService;

@Controller
public class QuestionController {

	@Autowired
	private QuestionService questionService;

	@Autowired
	private TestService testService;

	
	@RequestMapping(value = "/question/getQuestions", method = RequestMethod.GET)
	public ModelAndView getAllQuestions() {
		List<Question> questionList = this.questionService.getAllQuestionByExamId(1);
		ModelAndView mv = new ModelAndView("test");
		mv.addObject("questions", questionList);
		System.out.println(questionList);
		return mv;
	}

	@RequestMapping(value = "/question/{id}", method = RequestMethod.GET)
	public ModelAndView getQuestionByQuestionId(@PathVariable("id") int id) {
		System.out.println("Entering getQuestionByQuestionId");
		Question q = this.questionService.getQuestionById(id);
		ModelAndView mv = new ModelAndView("question");
		mv.addObject("question", q);
		System.out.println("Exiting getQuestionByQuestionId");

		return mv;
	}

	@RequestMapping(value = "/question/submit", method = RequestMethod.POST)
	public @ResponseBody String saveUser(@RequestParam Map<String, String> requestParams, HttpSession session) throws Exception {
		String questionId = requestParams.get("questionId");
		String ansSubmitted = requestParams.get("ansSubmitted");
		
		User user=(User) session.getAttribute("user");
		Test test = (Test) session.getAttribute("test");

		System.out.println("question id: " + questionId);
		System.out.println("ansSubmitted id" + ansSubmitted);
		System.out.println("userId" + user.getUserId());
		System.out.println("testId " + test.getTestid());

		UserTestResult result =new UserTestResult(user.getUserId(),  Integer.parseInt(questionId), Integer.parseInt(ansSubmitted));
		result.setTestId(test.getTestid());
		this.testService.addUserTestResult(result);
		return "submitted";
	}

}
