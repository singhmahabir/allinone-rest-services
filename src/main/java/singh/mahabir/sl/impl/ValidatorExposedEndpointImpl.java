/**
 * Copyright 2019 Mahabir Singh. All rights reserved.
 */

package singh.mahabir.sl.impl;

import javax.validation.constraints.NotEmpty;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import lombok.extern.slf4j.Slf4j;
import singh.mahabir.sl.IValidatorExposedEndpoint;
import singh.mahabir.sl.model.ValidatorRequest;

/**
 * @author Mahabir Singh
 *
 */

@RestController

/*
 * @Validated is required to activate the validation in controller class
 * Spatially for @PathVariable and @RequestParam and use @Valid when @Validated
 * is not available
 */
@Validated
@Slf4j
public class ValidatorExposedEndpointImpl implements IValidatorExposedEndpoint {

	// ***************************************************************************************************************
	// ******************************************** Public Fields
	// ****************************************************
	// ***************************************************************************************************************

	// ***************************************************************************************************************
	// ****************************************** Non Public Fields
	// **************************************************
	// ***************************************************************************************************************

	// ***************************************************************************************************************
	// *********************************************** Constructors
	// **************************************************
	// ***************************************************************************************************************

	// ***************************************************************************************************************
	// ******************************************** Public Methods
	// ***************************************************
	// ***************************************************************************************************************

	@Override
	public ResponseEntity<String> validatedRequestParam(@NotEmpty String name, String name1) {
		return new ResponseEntity<>("Hello " + name + name1, HttpStatus.OK);
	}

	@Override
	public ResponseEntity<ValidatorRequest> validatePojo(@RequestBody ValidatorRequest request) {
		log.info("MyEndpointRequest request validated {} ", request);
		return new ResponseEntity<>(request, HttpStatus.OK);
	}

	@Override
	public ResponseEntity<Boolean> validateEmail(@RequestParam String email) {
		log.info("valid email {}", email);
		return new ResponseEntity<>(true, HttpStatus.OK);
	}

	// ***************************************************************************************************************
	// ****************************************** Non Public Methods
	// *************************************************
	// ***************************************************************************************************************
}
