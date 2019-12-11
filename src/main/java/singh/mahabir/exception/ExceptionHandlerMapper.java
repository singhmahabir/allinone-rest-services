/**
 * Copyright 2019 Mahabir Singh. All rights reserved.
 */

package singh.mahabir.exception;

import org.springframework.beans.propertyeditors.StringTrimmerEditor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import lombok.extern.slf4j.Slf4j;
import singh.mahabir.exception.model.ApiError;

/**
 * This is the class where we can handle any exception thrown by our application
 * and we can re-send the appropriate response to consumer.
 *
 * @author Mahabir Singh
 *
 */
@ControllerAdvice
@Slf4j
public class ExceptionHandlerMapper {// extends ResponseEntityExceptionHandler {
	// ****************************************************************************************************************
	// ******************************************** Public Fields
	// *****************************************************
	// ****************************************************************************************************************

	// ****************************************************************************************************************
	// ****************************************** Non Public Fields
	// ***************************************************
	// ****************************************************************************************************************

	@ExceptionHandler(MyException.class)
//	@ResponseStatus(HttpStatus.OK)
	public ResponseEntity<ApiError> exceptionToDoHandler(Exception ex) {
		final ApiError error = new ApiError(HttpStatus.BAD_REQUEST, ex.getMessage(), ex.toString());
		return new ResponseEntity<>(error, HttpStatus.OK);
	}

	@ExceptionHandler(Exception.class)
	public ResponseEntity<ApiError> exceptionHandler(Exception ex) {
		final ApiError error = new ApiError(HttpStatus.BAD_REQUEST, ex.getMessage(), ex.toString());
		return new ResponseEntity<>(error, HttpStatus.INTERNAL_SERVER_ERROR);
	}

	/**
	 * Another way to send the response
	 *
	 * @ResponseBody is mandatory to use
	 *
	 * @param ex exception generated inside code
	 * @return Default response
	 */
	@ExceptionHandler(javax.validation.ConstraintViolationException.class)
	@ResponseStatus(HttpStatus.OK)
	@ResponseBody
	public ApiError constraintViolationException(Exception ex) {
		log.error(" Pojo not validated {}", ex.getMessage());
		return new ApiError(HttpStatus.BAD_REQUEST, ex.getMessage(), ex.toString());
	}

	@InitBinder
	public void initBinder(WebDataBinder dataBinder) {
		final StringTrimmerEditor stringtrimmer = new StringTrimmerEditor(true);
		dataBinder.registerCustomEditor(String.class, stringtrimmer);

		// dataBinder.registerCustomEditor( String.class, new PropertyEditorSupport() {
		// @Override
		// public void setAsText(String text) {
		// if ( text == null ) {
		// return;
		// }
		// setValue( text );
		// }
		//
		// @Override
		// public String getAsText() {
		// final Object value = getValue();
		// return value != null ? value.trim().toString() : "";
		// }
		// } );
	}

	// ****************************************************************************************************************
	// ******************************************** Public Methods
	// ****************************************************
	// ****************************************************************************************************************

	// ****************************************************************************************************************
	// ****************************************** Non Public Methods
	// **************************************************
	// ****************************************************************************************************************
}
