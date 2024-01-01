package in.becoder.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import in.becoder.entities.Employee;

public interface EmployeeRepository extends JpaRepository<Employee, Integer> {

}
