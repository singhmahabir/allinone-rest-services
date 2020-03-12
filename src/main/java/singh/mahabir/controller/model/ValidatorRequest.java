/**
 * Copyright 2019 Mahabir Singh. All rights reserved.
 */

package singh.mahabir.controller.model;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * @author Mahabir Singh
 *
 */
@XmlRootElement
public class ValidatorRequest {
	// ****************************************************************************************************************
	// ******************************************** Public Fields
	// *****************************************************
	// ****************************************************************************************************************

	// ****************************************************************************************************************
	// ****************************************** Non Public Fields
	// ***************************************************
	// ****************************************************************************************************************
	@NotEmpty
	@NotBlank
	private String name;

	@NotEmpty
	private String address;

	@NotEmpty
	private String city;

	@NotNull(message = "The value of ts must not be empty")
	@Min(value = 1, message = "The value of ts must be grater than 0")
	private Integer ts;

	// ****************************************************************************************************************
	// ******************************************** Public Methods
	// ****************************************************
	// ****************************************************************************************************************

	/**
	 * @return the ts
	 */
	public Integer getTs() {
		return ts;
	}

	/**
	 * @param ts the ts to set
	 */
	public void setTs(Integer ts) {
		this.ts = ts;
	}

	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	/**
	 * @return the address
	 */
	public String getAddress() {
		return address;
	}

	/**
	 * @return the city
	 */
	public String getCity() {
		return city;
	}

	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * @param address the address to set
	 */
	public void setAddress(String address) {
		this.address = address;
	}

	/**
	 * @param city the city to set
	 */
	public void setCity(String city) {
		this.city = city;
	}

	// ****************************************************************************************************************
	// ****************************************** Non Public Methods
	// **************************************************
	// ****************************************************************************************************************
}
