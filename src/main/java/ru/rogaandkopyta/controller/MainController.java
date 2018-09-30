package ru.rogaandkopyta.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import ru.rogaandkopyta.model.Employee;
import ru.rogaandkopyta.model.Order;
import ru.rogaandkopyta.repository.EmployeeRepository;
import ru.rogaandkopyta.repository.OrderRepository;

@RestController
public class MainController {

    @Autowired
    private EmployeeRepository employeeRepository;

    @Autowired
    private OrderRepository orderRepository;

    @GetMapping("employees")
    public @ResponseBody Iterable<Employee> getAllEmployees(){
        return employeeRepository.findAll();
    }

    @GetMapping
    public @ResponseBody Iterable<Order> getAllOrders(){
        return orderRepository.findAll();
    }


}
