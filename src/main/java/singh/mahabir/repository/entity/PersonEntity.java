/**
 * Copyright 2019 Mahabir Singh. All rights reserved.
 */

package singh.mahabir.repository.entity;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

/**
 * @author Mahabir Singh
 *
 */
@Entity
@Table(name = "person", schema = "test")
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
@ToString
public class PersonEntity implements Serializable {

    // ****************************************************************************************************************
    // ******************************************** Public Fields
    // *****************************************************
    // ****************************************************************************************************************

    // ****************************************************************************************************************
    // ****************************************** Non Public Fields
    // ***************************************************
    // ****************************************************************************************************************

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    @Size(min = 3, max = 20)
    private String name;

    @Size(min = 3, max = 20)
    private String address;

    @Size(min = 3, max = 20)
    private String city;

    private Integer ts;

    // ****************************************************************************************************************
    // ******************************************** Public Methods
    // ****************************************************
    // ****************************************************************************************************************

    // ****************************************************************************************************************
    // ****************************************** Non Public Methods
    // **************************************************
    // ****************************************************************************************************************
}
