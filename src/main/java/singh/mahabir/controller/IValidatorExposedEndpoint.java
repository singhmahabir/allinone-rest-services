/**
 * Copyright 2019 Mahabir Singh. All rights reserved.
 */

package singh.mahabir.controller;

import javax.validation.constraints.NotEmpty;

import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

import singh.mahabir.controller.model.ValidatorRequest;

/**
 * Validator exposed end-points
 *
 * @author Mahabir Singh
 *
 */
public interface IValidatorExposedEndpoint {

	// ****************************************************************************************************************
	// ******************************************** Public Methods
	// ****************************************************
	// ****************************************************************************************************************

	@GetMapping(value = "validate", produces = MediaType.TEXT_PLAIN_VALUE)
	ResponseEntity<String> validatedRequestParam(@NotEmpty String name, String name1);

	@PostMapping(value = "/validate/pojo", produces = { MediaType.APPLICATION_JSON_VALUE,
			MediaType.APPLICATION_XML_VALUE }, consumes = { MediaType.APPLICATION_JSON_VALUE,
					MediaType.APPLICATION_XML_VALUE })
	ResponseEntity<ValidatorRequest> validatePojo(@RequestBody ValidatorRequest request);

	@GetMapping(value = "email", produces = MediaType.TEXT_PLAIN_VALUE)
	ResponseEntity<Boolean> validateEmail(@RequestParam String email);

	// ****************************************************************************************************************
	// ****************************************** Non Public Methods
	// **************************************************
	// ****************************************************************************************************************

}
