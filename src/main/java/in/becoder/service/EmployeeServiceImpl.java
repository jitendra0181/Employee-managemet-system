package in.becoder.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import in.becoder.entities.Employee;
import in.becoder.repositories.EmployeeRepository;
import jakarta.servlet.http.HttpSession;

@Service
public class EmployeeServiceImpl implements EmployeeService {

	@Autowired
	public EmployeeRepository employeeRepository;

	@Override
	public Employee saveEmp(Employee employee) {
		Employee newEmp = employeeRepository.save(employee);
		return newEmp;
	}

	@Override
	public List<Employee> getAllEmp() {
		return employeeRepository.findAll();
	}

	@Override
	public Employee getEmpById(Integer id) {
		Optional<Employee> findById = employeeRepository.findById(id);
		if (findById.isPresent()) {
			findById.get();
		}
		return null;
	}

	@Override
	public boolean deleteById(Integer id) {
		Employee employee = employeeRepository.findById(id).get();
		if (employee != null) {
			employeeRepository.delete(employee);
			return true;
		}
		return false;
	}

	public void removeSessionMessage() {
		HttpSession session = ((ServletRequestAttributes) (RequestContextHolder.getRequestAttributes())).getRequest()
				.getSession();
		session.removeAttribute("msg");
	}
}
