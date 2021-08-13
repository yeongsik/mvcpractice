package spring.mvcpractice.Post.service;

import spring.mvcpractice.Post.domain.Post;

import java.util.List;

public interface PostServicInterface  {

    List<Post> findAll();

    Post findById(Long id);

    List<Post> findByUserName(Post post);

    Post save(Post post);

    void deleteById(Long id);

}
