/**
 * Copyright 2019 Mahabir Singh. All rights reserved.
 */

package singh.mahabir.sl.impl;

import java.util.List;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import lombok.extern.slf4j.Slf4j;

/**
 * Data-Base exposed end-points implementation.
 *
 * @author Mahabir Singh
 *
 */
@RestController
@Slf4j
public class ProfilesAndValueEndpoint {

	// ****************************************************************************************************************
	// ******************************************** Public Fields
	// *****************************************************
	// ****************************************************************************************************************

	// ****************************************************************************************************************
	// ****************************************** Non Public Fields
	// ***************************************************
	// ****************************************************************************************************************

	@Value("${defaultvalue:none}")
	private String value;

	@Value("${defaultvalue1:none1}")
	private String value1;

	/* we can only inject “string value” from the annotation to the field: */
	@Value("string value")
	private String stringValue;

	/*
	 * We can also set the value from system properties with the same syntax. Let’s
	 * assume that we have defined a system property named systemValue But for pass
	 * -DsystemValue=value priority given to yml values
	 */
	@Value("${systemValue}")
	private String systemValue;

	/*
	 * If the same property is defined as a system property and in the properties
	 * file, then the system property would be applied. Suppose we had a property
	 * priority defined as a system property with the value “System property” and
	 * defined as something else in the properties file. In the following code the
	 * value would be “System property”:
	 */
	@Value("${priority}")
	private String prioritySystemProperty;

	/*
	 * Sometimes we need to inject a bunch of values. It would be convenient to
	 * define them as comma-separated values for the single property in the
	 * properties file or as a system property and to inject into an array. In the
	 * first section, we defined comma-separated values in the listOfValues of the
	 * properties file, so in the following example the array values would be [“A”,
	 * “B”, “C”]: catch in private String[] valuesArray;
	 */
	@Value("${listOfValues}")
	private List<String> valuesArray;

	/**
	 * If we have a system property named priority, then its value will be applied
	 * to the field
	 */
	@Value("#{systemProperties['priority']}")
	private String spelValue;

	/*
	 * If we have not defined the system property, then the null value will be
	 * assigned. To prevent this, we can provide a default value in the SpEL
	 * expression. In the following example, we get “some default” value for the
	 * field if the system property is not defined:
	 */
	@Value("#{systemProperties['unknown'] ?: 'some default'}")
	public String spelSomeDefault;

	@Value("#{'${listOfValues}'.split(',')}")
	private List<String> valuesList;

	/*
	 * This way you can retrieve first value from the list
	 */
	@Value("#{'${listOfValues}'.split(' ')[0]}")
	private String listFirstValue;

	// ****************************************************************************************************************
	// ******************************************** Public Methods
	// ****************************************************
	// ****************************************************************************************************************

	@PostConstruct
	public void init() {
		log.info(
				"\n@PostConstruct stringValue-{} systemValue-{} prioritySystemProperty-{} valuesArray-{} spelValue-{} spelSomeDefault-{} valuesList-{}"
						+ " listFirstValue-{}",
				stringValue, systemValue, prioritySystemProperty, valuesArray, spelValue, spelSomeDefault, valuesList,
				listFirstValue);
	}

	/**
	 * printing the data from profiles
	 *
	 * @return message
	 */
	@GetMapping(value = "profile", produces = { MediaType.TEXT_HTML_VALUE })
	public ResponseEntity<String> getSend() {
		System.err.println(value);
		System.err.println(value1);
		return new ResponseEntity<>("Hello " + value + " and " + value1, HttpStatus.OK);
	}

	// ****************************************************************************************************************
	// ****************************************** Non Public Methods
	// **************************************************
	// ****************************************************************************************************************
}
