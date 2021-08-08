package spring.mvcpractice.Post.controller;


import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import spring.mvcpractice.Post.domain.Post;
import spring.mvcpractice.Post.service.PostService;

import java.util.List;

@RequiredArgsConstructor
@Controller
public class PostController {

    private final PostService postService;


    @GetMapping("/post")
    public String beforeMain(Model model) {
        List<Post> posts = postService.findAll();
        model.addAttribute("posts", posts);
        return "post";
    }


}
