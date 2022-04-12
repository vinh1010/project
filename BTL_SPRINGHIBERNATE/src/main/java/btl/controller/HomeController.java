package btl.controller;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import btl.dao.CoursesDAO;
import btl.dao.Register_CourseDAO;
import btl.dao.TeachersDAO;
import btl.entity.Courses;
import btl.entity.Register_Course;
import btl.entity.Teachers;


@Controller
public class HomeController {
	@InitBinder
	public void initBinder(WebDataBinder data) {
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
		data.registerCustomEditor(Date.class, new CustomDateEditor(dateFormat, true));
	}
	
	@Autowired
	private TeachersDAO teachersDAO;
	@Autowired
	private CoursesDAO coursesDAO;
	@Autowired
	private Register_CourseDAO register_CourseDAO;
	
	@RequestMapping(value = { "/", "home" })
	public String home(Model model) {
		List<Teachers> teachers = teachersDAO.listCus();
		model.addAttribute("listTeacher", teachers);
		
		List<Courses> courses = coursesDAO.listCus();
		model.addAttribute("listCouse", courses);
		
		return "customers/homeCustomer";
	}
	
	@RequestMapping("/initRegisterCourse")
	public String initRegisterCourse(@RequestParam("id") String id, Model model) {
		Courses courses = coursesDAO.findById(id);
		model.addAttribute("c", courses);
		Register_Course rc = new Register_Course();
		model.addAttribute("rc", rc);
		return "customers/register_course";
	}
	
	@RequestMapping("/registerCourse")
	public String registerCourse(@Valid @ModelAttribute("rc") Register_Course rc, BindingResult result, Model model) {
		if (result.hasErrors()) {
			model.addAttribute("ac", rc);
			return "customers/register_course";
		}
		else {
			boolean check = register_CourseDAO.add(rc);
			if (check) {
				return "redirect:/thankYou";
			}
			else {
				model.addAttribute("ac", rc);
				return "customers/register_course";
			}
		}
	}
	
	@RequestMapping("/thankYou")
	public String thank() {
		return "customers/thank";
	}
}
