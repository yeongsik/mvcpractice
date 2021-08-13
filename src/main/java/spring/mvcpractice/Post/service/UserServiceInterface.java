package spring.mvcpractice.Post.service;

import spring.mvcpractice.Post.domain.User;

import java.util.List;

public interface UserServiceInterface {

    List<User> findAll();

    User save(User user);

    User findById(Long id);

    User login(User user);

    void userDelete(Long id);

}
