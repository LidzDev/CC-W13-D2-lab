package com.codeclan.Relationships;

import com.codeclan.Relationships.models.Assignment;
import com.codeclan.Relationships.models.Department;
import com.codeclan.Relationships.models.Employee;
import com.codeclan.Relationships.models.Project;
import com.codeclan.Relationships.repositories.AssignmentRepository;
import com.codeclan.Relationships.repositories.DepartmentRepository;
import com.codeclan.Relationships.repositories.EmployeeRepository;
import com.codeclan.Relationships.repositories.ProjectRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class RelationshipsApplicationTests {

	@Autowired
	EmployeeRepository employeeRepository;

	@Autowired
	DepartmentRepository departmentRepository;

	@Autowired
	ProjectRepository projectRepository;

	@Autowired
	AssignmentRepository assignmentRepository;

	@Test
	void contextLoads() {
	}

	@Test
	public void createDepartmentAndEmployee(){
		Department department = new Department("IT");
		departmentRepository.save(department);
		Employee employee = new Employee("Claire", "Smith", 12345, department);
		employeeRepository.save(employee);
	}
	@Test
	public void createProject(){
		Project project = new Project("365 upgrade", 365);
		projectRepository.save(project);
	}
	@Test
	public void createAssignmentt(){
		Department department = new Department("QA");
		departmentRepository.save(department);
		Employee employee = new Employee("Matt", "Smith", 12346, department);
		employeeRepository.save(employee);
		Project project = new Project("Licensing 365", 45);
		projectRepository.save(project);
		Assignment assignment = new Assignment(employee, project);
		assignmentRepository.save(assignment);
	}
}
