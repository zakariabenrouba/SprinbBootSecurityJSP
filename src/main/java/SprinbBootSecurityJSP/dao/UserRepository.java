package SprinbBootSecurityJSP.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import SprinbBootSecurityJSP.entities.User;


public interface UserRepository extends JpaRepository<User,Long>{
	@Query("from User where username like :username")
	public User findByUsername(@Param("username")String username);
}
