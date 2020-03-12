/**
 * Copyright 2019 Mahabir Singh. All rights reserved.
 */

package singh.mahabir.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import singh.mahabir.controller.model.EmployeeRequest;
import singh.mahabir.controller.model.ValidatorRequest;
import singh.mahabir.repository.PersonRepository;
import singh.mahabir.repository.entity.PersonEntity;

/**
 * Data Base Service layer contract implementation
 *
 * @author Mahabir Singh
 *
 */
@Component
public class DataBaseServicesImpl implements IDataBaseServices {

	// ****************************************************************************************************************
	// ******************************************** Public Fields
	// *****************************************************
	// ****************************************************************************************************************

	// ****************************************************************************************************************
	// ****************************************** Non Public Fields
	// ***************************************************
	// ****************************************************************************************************************

	@Autowired
	private PersonRepository employeeRepository;

	// ****************************************************************************************************************
	// ******************************************** Public Methods
	// ****************************************************
	// ****************************************************************************************************************

	@Override
	public String getMyName(String name) {
		return name + " hello";
	}

	@Override
	public String getMyName2(String name) {
		return " Hello " + name;
	}

	@Override
	public ValidatorRequest changeRequest(ValidatorRequest request) {
		request.setAddress(request.getAddress() + " changed");
		request.setCity(request.getCity() + " changed");
		request.setName(request.getName() + " changed");
		request.setTs(request.getTs() + 555);
		return request;
	}

	@Override
	public List<PersonEntity> getEmployee(String name) {
		return employeeRepository.findByName(name);
	}

	@Override
	public EmployeeRequest saveEmployee(EmployeeRequest employee) {
		final PersonEntity emp = createEmployee(employee);
		emp.setId((employeeRepository.getMaxId() == null ? 0 : employeeRepository.getMaxId()) + 1);
		employee.setId(emp.getId());
		employeeRepository.save(emp);
		return employee;
	}

	@Override
	public EmployeeRequest updateEmployee(EmployeeRequest employeeRequest) {
		final PersonEntity emp = createEmployee(employeeRequest);
		emp.setId(employeeRequest.getId());
		employeeRepository.save(emp);
		return employeeRequest;
	}

	@Override
	public EmployeeRequest getEmployeeById(Integer id) {
		final PersonEntity employee = employeeRepository.findById(id);
		final EmployeeRequest employeeRequest = new EmployeeRequest();
		employeeRequest.setAddress(employee.getAddress());
		employeeRequest.setCity(employee.getCity());
		employeeRequest.setId(employee.getId());
		employeeRequest.setName(employee.getName());
		employeeRequest.setTs(employee.getTs());
		return employeeRequest;
	}

	// ****************************************************************************************************************
	// ****************************************** Non Public Methods
	// **************************************************
	// ****************************************************************************************************************

	private PersonEntity createEmployee(EmployeeRequest employee) {
		final PersonEntity emp = new PersonEntity();
		emp.setAddress(employee.getAddress());
		emp.setCity(employee.getCity());
		emp.setName(employee.getName());
		emp.setTs(employee.getTs());
		return emp;
	}

}
