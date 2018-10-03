package ru.rogaandkopyta.controller;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import ru.rogaandkopyta.model.Employee;
import ru.rogaandkopyta.repository.EmployeeRepository;

import java.util.List;

@RestController
@RequestMapping("/employee")
public class EmployeeController {

    @Autowired
    private EmployeeRepository employeeRepository;

    @GetMapping
    public List<Employee> getAllEmployees(){
        return (List<Employee>) employeeRepository.findAll();
    }

    @GetMapping("{id}")
    public Employee getEmployee(@PathVariable("id") Employee employee){
        return employee;
    }

    @PostMapping
    public Employee create(@RequestBody Employee employee){
        return employeeRepository.save(employee);
    }

    @PutMapping("{id}")
    public Employee update(@PathVariable("id") Employee employeeFromDb, @RequestBody Employee employee){
        BeanUtils.copyProperties(employee, employeeFromDb, "id");
        return employeeRepository.save(employeeFromDb);
    }

    @DeleteMapping("{id}")
    public void delete(@PathVariable("id") Employee employee){
        employeeRepository.delete(employee);
    }
}
