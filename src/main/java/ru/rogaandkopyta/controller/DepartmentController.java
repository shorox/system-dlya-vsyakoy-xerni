package ru.rogaandkopyta.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import ru.rogaandkopyta.model.Department;
import ru.rogaandkopyta.repository.DepartmentRepository;

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
    public @ResponseBody Iterable<Department> getAllDepartments(){
        return departmentRepository.findAll();
    }

    @GetMapping("{id}")
    public Department getDepartment(@PathVariable Long id){
        return departmentRepository.findById(id).get();
    }

    @PostMapping
    public Department create(@RequestBody String name){
        Department department = new Department();
        department.setName(name);

        departmentRepository.save(department);

        return department;
    }

    @PutMapping("{id}")
    public Department update(@PathVariable Long id, @RequestBody String name){
        Department department = getDepartment(id);
        department.setName(name);

        departmentRepository.save(department);

        return department;
    }

    @DeleteMapping("{id}")
    public void delete(@PathVariable Long id){
        departmentRepository.deleteById(id);
    }
}
