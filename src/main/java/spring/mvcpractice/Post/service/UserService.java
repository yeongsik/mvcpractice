package spring.mvcpractice.Post.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import spring.mvcpractice.Post.domain.User;
import spring.mvcpractice.Post.repository.UserRepository;

import java.util.List;

@Slf4j
@RequiredArgsConstructor
@Service
public class UserService implements UserServiceInterface{

    private final UserRepository userRepository;

    @Override
    @Transactional(readOnly = true)
    public List<User> findAll() {
        return userRepository.findAll();
    }

    @Override
    @Transactional
    public User save(User user) {
        return userRepository.save(user);
    }

    @Override
    @Transactional(readOnly = true)
    public User findById(Long id) {

        return userRepository.findById(id)
                .orElseThrow(()->new IllegalArgumentException("no such data"));
    }

    @Override
    @Transactional(readOnly = true)
    public User login(User user) {
        return userRepository.logIn(user);
    }

    @Override
    public void userDelete(Long id) {
        userRepository.deleteById(id);
    }
}
