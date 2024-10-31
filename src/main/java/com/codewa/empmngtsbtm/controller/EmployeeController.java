package com.codewa.empmngtsbtm.controller;

import com.codewa.empmngtsbtm.entity.Employee;
import com.codewa.empmngtsbtm.service.EmployeeService;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class EmployeeController {
    private final EmployeeService employeeService;

    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @GetMapping("/")
    public String index(Model model) {
        return paginateAllEmployees(1, "firstName", "asc", model);
    }

    @GetMapping("/addNewEmployeeForm")
    public String addNewEmployeeForm(Model model) {
        model.addAttribute("employee", new Employee());
        return "addNewEmployeeForm";
    }

    @PostMapping("/saveEmployee")
    public String saveEmployee(@ModelAttribute("employee") Employee employee) {
        employeeService.saveEmployee(employee);
        return "redirect:/";
    }

    @GetMapping("/showUpdateForm/{id}")
    public String showFormUpdate(@PathVariable long id, Model model) {
        Employee employee = employeeService.getEmployeeById(id);
        model.addAttribute("employee", employee);
        return "showUpdateForm";
    }

    @GetMapping("/deleteEmployee/{id}")
    public String deleteEmployee(@PathVariable long id) {
        employeeService.deleteEmployee(id);
        return "redirect:/";
    }

    @GetMapping("/page/{pageNo}")
    public String paginateAllEmployees(@PathVariable int pageNo,
            @RequestParam("sortField") String sortField,
            @RequestParam("sortDir") String sortDir
            ,Model model) {
        int size = 5;
        Page<Employee> page = employeeService.pagination(pageNo, size, sortField, sortDir);
        List<Employee> employees = page.getContent();
        model.addAttribute("currentPage", pageNo);
        model.addAttribute("totalPages", page.getTotalPages());
        model.addAttribute("totalElements", page.getTotalElements());
        model.addAttribute("sortField", sortField);
        model.addAttribute("sortDir", sortDir);
        model.addAttribute("reverseSortDir", sortDir.equals("asc") ? "desc" : "asc");
        model.addAttribute("employees", employees);
        return "index";
    }
}
