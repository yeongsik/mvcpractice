package spring.mvcpractice.Post.domain;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Getter
@NoArgsConstructor
@Entity
public class Post {

    @Id
    @GeneratedValue
    @Column(name = "post_id")
    private Long id;

    @Column(length = 1000 , nullable = false)
    private String content;

    private String author;

    private Long password;

    @Builder
    public Post(String content, String author, Long password) {
        this.content = content;
        this.author = author;
        this.password = password;
    }
}
