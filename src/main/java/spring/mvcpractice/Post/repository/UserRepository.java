package spring.mvcpractice.Post.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import spring.mvcpractice.Post.domain.User;

@Repository
public interface UserRepository extends JpaRepository<User , Long> {

    @Query("select u from User u where u.emailId= :#{#user.emailId} and u.password= :#{#user.password}")
    User logIn (@Param("user") User user);
}
