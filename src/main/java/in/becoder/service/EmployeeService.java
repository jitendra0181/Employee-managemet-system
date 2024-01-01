package in.becoder.service;

import java.util.List;

import in.becoder.entities.Employee;

public interface EmployeeService {

	public Employee saveEmp(Employee employee);

	public List<Employee> getAllEmp();

	public Employee getEmpById(Integer id);

	public boolean deleteById(Integer id);
}
