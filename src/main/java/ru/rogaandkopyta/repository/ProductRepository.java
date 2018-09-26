package ru.rogaandkopyta.repository;

import org.springframework.data.repository.CrudRepository;
import ru.rogaandkopyta.model.Product;

public interface ProductRepository extends CrudRepository<Product, Long> {
}
