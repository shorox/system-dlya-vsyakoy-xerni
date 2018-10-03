package ru.rogaandkopyta.controller;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import ru.rogaandkopyta.model.Department;
import ru.rogaandkopyta.repository.DepartmentRepository;

import java.util.List;

@RestController
@RequestMapping("/department")
public class DepartmentController {

    // fetch('/department', {method: 'POST', headers: {'Content-Type': 'application/json'}, body: JSON.stringify({'name': 'Производство мягкой мебели'})}).then(result => console.log(result))
    // fetch('/department', {method: 'GET', headers: {'Content-Type': 'application/json'}}).then(result => console.log(result))
    // fetch('/department/4', {method: 'PUT', headers: {'Content-Type': 'application/json'}, body: JSON.stringify('112')}).then(result => console.log(result))
    // fetch('/department/4', {method: 'DELETE', headers: {'Content-Type': 'application/json'}}).then(result => console.log(result))

    @Autowired
    private DepartmentRepository departmentRepository;

    @GetMapping
    public List<Department> getAllDepartments(){
        return (List<Department>) departmentRepository.findAll();
    }

    @GetMapping("{id}")
    public Department getDepartment(@PathVariable("id") Department department){
        return department;
    }

    @PostMapping
    public Department create(@RequestBody Department department){
        return departmentRepository.save(department);
    }

    @PutMapping("{id}")
    public Department update(@PathVariable("id") Department departmentFromDb, @RequestBody Department department){
        BeanUtils.copyProperties(department, departmentFromDb, "id");
        return departmentRepository.save(departmentFromDb);
    }

    @DeleteMapping("{id}")
    public void delete(@PathVariable("id") Department department){
        departmentRepository.delete(department);
    }
}
