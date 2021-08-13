package spring.mvcpractice.Post.controller;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import spring.mvcpractice.Post.domain.User;
import spring.mvcpractice.Post.dto.UserLogInRequestDto;
import spring.mvcpractice.Post.service.UserService;

import javax.servlet.http.HttpSession;

@Slf4j
@RequiredArgsConstructor
@RequestMapping("/user")
@Controller
public class UserController {

    private  final UserService userService;

    @GetMapping
    public String logInForm() {
        return "user/logInForm";
    }
    @PostMapping
    public String logIn(@ModelAttribute UserLogInRequestDto logInDto , HttpSession session) {
        User user = logInDto.toEntity();
        User loginUser = userService.login(user);
        session.setAttribute("loginUser" , loginUser);
        return "redirect:/";
    }

    @GetMapping("/out")
    public String logOut(HttpSession session) {
        session.invalidate();
        return "redirect:/";
    }
}
