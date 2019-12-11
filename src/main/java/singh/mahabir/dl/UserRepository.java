/**
 * Copyright 2019. All rights reserved.
 */

package singh.mahabir.dl;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

/**
 * UserRepository represents the database layer of {@link User} User
 * 
 * @author Mahabir Singh
 *
 */
public interface UserRepository extends JpaRepository<User, Long> {

	/**
	 * It will retrieve the List of User by userId
	 * 
	 * @param bookId bookId
	 * @return BookEntity
	 */
	List<User> findByUserId(String userId);
}
