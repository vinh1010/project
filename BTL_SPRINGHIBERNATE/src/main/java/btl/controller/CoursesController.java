package btl.controller;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.StandardOpenOption;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
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
import org.springframework.web.multipart.MultipartFile;

import btl.dao.CoursesDAO;
import btl.dao.LabsDAO;
import btl.dao.TeachersDAO;
import btl.entity.Courses;
import btl.entity.Labs;
import btl.entity.Teachers;

@Controller
public class CoursesController {
	@InitBinder
	public void initBinder(WebDataBinder data) {
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
		data.registerCustomEditor(Date.class, new CustomDateEditor(dateFormat, true));
	}
	
	@Autowired
	private CoursesDAO coursesDAO;
	@Autowired
	private LabsDAO labsDAO;
	@Autowired
	private TeachersDAO teachersDAO;
	
	@RequestMapping("/admin/listCourses")
	public String listCourses(Model model) {
		List<Courses> list = coursesDAO.listCourses();
		List<Labs> labs = labsDAO.listLab();
		model.addAttribute("listLab", labs);
		model.addAttribute("list", list);
		return "admins/pages/courses/listCourse";
	}
	
	@RequestMapping("/admin/initAddCourse")
	public String initAddCourse(Model model) {
		Courses courses = new Courses();
		model.addAttribute("c", courses);
		
		List<Labs> labs = labsDAO.listLab();
		model.addAttribute("listLab", labs);
		
		List<Teachers> teachers = teachersDAO.listAdmin();
		model.addAttribute("listTeach",teachers);
		return "admins/pages/courses/addCourse";
	}
	
	@RequestMapping("/admin/addCourse")
	public String addCourse(@Valid @ModelAttribute("c") Courses courses, BindingResult result, @RequestParam("avartar") MultipartFile multipartFile, HttpServletRequest request,Model model) {
		if (result.hasErrors()) {
			model.addAttribute("c", courses);
			
			List<Labs> labs = labsDAO.listLab();
			model.addAttribute("listLab", labs);
			
			List<Teachers> teachers = teachersDAO.listAdmin();
			model.addAttribute("listTeach",teachers);
			return "admins/pages/courses/addCourse";
		}
		else {
			String path = request.getServletContext().getRealPath("resources/images/courses");
			File f = new File(path);
			if (!f.exists()) {
				f.mkdir();
			}
			File dest = new File(f.getAbsolutePath() + "/" + multipartFile.getOriginalFilename());
			if (!dest.exists()) {
				try {
					Files.write(dest.toPath(), multipartFile.getBytes(), StandardOpenOption.CREATE);
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			courses.setImages(multipartFile.getOriginalFilename());
			boolean check = coursesDAO.addCourses(courses);
			if (check) {
				model.addAttribute("success", "Insert success");
				return "redirect:/admin/listCourses";
			} else {
				model.addAttribute("error", "Insert False !");
				model.addAttribute("c", courses);
				return "redirect:/admin/initAddCourse";
			}
		}
	}
	
	@RequestMapping("/admin/initUpdateCourse")
	public String initUpdateCourse(@RequestParam("id") String couId, Model model) {
		Courses courses = coursesDAO.findById(couId);
		List<Labs> labs = labsDAO.listLab();
		model.addAttribute("listLab", labs);
		model.addAttribute("c", courses);
		List<Teachers> teachers = teachersDAO.listAdmin();
		model.addAttribute("listTeach",teachers);
		return "admins/pages/courses/updateCourse";
	}
	
	@RequestMapping("/admin/updateCourse")
	public String updateCourse(@Valid @ModelAttribute("c") Courses courses, BindingResult result, @RequestParam("avartar") MultipartFile multipartFile, HttpServletRequest request,Model model) {
		if (result.hasErrors()) {
			model.addAttribute("c", courses);
			
			List<Labs> labs = labsDAO.listLab();
			model.addAttribute("listLab", labs);
			
			List<Teachers> teachers = teachersDAO.listAdmin();
			model.addAttribute("listTeach",teachers);
			return "admins/pages/courses/updateCourse";
		}
		else {
			String path = request.getServletContext().getRealPath("resources/images/courses");
			File f = new File(path);
			if (!f.exists()) {
				f.mkdir();
			}
			File dest = new File(f.getAbsolutePath() + "/" + multipartFile.getOriginalFilename());
			if (!dest.exists()) {
				try {
					Files.write(dest.toPath(), multipartFile.getBytes(), StandardOpenOption.CREATE);
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			
			String a = multipartFile.getOriginalFilename();
			
			if (a.length() == 0) {
				boolean check = coursesDAO.update(courses);
				if (check) {
					model.addAttribute("success", "Update success");
					return "redirect:/admin/listCourses";
				} else {
					model.addAttribute("error", "Update False !");
					model.addAttribute("c", courses);
					return "redirect:/admin/initUpdateCourse";
				}
			}
			else {
				courses.setImages(multipartFile.getOriginalFilename());
				boolean check = coursesDAO.update(courses);
				if (check) {
					model.addAttribute("success", "Update success");
					return "redirect:/admin/listCourses";
				} else {
					model.addAttribute("error", "Update False !");
					model.addAttribute("c", courses);
					return "redirect:/admin/initUpdateCourse";
				}
			}
		}
	}
	
	@RequestMapping("/admin/detailCourse")
	public String detailCourse(@RequestParam("id") String couId, Model model) {
		Courses courses = coursesDAO.findById(couId);
		List<Labs> labs = labsDAO.listLab();
		model.addAttribute("listLab", labs);
		model.addAttribute("c", courses);
		List<Teachers> teachers = teachersDAO.listAdmin();
		model.addAttribute("listTeach",teachers);
		return "admins/pages/courses/detailCourse";
	}
	
	@RequestMapping("/admin/deleteCourse")
	public String deleteCourse(@RequestParam("id") String couId, Model model) {
		Courses courses = coursesDAO.findById(couId);
		courses.setStatus(false);
		boolean check = coursesDAO.update(courses);
		if (check) {
			model.addAttribute("success", "Delete success");
			return "redirect:/admin/listCourses";
		}
		else {
			model.addAttribute("error", "Delete False !");
			return "redirect:/admin/listCourses";
		}
	}
	
	@RequestMapping("/admin/searchCourse")
	public String searchTeacher(@RequestParam("search") String name, Model model) {
		List<Courses> list = coursesDAO.findByName(name);
		model.addAttribute("list", list);
		return "admins/pages/courses/listCourse";
	}
}
