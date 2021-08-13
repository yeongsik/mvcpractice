package spring.mvcpractice;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import spring.mvcpractice.Post.domain.Post;
import spring.mvcpractice.Post.service.PostService;

import java.util.List;

@Controller
@RequiredArgsConstructor
public class IndexController {

    private final PostService postService;

    @RequestMapping("/")
    public String main(Model model) {
        List<Post> posts = postService.findAll();
        model.addAttribute("posts", posts);

        return "index";
    }
}
