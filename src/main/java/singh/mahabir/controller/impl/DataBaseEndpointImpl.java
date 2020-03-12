/**
 * Copyright 2019 Mahabir Singh. All rights reserved.
 */

package singh.mahabir.controller.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import lombok.extern.slf4j.Slf4j;
import singh.mahabir.controller.IDataBaseEndpoint;
import singh.mahabir.controller.model.EmployeeRequest;
import singh.mahabir.exception.MyException;
import singh.mahabir.service.IDataBaseServices;

/**
 * Data-Base exposed end-points implementation.
 *
 * @author Mahabir Singh
 *
 */
@RestController

/* @Validated is required to activate the validation in controller class */
@Validated
@Slf4j
public class DataBaseEndpointImpl implements IDataBaseEndpoint {

	// ****************************************************************************************************************
	// ******************************************** Public Fields
	// *****************************************************
	// ****************************************************************************************************************

	// ****************************************************************************************************************
	// ****************************************** Non Public Fields
	// ***************************************************
	// ****************************************************************************************************************

	@Autowired
	private IDataBaseServices service;

	// ****************************************************************************************************************
	// ******************************************** Public Methods
	// ****************************************************
	// ****************************************************************************************************************

	@Override
	public ResponseEntity<List<EmployeeRequest>> getEmployeeByName(@RequestParam String name) throws MyException {
		log.info("Retrieve the Employee for name {}", name);
		final List<EmployeeRequest> result = new ArrayList<>();
		try {
			service.getEmployee(name).forEach(employee -> {
				final EmployeeRequest empReq = new EmployeeRequest();
				empReq.setAddress(employee.getAddress());
				empReq.setCity(employee.getCity());
				empReq.setId(employee.getId());
				empReq.setName(employee.getName());
				empReq.setTs(employee.getTs());
				result.add(empReq);
			});

		} catch (final Exception e) {
			log.error(e.getMessage());
			throw new MyException(e);
		}
		return new ResponseEntity<>(result, HttpStatus.OK);
	}

	@Override
	public ResponseEntity<EmployeeRequest> getEmployeeById(@PathVariable Integer id) throws MyException {
		return new ResponseEntity<>(service.getEmployeeById(id), HttpStatus.OK);
	}

	@Override
	public ResponseEntity<EmployeeRequest> saveEmployee(@RequestBody EmployeeRequest employee) throws MyException {
		log.info(employee.toString());
		try {
			return new ResponseEntity<>(service.saveEmployee(employee), HttpStatus.OK);
		} catch (final Exception e) {
			log.error(e.getMessage());
			throw new MyException(e);
		}
	}

	@Override
	public ResponseEntity<EmployeeRequest> updateEmployee(@RequestBody EmployeeRequest employee) throws MyException {
		log.info(employee.toString());
		try {
			return new ResponseEntity<>(service.updateEmployee(employee), HttpStatus.OK);
		} catch (final Exception e) {
			log.error(e.getMessage());
			throw new MyException(e);
		}
	}

	// ****************************************************************************************************************
	// ****************************************** Non Public Methods
	// **************************************************
	// ****************************************************************************************************************
}
