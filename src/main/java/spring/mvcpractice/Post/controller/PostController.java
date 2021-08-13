package spring.mvcpractice.Post.controller;


import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import spring.mvcpractice.Post.domain.Post;
import spring.mvcpractice.Post.dto.PostSaveRequestDto;
import spring.mvcpractice.Post.service.PostServicInterface;
@Slf4j
@RequestMapping("/post")
@RequiredArgsConstructor
@Controller
public class PostController {

    private final PostServicInterface ps;

    @PostMapping("/add")
    public String add(@ModelAttribute PostSaveRequestDto post) {
        Post postEntity = post.toEntity();
        ps.save(postEntity);
        return "redirect:/";
    }

    @GetMapping("/{postId}")
    public String post(@PathVariable long postId, Model model) {
        Post post = ps.findById(postId);
        model.addAttribute("post", post);
        return "post/detail";
    }


}
