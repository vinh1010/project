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

import btl.dao.StudentsDAO;
import btl.entity.Students;

@Controller
public class StudentsController {
	@InitBinder
	public void initBinder(WebDataBinder data) {
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
		data.registerCustomEditor(Date.class, new CustomDateEditor(dateFormat, true));
	}
	
	@Autowired
	private StudentsDAO studentsDAO;
	
	@RequestMapping("/admin/listStudent")
	public String listStudent(Model model) {
		List<Students> list = studentsDAO.listStudents();
		model.addAttribute("list", list);
		return "admins/pages/students/listStudent";
	}
	
	@RequestMapping("/admin/initAddStudent")
	public String initAddStudent(Model model) {
		Students students = new Students();
		model.addAttribute("s", students);
		return "admins/pages/students/addStudent";
	}
	
	@RequestMapping("/admin/addStudent")
	public String addStudent(@Valid @ModelAttribute("s") Students students, BindingResult result, @RequestParam("img") MultipartFile multipartFile, HttpServletRequest request,Model model) {
		if (result.hasErrors()) {
			model.addAttribute("s", students);
			return "admins/pages/students/addStudent";
		}
		else {
			String path = request.getServletContext().getRealPath("resources/images/students");
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
			students.setAvartar(multipartFile.getOriginalFilename());
			boolean check = studentsDAO.addStudent(students);
			if (check) {
				model.addAttribute("success", "Insert success");
				return "redirect:/admin/listStudent";
			} else {
				model.addAttribute("error", "Insert False !");
				model.addAttribute("s", students);
				return "redirect:/admin/initAddStudent";
			}
		}
	}
	
	@RequestMapping("/admin/initUpdateStudent")
	public String initUpdateTeacher(@RequestParam("id") Integer stt, Model model) {
		Students students = studentsDAO.findById(stt); 
		model.addAttribute("s", students);
		return "admins/pages/students/updateStudent";
	}
	
	@RequestMapping("/admin/updateStudent")
	public String updateStudent(@Valid @ModelAttribute("s") Students students, BindingResult result, @RequestParam("img") MultipartFile multipartFile, HttpServletRequest request,Model model) {
		if (result.hasErrors()) {
			model.addAttribute("s", students);
			return "admins/pages/students/updateStudent";
		}
		else {
			String path = request.getServletContext().getRealPath("resources/images/students");
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
				boolean check = studentsDAO.updateStudent(students);
				if (check) {
					model.addAttribute("success", "Update success");
					return "redirect:/admin/listStudent";
				} else {
					model.addAttribute("error", "Update False !");
					model.addAttribute("s", students);
					return "redirect:/admin/initUpdateStudent";
				}
			}
			else {
				students.setAvartar(multipartFile.getOriginalFilename());
				boolean check = studentsDAO.updateStudent(students);
				if (check) {
					model.addAttribute("success", "Update success");
					return "redirect:/admin/listStudent";
				} else {
					model.addAttribute("error", "Update False !");
					model.addAttribute("s", students);
					return "redirect:/admin/initUpdateStudent";
				}
			}
		}
	}
	
	@RequestMapping("/admin/detailStudent")
	public String detailStudent(@RequestParam("id") Integer stt, Model model) {
		Students students = studentsDAO.findById(stt);
		model.addAttribute("s", students);
		return "admins/pages/students/detailStudent";
	}
	
	@RequestMapping("/admin/deleteStudent")
	public String deleteStudent(@RequestParam("id") Integer stt, Model model) {
		Students students = studentsDAO.findById(stt);
		students.setStatus(false);
		boolean check = studentsDAO.updateStudent(students);
		if (check) {
			model.addAttribute("success", "Delete success");
			return "redirect:/admin/listStudent";
		}
		else {
			model.addAttribute("error", "Delete False !");
			return "redirect:/admin/listStudent";
		}
	}
	
	@RequestMapping("admin/searchStudent")
	public String searchStudent(@RequestParam("searchStu") String name, Model model) {
		List<Students> list = studentsDAO.findByName(name);
		model.addAttribute("list", list);
		return "admins/pages/students/listStudent";
	}
	
}
