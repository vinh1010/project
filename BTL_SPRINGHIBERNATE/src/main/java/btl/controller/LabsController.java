package btl.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import btl.dao.LabsDAO;
import btl.entity.Labs;

@Controller
public class LabsController {
	@Autowired
	private LabsDAO labsDAO;
	
	@RequestMapping("/admin/listLab")
	public String listLab(Model model) {
		List<Labs> list = labsDAO.listLabAll();
		model.addAttribute("list", list);
		return "admins/pages/labs/listLab";
	}
	
	@RequestMapping("/admin/initAddLab")
	public String initAddLab(Model model) {
		Labs labs = new Labs();
		model.addAttribute("l", labs);
		return "admins/pages/labs/addLab";
	}
	
	@RequestMapping("/admin/addLab")
	public String addLab(@ModelAttribute("l") Labs labs, Model model) {
		boolean check = labsDAO.addLab(labs);
		if (check) {
			model.addAttribute("success", "Insert success");
			return "redirect:/admin/listLab";
		} else {
			model.addAttribute("error", "Insert False !");
			model.addAttribute("l", labs);
			return "redirect:/admin/initAddLab";
		}
	}
	
	@RequestMapping("/admin/initUpdateLab")
	public String initUpdateLab(@RequestParam("id") String labId, Model model) {
		Labs labs = labsDAO.findById(labId);
		model.addAttribute("l", labs);
		return "admins/pages/labs/updateLab";
	}
	
	@RequestMapping("/admin/updateLab")
	public String updateLab(@ModelAttribute("l") Labs labs, Model model) {
		boolean check = labsDAO.updateLab(labs);
		if (check) {
			model.addAttribute("success", "Update success");
			return "redirect:/admin/listLab";
		} else {
			model.addAttribute("error", "Update False !");
			model.addAttribute("l", labs);
			return "admins/pages/labs/updateLab";
		}
	}
	
	@RequestMapping("/admin/deleteLab")
	public String deleteLab(@RequestParam("id") String labId, Model model) {
		Labs labs = labsDAO.findById(labId);
		labs.setStatus(false);
		boolean check = labsDAO.updateLab(labs);
		if (check) {
			model.addAttribute("success", "Delete success");
			return "redirect:/admin/listLab";
		}
		else {
			model.addAttribute("error", "Delete False !");
			return "redirect:/admin/listLab";
		}
	}
}
