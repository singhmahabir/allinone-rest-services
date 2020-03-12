/**
 * Copyright 2019 Mahabir Singh. All rights reserved.
 */

package singh.mahabir.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import singh.mahabir.repository.entity.URLshortener;

/**
 * @author Mahabir Singh
 *
 */
public interface URLshortenerRepository extends JpaRepository<URLshortener, Integer> {

}
