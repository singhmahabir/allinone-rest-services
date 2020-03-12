/**
 *
 */
package singh.mahabir.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import singh.mahabir.repository.entity.AlbumEntity;

/**
 * @author Mahabir Singh
 *
 */
public interface AlbumRepository extends JpaRepository<AlbumEntity, String> {

}
