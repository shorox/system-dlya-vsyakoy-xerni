package ru.rogaandkopyta.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import ru.rogaandkopyta.model.Department;
import ru.rogaandkopyta.model.Product;
import ru.rogaandkopyta.repository.DepartmentRepository;
import ru.rogaandkopyta.repository.ProductRepository;

import java.util.Map;

@RestController
@RequestMapping("/product")
public class ProductController {

    @Autowired
    private ProductRepository productRepository;

    @Autowired
    private DepartmentRepository departmentRepository;

    @GetMapping
    public @ResponseBody Iterable<Product> getAllProducts(){
        return productRepository.findAll();
    }

    @GetMapping("{id}")
    public Product getEmployee(@PathVariable Long id){
        return productRepository.findById(id).get();
    }

    @PostMapping
    public Product create(@RequestBody Map<String, String> body){
        Department department = departmentRepository.findById(Long.parseLong(body.get("department_id"))).get();

        Product product = new Product();
        product.setName(body.get("name"));
        product.setDepartment(department);

        productRepository.save(product);

        return product;
    }

    @PutMapping("{id}")
    public Product update(@PathVariable Long id, @RequestBody Map<String, String> body){
        Product product = getEmployee(id);
        for(Map.Entry<String, String> entry : body.entrySet()){
            switch (entry.getKey()){
                case "name" :
                    product.setName(entry.getValue());
                    break;
                case "department_id" :
                    Department department = departmentRepository.findById(Long.parseLong(body.get("department_id"))).get();
                    product.setDepartment(department);
                    break;
            }
        }

        productRepository.save(product);

        return product;
    }

    @DeleteMapping("{id}")
    public void delete(@PathVariable Long id){
        productRepository.deleteById(id);
    }
}
