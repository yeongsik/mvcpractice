package spring.mvcpractice.Post.dto;

import lombok.Getter;
import lombok.Setter;
import spring.mvcpractice.Post.domain.User;

@Getter
@Setter
public class UserJoinRequestDto {

    private String emailId;
    private String userName;
    private Long password;

    public User toEntity() {
        return User.builder()
                .emailId(emailId)
                .userName(userName)
                .password(password)
                .build();
    }

}
