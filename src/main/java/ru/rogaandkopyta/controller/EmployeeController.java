package ru.rogaandkopyta.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import ru.rogaandkopyta.model.Department;
import ru.rogaandkopyta.model.Employee;
import ru.rogaandkopyta.repository.DepartmentRepository;
import ru.rogaandkopyta.repository.EmployeeRepository;

import java.util.Map;

@RestController
@RequestMapping("/employee")
public class EmployeeController {

    @Autowired
    private EmployeeRepository employeeRepository;

    @Autowired
    private DepartmentRepository departmentRepository;

    @GetMapping
    public @ResponseBody Iterable<Employee> getAllEmployees(){
        return employeeRepository.findAll();
    }

    @GetMapping("{id}")
    public Employee getEmployee(@PathVariable Long id){
        return employeeRepository.findById(id).get();
    }

    @PostMapping
    public Employee create(@RequestBody Map<String, String> body){
        Department department = departmentRepository.findById(Long.parseLong(body.get("department_id"))).get();

        Employee employee = new Employee();
        employee.setFirstName(body.get("firstName"));
        employee.setLastName(body.get("lastName"));
        employee.setMiddleName(body.get("middleName"));
        employee.setDepartment(department);

        employeeRepository.save(employee);

        return employee;
    }

    @PutMapping("{id}")
    public Employee update(@PathVariable Long id, @RequestBody Map<String, String> body){
        Employee employee = getEmployee(id);
        for(Map.Entry<String, String> entry : body.entrySet()){
            switch (entry.getKey()){
                case "firstName" :
                    employee.setFirstName(entry.getValue());
                    break;
                case "lastName" :
                    employee.setLastName(entry.getValue());
                    break;
                case "middleName" :
                    employee.setMiddleName(entry.getValue());
                    break;
                case "department_id" :
                    Department department = departmentRepository.findById(Long.parseLong(body.get("department_id"))).get();
                    employee.setDepartment(department);
                    break;
            }
        }

        employeeRepository.save(employee);

        return employee;
    }

    @DeleteMapping("{id}")
    public void delete(@PathVariable Long id){
        employeeRepository.deleteById(id);
    }
}
