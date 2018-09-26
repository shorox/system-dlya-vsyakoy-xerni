package ru.rogaandkopyta.repository;

import org.springframework.data.repository.CrudRepository;
import ru.rogaandkopyta.model.Employee;

public interface EmployeeRepository extends CrudRepository<Employee, Long> {
}
