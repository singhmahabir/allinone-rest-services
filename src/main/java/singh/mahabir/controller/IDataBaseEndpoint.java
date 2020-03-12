/**
 * Copyright 2019 Mahabir Singh. All rights reserved.
 */

package singh.mahabir.controller;

import java.util.List;

import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

import singh.mahabir.controller.model.EmployeeRequest;
import singh.mahabir.exception.MyException;

/**
 * Data-Base exposed end-points
 *
 * @author Mahabir Singh
 *
 */
public interface IDataBaseEndpoint {

	// ****************************************************************************************************************
	// ******************************************** Public Methods
	// ****************************************************
	// ****************************************************************************************************************

	@GetMapping(value = "employee", produces = { MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE })
	ResponseEntity<List<EmployeeRequest>> getEmployeeByName(@RequestParam String name) throws MyException;

	@GetMapping(value = "employee/{id}", produces = { MediaType.APPLICATION_JSON_VALUE,
			MediaType.APPLICATION_XML_VALUE })
	ResponseEntity<EmployeeRequest> getEmployeeById(@PathVariable Integer id) throws MyException;

	@PostMapping(value = "employee", produces = { MediaType.APPLICATION_JSON_VALUE,
			MediaType.APPLICATION_XML_VALUE }, consumes = { MediaType.APPLICATION_JSON_VALUE,
					MediaType.APPLICATION_XML_VALUE })
	ResponseEntity<EmployeeRequest> saveEmployee(@RequestBody EmployeeRequest employee) throws MyException;

	@PutMapping(value = "employee", produces = { MediaType.APPLICATION_JSON_VALUE,
			MediaType.APPLICATION_XML_VALUE }, consumes = { MediaType.APPLICATION_JSON_VALUE,
					MediaType.APPLICATION_XML_VALUE })
	ResponseEntity<EmployeeRequest> updateEmployee(@RequestBody EmployeeRequest employee) throws MyException;

	// ****************************************************************************************************************
	// ****************************************** Non Public Methods
	// **************************************************
	// ****************************************************************************************************************

}
