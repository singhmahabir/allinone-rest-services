/**
 * Copyright 2019 Mahabir Singh. All rights reserved.
 */

package singh.mahabir.service;

import java.util.List;

import singh.mahabir.controller.model.EmployeeRequest;
import singh.mahabir.controller.model.ValidatorRequest;
import singh.mahabir.repository.entity.PersonEntity;

/**
 * Data Base Service layer contract
 *
 * @author Mahabir Singh
 *
 */
public interface IDataBaseServices {
	// ****************************************************************************************************************
	// ******************************************** Public Fields
	// *****************************************************
	// ****************************************************************************************************************

	// ****************************************************************************************************************
	// ****************************************** Non Public Fields
	// ***************************************************
	// ****************************************************************************************************************

	// ****************************************************************************************************************
	// ******************************************** Public Methods
	// ****************************************************
	// ****************************************************************************************************************

	String getMyName(String name);

	String getMyName2(String name);

	List<PersonEntity> getEmployee(String name);

	EmployeeRequest saveEmployee(EmployeeRequest id);

	ValidatorRequest changeRequest(ValidatorRequest request);

	EmployeeRequest getEmployeeById(Integer id);

	EmployeeRequest updateEmployee(EmployeeRequest employee);

	// ****************************************************************************************************************
	// ****************************************** Non Public Methods
	// **************************************************
	// ****************************************************************************************************************
}
