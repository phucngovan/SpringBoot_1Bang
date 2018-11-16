package com.phucdz.Employees.controller;

import com.phucdz.Employees.model.Employee;
import com.phucdz.Employees.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.validation.Valid;
import java.util.Optional;
@Controller
@RequestMapping("/")
public class EmployeeController {
    @Autowired
    private EmployeeService employeeService;
    @GetMapping
    public ModelAndView viewHome(@RequestParam("s") Optional<String> s, @PageableDefault(size=10) Pageable pageable) {
        Page<Employee> employees;
        if(s.isPresent()){
            employees = employeeService.findByName(s.get(), pageable);
        } else {
            employees = employeeService.findAll(pageable);
        }
        ModelAndView modelAndView = new ModelAndView("view");
        modelAndView.addObject("employees", employees);
        return modelAndView;
    }
    @GetMapping("/create")
    public  ModelAndView viewCreate() {
        ModelAndView modelAndView=new ModelAndView("create");
        modelAndView.addObject("employee",new Employee());
        return modelAndView;
    }
    @PostMapping("/create")
    public ModelAndView addEmployee(@Valid @ModelAttribute("employee") Employee employee, BindingResult bindingResult){
        ModelAndView modelAndView = new ModelAndView("create");
        if (bindingResult.hasFieldErrors()){
            return  modelAndView;
        }else {
            employeeService.save(employee);
            modelAndView.addObject("message","New employee created successfully");
            modelAndView.addObject("employee", new Employee());
            return modelAndView;
        }

    }
    @GetMapping("/delete/{id}")
    public ModelAndView viewDelete(@PathVariable("id") Long id, Employee employee) {
        ModelAndView modelAndView = new ModelAndView("delete");
        modelAndView.addObject("employee",employeeService.findById(id));
        return modelAndView;

    }
    @PostMapping("/delete")
    public ModelAndView deleteEmployee(@RequestParam Long id,Employee employee) {
        employee= employeeService.findById(id);
        if(employee != null) {
            employeeService.remove(id);
            ModelAndView modelAndView=new ModelAndView("delete");
            modelAndView.addObject("delete","delete successfully");
            return modelAndView;
        }else {
            ModelAndView modelAndView = new ModelAndView("delete");
            modelAndView.addObject("message","Not Customer To Delete..");
            return modelAndView;
        }

    }
    @GetMapping("/edit/{id}")
    public  ModelAndView viewEdit(@PathVariable("id") Long id,Employee employee) {
        ModelAndView modelAndView=new ModelAndView("edit");
        modelAndView.addObject("employee",employeeService.findById(id));
        return modelAndView;
    }
    @PostMapping("/edit")
    public ModelAndView editEmployee(@Valid @ModelAttribute("employee") Employee employee, BindingResult bindingResult){
        ModelAndView modelAndView = new ModelAndView("edit");
        if (bindingResult.hasFieldErrors()) {
            return modelAndView;
        } else {
            employeeService.save(employee);
            modelAndView.addObject("message", "employee updated successfully");
            return modelAndView;
        }
    }
}
