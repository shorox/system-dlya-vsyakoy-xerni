package ru.rogaandkopyta.repository;

import org.springframework.data.repository.CrudRepository;
import ru.rogaandkopyta.model.Order;

public interface OrderRepository extends CrudRepository<Order, Long> {
}
