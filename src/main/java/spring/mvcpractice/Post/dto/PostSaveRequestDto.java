package spring.mvcpractice.Post.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import spring.mvcpractice.Post.domain.Post;

@Getter
@NoArgsConstructor
public class PostSaveRequestDto {

    private String content;
    private String author;
    private Long password;

    @Builder
    public PostSaveRequestDto(String content , String author , Long password) {
        this.content = content;
        this.author = author;
        this.password = password;
    }

    public Post toEntity() {
        return Post.builder()
                .content(content)
                .author(author)
                .password(password)
                .build();
    }
}
