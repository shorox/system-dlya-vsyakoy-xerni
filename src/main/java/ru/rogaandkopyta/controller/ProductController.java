package ru.rogaandkopyta.controller;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import ru.rogaandkopyta.model.Department;
import ru.rogaandkopyta.model.Product;
import ru.rogaandkopyta.repository.DepartmentRepository;
import ru.rogaandkopyta.repository.ProductRepository;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/product")
public class ProductController {

    @Autowired
    private ProductRepository productRepository;

    @GetMapping
    public List<Product> getAllProducts(){
        return (List<Product>) productRepository.findAll();
    }

    @GetMapping("{id}")
    public Product getEmployee(@PathVariable("id") Product product){
        return product;
    }

    @PostMapping
    public Product create(@RequestBody Product product){
        return productRepository.save(product);
    }

    @PutMapping("{id}")
    public Product update(@PathVariable("id") Product productFromDb, @RequestBody Product product){
        BeanUtils.copyProperties(product, productFromDb, "id");
        return productRepository.save(productFromDb);
    }

    @DeleteMapping("{id}")
    public void delete(@PathVariable("id") Product product){
        productRepository.delete(product);
    }
}
