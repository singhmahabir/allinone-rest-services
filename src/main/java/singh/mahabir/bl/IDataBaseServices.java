/**
 * Copyright 2019 Mahabir Singh. All rights reserved.
 */

package singh.mahabir.bl;

import java.util.List;

import singh.mahabir.dl.Employee;
import singh.mahabir.sl.model.EmployeeRequest;
import singh.mahabir.sl.model.ValidatorRequest;

/**
 * Data Base Service layer contract
 *
 * @author Mahabir Singh
 *
 */
public interface IDataBaseServices {
    // ****************************************************************************************************************
    // ******************************************** Public Fields *****************************************************
    // ****************************************************************************************************************

    // ****************************************************************************************************************
    // ****************************************** Non Public Fields ***************************************************
    // ****************************************************************************************************************

    // ****************************************************************************************************************
    // ******************************************** Public Methods ****************************************************
    // ****************************************************************************************************************

    String getMyName(String name);

    String getMyName2(String name);

    List<Employee> getEmployee(String name);

    EmployeeRequest saveEmployee(EmployeeRequest id);

    ValidatorRequest changeRequest(ValidatorRequest request);

    EmployeeRequest getEmployeeById(Integer id);

    EmployeeRequest updateEmployee(EmployeeRequest employee);

    // ****************************************************************************************************************
    // ****************************************** Non Public Methods **************************************************
    // ****************************************************************************************************************
}
