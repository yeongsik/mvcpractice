package spring.mvcpractice.Post.dto;

import lombok.Getter;
import lombok.Setter;
import spring.mvcpractice.Post.domain.User;

@Getter
@Setter
public class UserLogInRequestDto {

    String emailId;
    Long password;

    public User toEntity() {
        return User.builder()
                .emailId(emailId)
                .password(password)
                .build();
    }

}
