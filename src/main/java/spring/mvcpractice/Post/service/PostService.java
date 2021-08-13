package spring.mvcpractice.Post.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import spring.mvcpractice.Post.domain.Post;
import spring.mvcpractice.Post.dto.PostUpdateRequestDto;
import spring.mvcpractice.Post.repository.PostRepository;

import java.util.List;

@Slf4j
@RequiredArgsConstructor
@Service
public class PostService implements PostServicInterface {

    private final PostRepository postRepository;

    @Transactional(readOnly = true)
    public List<Post> findAll() {
        return postRepository.findAll();
    }

    @Transactional
    public Post save(Post post) {
        return postRepository.save(post);
    }


    @Transactional
    public Post findById(Long id) {
        return postRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("no such data"));
    }

    @Override
    @Transactional(readOnly = true)
    public List<Post> findByUserName(Post post) {
        return postRepository.findByUserName(post);
    }

    @Override
    @Transactional
    public void deleteById(Long id) {
        postRepository.deleteById(id);
    }

    @Transactional
    public Long update(Long id, PostUpdateRequestDto postUpdateRequestDto) {
        Post post = postRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("해당 게시글이 없습니다. id = " + id));
        post.update(postUpdateRequestDto.getContent());
        return id;
    }
}
