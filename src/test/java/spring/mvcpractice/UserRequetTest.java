package spring.mvcpractice;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import spring.mvcpractice.Post.domain.User;
import spring.mvcpractice.Post.dto.UserLogInRequestDto;
import spring.mvcpractice.Post.service.UserServiceInterface;


@SpringBootTest

public class UserRequetTest {

    @Autowired
    private UserServiceInterface userServiceInterface;


    @Test
    public void user_회원가입() throws Exception {
        User user = User.builder()
                .emailId("이메일@네이버2")
                .password(1234L)
                .userName("테스트네임")
                .build();
        System.out.println(user.getUserName());
        User save = userServiceInterface.save(user);
        Assertions.assertThat(save.getUserName()).isEqualTo(user.getUserName());

    }

    @Test
    public void user_로그인() {
        UserLogInRequestDto log = new UserLogInRequestDto();
        log.setEmailId("이메일@네이버2");
        log.setPassword(1234L);
        User loginUser = log.toEntity();
        User login = userServiceInterface.login(loginUser);
        System.out.println("login = " + login.getCreatedDate());

    }
}
