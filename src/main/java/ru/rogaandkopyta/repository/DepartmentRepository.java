package ru.rogaandkopyta.repository;

import org.springframework.data.repository.CrudRepository;
import ru.rogaandkopyta.model.Department;

public interface DepartmentRepository extends CrudRepository<Department, Long> {
}