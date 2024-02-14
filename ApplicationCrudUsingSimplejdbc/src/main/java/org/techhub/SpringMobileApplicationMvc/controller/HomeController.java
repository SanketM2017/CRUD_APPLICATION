package org.techhub.SpringMobileApplicationMvc.controller;

import java.io.IOException;
import java.net.CacheRequest;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.techhub.SpringMobileApplicationMvc.model.Student;
import org.techhub.SpringMobileApplicationMvc.model.loginPage;
import org.techhub.SpringMobileApplicationMvc.service.StudentService;

@Controller
public class HomeController {

	StudentService studentService = new StudentService();

	@RequestMapping(value = "/")
	public String test() {
		return "login";
	}

	@RequestMapping(value = "getlogin")
	public String loginpage(@ModelAttribute("model") loginPage login) {
		System.out.println(login.toString());
		if ("admin".equals(login.getUsername()) && "admin".equals(login.getPassword())) {
			return "home";

		} else
			return "login";
	}

	@RequestMapping(value = "/add")
	public String save() {
		return "addnewrecord";
	}

	@RequestMapping(value = "/save", method = RequestMethod.POST)
	public String addStudent(@ModelAttribute Student students, Map map) {
		boolean emailValidate = studentService.validateEmail(students);
		if (emailValidate) {
			if (studentService.isaddStudent(students)) {
				map.put("msg", "Record save sussefully....................");
				return "redirect:/view";
			} else {
				map.put("msg", "Record not save ....");
				return "addnewrecord";
			}
		} else {
			map.put("msg", "Record Already present in database .........");
			return "addnewrecord";
		}

	}

	@RequestMapping(value = "/view", method = RequestMethod.GET)
	public String view(Map<String, List<Student>> map) {
		List<Student> list = studentService.viewStudent();
		map.put("regrecord", list);
		return "view";
	}

	@RequestMapping(value = "/del", method = RequestMethod.GET)
	public String delrecord(@RequestParam("userid") Integer id, Map map) {
		studentService.delRecord(id);
		List<Student> list = studentService.viewStudent();
		map.put("regrecord", list);
		return "view";
	}

	@RequestMapping(value = "/upda", method = RequestMethod.GET)
	public String update(@RequestParam("userid") Integer id, @RequestParam("name") String n,
			@RequestParam("email") String e, @RequestParam("contact") String c, Map map)

	{
		map.put("i", id);
		map.put("name", n);
		map.put("email", e);
		map.put("contact", c);

		return "update";
	}

	@RequestMapping(value = "/fupdate", method = RequestMethod.POST)
	public String fupdate(Student s, Map<String, List<Student>> map) {
		boolean b = studentService.update(s);
		if (b) {
			List<Student> list = studentService.viewStudent();
			map.put("regrecord", list);
			return "view";
		} else {
			return "view";
		}
	}

	@RequestMapping(value = "/search", method = RequestMethod.GET)
	public String searchStudent() {
		return "Search";
	}

	@RequestMapping("/searchrecord")
	public String searchStudents(@RequestParam("name") String name, Model model) {
		List<Student> list = studentService.search(name);
		model.addAttribute("regrecord", list);
		return "view";
	}
}
