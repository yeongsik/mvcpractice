package spring.mvcpractice.Post.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import spring.mvcpractice.Post.domain.Post;

import java.util.List;

@Repository
public interface PostRepository extends JpaRepository<Post,Long> {

   @Query("select p from Post p where p.userName = :#{#postUserName.userName}")
   List<Post> findByUserName(@Param("postUserName") Post post);
}
