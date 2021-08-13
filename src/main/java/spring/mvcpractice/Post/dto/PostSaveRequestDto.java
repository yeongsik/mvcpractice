package spring.mvcpractice.Post.dto;

import lombok.*;
import spring.mvcpractice.Post.domain.Post;

@Builder
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class PostSaveRequestDto {

    private String content;
    private String userName;


    public Post toEntity() {
        return Post.builder()
                .content(content)
                .userName(userName)
                .build();
    }
}
