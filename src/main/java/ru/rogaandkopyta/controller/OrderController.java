package ru.rogaandkopyta.controller;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import ru.rogaandkopyta.model.Order;
import ru.rogaandkopyta.repository.OrderRepository;

import java.time.LocalDateTime;
import java.util.List;

@RestController
@RequestMapping("/order")
public class OrderController {

    @Autowired
    private OrderRepository orderRepository;

    @GetMapping
    public List<Order> getAllOrders(){
        return (List<Order>) orderRepository.findAll();
    }

    @GetMapping("{id}")
    public Order getOrder(@PathVariable("id") Order order){
        return order;
    }

    @PostMapping
    public Order create(@RequestBody Order order){
        order.setCreatedDate(LocalDateTime.now());
        return orderRepository.save(order);
    }

    @PutMapping("{id}")
    public Order update(@PathVariable("id") Order orderFromDb, @RequestBody Order order){
        BeanUtils.copyProperties(order, orderFromDb, "id");
        return orderRepository.save(orderFromDb);
    }

    @DeleteMapping("{id}")
    public void delete(@PathVariable("id") Order order){
        orderRepository.delete(order);
    }
}
