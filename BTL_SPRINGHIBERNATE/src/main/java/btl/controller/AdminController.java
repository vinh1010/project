package btl.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import btl.dao.CoursesDAO;
import btl.dao.Register_CourseDAO;
import btl.entity.Courses;
import btl.entity.Register_Course;

@Controller
public class AdminController {
	@Autowired 
	private Register_CourseDAO register_CourseDAO;
	@Autowired
	private CoursesDAO coursesDAO;
	
	@RequestMapping("/admin")
	public String login(@RequestParam(value = "error", required = false)String error, Model model) {
		if (error!=null) {
			model.addAttribute("mess", "Login False !");
		}
		return "admins/login";
	}
	
	@RequestMapping("/admin/logout")
	public String logout(Model model) {
		model.addAttribute("mess","Has logged out !!");
		return "redirect:/admin";
	}
	
	@RequestMapping("/admin/dashboard")
	public String dashboard(Model model) {
		return "admins/dashboard";
	}
	
	@RequestMapping("/admin/listRegisterCourse")
	public String listRegisterCourse(Model model) {
		List<Register_Course> register_Courses = register_CourseDAO.list();
		List<Courses> courses = coursesDAO.listCus();
		model.addAttribute("rc", register_Courses);
		model.addAttribute("c", courses);
		return "admins/pages/courses/listRgisCourse";
	}
	
	@RequestMapping("/admin/updateRegisterCourse")
	public String updateRegisterCourse(@RequestParam("id") Integer id, Model model) {
		Register_Course register_Course = register_CourseDAO.findById(id);
		register_Course.setStatus(true);
		boolean check = register_CourseDAO.update(register_Course);
		if (check) {
			model.addAttribute("success", "Update success");
			return "redirect:listRegisterCourse";
		}
		else {
			model.addAttribute("error", "Update False !");
			return "redirect:listRegisterCourse";
		}
	}
	
	@RequestMapping("admin/deleteRegisterCourse")
	public String deleteRegisterCourse(@RequestParam("id") Integer id, Model model) {
		boolean check = register_CourseDAO.delete(id);
		if (check) {
			model.addAttribute("success", "Delete success");
			return "redirect:listRegisterCourse";
		}
		else {
			model.addAttribute("error", "Delete False !");
			return "redirect:listRegisterCourse";
		}
	}
}
