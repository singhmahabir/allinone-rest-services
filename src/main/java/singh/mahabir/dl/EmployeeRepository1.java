/**
 * Copyright 2019 Mahabir Singh. All rights reserved.
 */

package singh.mahabir.dl;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

/**
 * @author Mahabir Singh
 *
 */
public interface EmployeeRepository1 extends CrudRepository<Employee1, Long> {
    // ****************************************************************************************************************
    // ******************************************** Public Fields *****************************************************
    // ****************************************************************************************************************

    // ****************************************************************************************************************
    // ****************************************** Non Public Fields ***************************************************
    // ****************************************************************************************************************

    // ****************************************************************************************************************
    // ******************************************** Public Methods ****************************************************
    // ****************************************************************************************************************
    public Employee1 findByName(String name);

    public Employee1 findById(Integer id);

    @Query("select max(u.id) from Employee u")
    Integer getMaxId();

    // ****************************************************************************************************************
    // ****************************************** Non Public Methods **************************************************
    // ****************************************************************************************************************

}
