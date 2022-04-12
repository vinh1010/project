package btl.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import btl.dao.CoursesDAO;
import btl.dao.SubjectsDAO;
import btl.entity.Courses;
import btl.entity.Subjects;

@Controller
public class SubjectsController {
	@Autowired
	private SubjectsDAO subjectsDAO;
	@Autowired
	private CoursesDAO coursesDAO;
	
	@RequestMapping("/admin/listSubject")
	public String listSubjects(Model model) {
		List<Subjects> list = subjectsDAO.listSubAll();
		model.addAttribute("list", list);
		List<Courses> courses = coursesDAO.listCourses();
		model.addAttribute("listCourse", courses);
		return "admins/pages/subjects/listsubject";
	}
	
	@RequestMapping("/admin/initAddsubject")
	public String initAddsubjects(Model model) {
		Subjects subjects = new Subjects();
		model.addAttribute("sub", subjects);
		List<Courses> courses = coursesDAO.listCourses();
		model.addAttribute("listCourse", courses);
		return "admins/pages/subjects/addSubject";
	}
	
	@RequestMapping("/admin/addSubject")
	public String addSubject(@Valid @ModelAttribute("sub") Subjects subjects, BindingResult result, Model model) {
		if (result.hasErrors()) {
			model.addAttribute("sub", subjects);
			List<Courses> courses = coursesDAO.listCourses();
			model.addAttribute("listCourse", courses);
			return "admins/pages/subjects/addSubject";
		}
		else {
			boolean check = subjectsDAO.addSub(subjects);
			if (check) {
				model.addAttribute("success", "Insert success");
				return "redirect:/admin/listSubject";
			} else {
				model.addAttribute("error", "Insert False !");
				model.addAttribute("sub", subjects);
				return "redirect:/admin/initAddsubject";
			}
		}
	}
	
	@RequestMapping("/admin/initUpdateSubject")
	public String initUpdateSubject(@RequestParam("id") String subId, Model model) {
		Subjects subjects = subjectsDAO.findById(subId);
		model.addAttribute("sub", subjects);
		List<Courses> courses = coursesDAO.listCourses();
		model.addAttribute("listCourse", courses);
		return "admins/pages/subjects/updateSubject";
	}
	
	@RequestMapping("admin/updateSubject")
	public String updateSubject(@Valid @ModelAttribute("sub") Subjects subjects, BindingResult result, Model model) {
		if (result.hasErrors()) {
			model.addAttribute("sub", subjects);
			List<Courses> courses = coursesDAO.listCourses();
			model.addAttribute("listCourse", courses);
			return "admins/pages/subjects/updateSubject";
		}
		else {
			boolean check = subjectsDAO.updateSub(subjects);
			if (check) {
				model.addAttribute("success", "Update success");
				return "redirect:/admin/listSubject";
			} else {
				model.addAttribute("error", "Update False !");
				model.addAttribute("sub", subjects);
				return "redirect:/admin/initUpdateSubject";
			}
		}
	}
	
	@RequestMapping("admin/deleteSubject")
	public String deleteSubject(@RequestParam("id") String subId, Model model) {
		Subjects subjects = subjectsDAO.findById(subId);
		subjects.setStatus(false);
		boolean check = subjectsDAO.updateSub(subjects);
		if (check) {
			model.addAttribute("success", "Delete success");
			return "redirect:/admin/listSubject";
		}
		else {
			model.addAttribute("error", "Update False !");
			return "redirect:/admin/listSubject";
		}
	}
}
