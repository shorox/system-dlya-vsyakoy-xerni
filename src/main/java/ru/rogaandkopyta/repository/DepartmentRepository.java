package ru.rogaandkopyta.repository;

import java.util.List;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import ru.rogaandkopyta.model.Department;

@RepositoryRestResource(collectionResourceRel = "department", path = "department")
public interface DepartmentRepository extends PagingAndSortingRepository<Department, Long> {
}