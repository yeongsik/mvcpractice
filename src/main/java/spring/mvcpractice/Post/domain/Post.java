package spring.mvcpractice.Post.domain;

import lombok.*;
import spring.mvcpractice.Post.BaseTimeEntity;

import javax.persistence.*;

@Getter
@ToString
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Post extends BaseTimeEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "post_id")
    private Long id;

    private String content;

    private String userName;

    public void update(String content) {
        this.content = content;
    }

    @Builder
    public Post(String content, String userName) {
        this.content=content;
        this.userName = userName;
    }
}
