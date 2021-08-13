package spring.mvcpractice;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import spring.mvcpractice.Post.domain.Post;
import spring.mvcpractice.Post.dto.PostSaveRequestDto;
import spring.mvcpractice.Post.repository.PostRepository;
import spring.mvcpractice.Post.service.PostService;

import java.time.LocalDateTime;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
public class PostListTest {

    @Autowired
    private PostService ps;

    @Autowired
    private PostRepository pr;

    @AfterEach
    public void after() {

    }

    @Test
    public void Post_리스트_받기() {

        List<Post> posts = ps.findAll();

    }

    @Test
    public void save() {
        PostSaveRequestDto dto = PostSaveRequestDto.builder()
                .content("테스트")
                .userName("테스트네임")
                .build();
        Post post = dto.toEntity();
        Post savedPost = ps.save(post);
        assertThat(post.getUserName()).isEqualTo(savedPost.getUserName());

    }

    @Test
    public void BaseTimeEntity_등록() {
        //given
        LocalDateTime now = LocalDateTime.now();
        Post savedPost = ps.save(Post.builder()
                .content("하하호호")
                .userName("테스트")
                .build());

        assertThat(savedPost.getCreatedDate()).isAfter(now);
    }
}
