package in.becoder.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import in.becoder.entities.Employee;
import in.becoder.service.EmployeeService;
import jakarta.servlet.http.HttpSession;

@Controller
public class HomeController {

	@Autowired
	public EmployeeService employeeService;

	@GetMapping("/")
	public String loadForm(Model model) {
		List<Employee> list = employeeService.getAllEmp();
		model.addAttribute("empList", list);
		return "index";
	}

	@GetMapping("/loadEmp")
	public String loadFormAndSaveEmp() {
		return "save_emp";
	}

	@GetMapping("/editEmp/{id}")
	public String loadFormAndEditEmp(@PathVariable Integer id, Model model) {
		Employee emp = employeeService.getEmpById(id);
		model.addAttribute("emp", emp);
		return "edit_emp";
	}

	@PostMapping("/saveEmp")
	public String saveEmployee(@ModelAttribute Employee employee, HttpSession session) {
		Employee saveEmp = employeeService.saveEmp(employee);
		if (saveEmp != null) {
			session.setAttribute("msg", "Register Successfully");
		} else {
			session.setAttribute("msg", "somethng is wrong on server");
		}
		return "redirect:/loadEmp";
	}

	@PostMapping("/updateEmp")
	public String updateEmployee(@ModelAttribute Employee employee, HttpSession session) {
		Employee updateEmp = employeeService.saveEmp(employee);
		if (updateEmp != null) {
			session.setAttribute("msg", "Update Successfully");
		} else {
			session.setAttribute("msg", "somethng is wrong on server");
		}
		return "redirect:/";
	}

	@DeleteMapping("/deleteEmp/{id}")
	public String deleteEmployee(@PathVariable Integer id, HttpSession session) {
		boolean deleteEmp = employeeService.deleteById(id);
		if (deleteEmp) {
			session.setAttribute("msg", "Update Successfully");
		} else {
			session.setAttribute("msg", "somethng is wrong on server");
		}
		return "redirect:/";
	}

}
