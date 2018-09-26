package ru.rogaandkopyta.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import ru.rogaandkopyta.model.Employee;
import ru.rogaandkopyta.repository.EmployeeRepository;

@Controller
@RequestMapping(path = "/")
public class MainController {

    @Autowired
    private EmployeeRepository employeeRepository;

    @GetMapping(path = "/employees")
    public @ResponseBody Iterable<Employee> getAllEmployees(){
        return employeeRepository.findAll();
    }
}
