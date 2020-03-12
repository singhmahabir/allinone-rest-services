/**
 * Copyright 2019. All rights reserved.
 */

package singh.mahabir.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import singh.mahabir.repository.entity.User;

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
