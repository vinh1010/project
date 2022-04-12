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

import btl.dao.TeachersDAO;
import btl.entity.Teachers;

@Controller
public class TeachersController {
	@InitBinder
	public void initBinder(WebDataBinder data) {
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
		data.registerCustomEditor(Date.class, new CustomDateEditor(dateFormat, true));
	}
	
	@Autowired
	private TeachersDAO teachersDAO;
	
	@RequestMapping("/admin/listTeacher")
	public String listTeacher(Model model) {
		List<Teachers> list = teachersDAO.listAdmin();
		model.addAttribute("list", list);
		return "admins/pages/teachers/listTeacher";
	}
	
	@RequestMapping("/admin/initAddTeacher")
	public String initAddTeacher(Model model) {
		Teachers teachers = new Teachers();
		model.addAttribute("t", teachers);
		return "admins/pages/teachers/addTeacher";
	}
	
	@RequestMapping("/admin/addTeacher")
	public String addTeacher(@Valid @ModelAttribute("t") Teachers teach, BindingResult result, @RequestParam("img") MultipartFile multipartFile, HttpServletRequest request,Model model) {
		if (result.hasErrors()) {
			model.addAttribute("t", teach);
			return "admins/pages/teachers/addTeacher";
		}
		else {
			String path = request.getServletContext().getRealPath("resources/images/teachers");
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
			teach.setAvartar(multipartFile.getOriginalFilename());
			boolean check = teachersDAO.addTeacher(teach);
			if (check) {
				model.addAttribute("success", "Insert success");
				return "redirect:/admin/listTeacher";
			} else {
				model.addAttribute("error", "Insert False !");
				model.addAttribute("t", teach);
				return "redirect:/admin/initAddTeacher";
			}
		}
	}
	
	@RequestMapping("/admin/initUpdateTeacher")
	public String initUpdateTeacher(@RequestParam("id") Integer stt, Model model) {
		Teachers teachers = teachersDAO.findByStt(stt);
		model.addAttribute("t", teachers);
		return "admins/pages/teachers/updateTeacher";
	}
	
	@RequestMapping("/admin/updateTeacher")
	public String updateTeacher(@Valid @ModelAttribute("t") Teachers teach, BindingResult result, @RequestParam("img") MultipartFile multipartFile, HttpServletRequest request,Model model) {
		if (result.hasErrors()) {
			model.addAttribute("t", teach);
			return "admins/pages/teachers/updateTeacher";
		}
		else {
			String path = request.getServletContext().getRealPath("resources/images/teachers");
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
				boolean check = teachersDAO.updateTeacher(teach);
				if (check) {
					model.addAttribute("success", "Update success");
					return "redirect:/admin/listTeacher";
				} else {
					model.addAttribute("error", "Update False !");
					model.addAttribute("t", teach);
					return "redirect:/admin/initUpdateTeacher";
				}
			}
			
			else {
				teach.setAvartar(multipartFile.getOriginalFilename());
				boolean check = teachersDAO.updateTeacher(teach);
				if (check) {
					model.addAttribute("success", "Update success");
					return "redirect:/admin/listTeacher";
				} else {
					model.addAttribute("error", "Update False !");
					model.addAttribute("t", teach);
					return "redirect:/admin/initUpdateTeacher";
				}
			}
		}
	}
	
	@RequestMapping("/admin/detailTeacher")
	public String detailTeacher(@RequestParam("id") Integer stt, Model model) {
		Teachers teachers = teachersDAO.findByStt(stt);
		model.addAttribute("t", teachers);
		return "admins/pages/teachers/detailTeacher";
	}
	
	@RequestMapping("/admin/deleteTeacher")
	public String deleteTeacher(@RequestParam("id") Integer stt, Model model) {
		Teachers teachers = teachersDAO.findByStt(stt);
		teachers.setStatus(false);
		boolean check = teachersDAO.updateTeacher(teachers);
		if (check) {
			model.addAttribute("success", "Delete success");
			return "redirect:/admin/listTeacher";
		}
		else {
			model.addAttribute("error", "Delete False !");
			return "redirect:/admin/listTeacher";
		}
	}
	
	@RequestMapping("/admin/searchTeacher")
	public String searchTeacher(@RequestParam("searchTech") String name, Model model) {
		List<Teachers> list = teachersDAO.findByName(name);
		model.addAttribute("list", list);
		return "admins/pages/teachers/listTeacher";
	}
}
