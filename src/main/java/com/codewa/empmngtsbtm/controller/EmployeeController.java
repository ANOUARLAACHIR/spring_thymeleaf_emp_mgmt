package com.codewa.empmngtsbtm.controller;

import com.codewa.empmngtsbtm.entity.Employee;
import com.codewa.empmngtsbtm.service.EmployeeService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class EmployeeController {
    private EmployeeService employeeService;
    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @GetMapping("/")
    public String index(Model model) {
        model.addAttribute("employees", employeeService.getAllEmployees());
        return "index";
    }

    @GetMapping("/addNewEmployeeForm")
    public String addNewEmployeeForm(Model model) {
        model.addAttribute("employee", new Employee());
        return "addNewEmployeeForm";
    }
}
