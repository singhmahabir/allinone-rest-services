/**
 * Copyright 2019 Mahabir Singh. All rights reserved.
 */

package singh.mahabir.dl;

import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author Mahabir Singh
 *
 */
public interface URLshortenerRepository extends JpaRepository<URLshortener, Integer> {

}
