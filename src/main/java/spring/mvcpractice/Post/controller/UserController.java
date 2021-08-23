package spring.mvcpractice.Post.controller;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import spring.mvcpractice.Post.domain.User;
import spring.mvcpractice.Post.dto.UserJoinRequestDto;
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
        log.info("logIn");
        log.info(logInDto.getEmailId());
        log.info(String.valueOf(logInDto.getPassword()));
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

    @GetMapping("/join")
    public String joinForm() {
        return "user/userJoin";
    }
    @PostMapping("/join")
    public String saveUser(@ModelAttribute UserJoinRequestDto join) throws Exception {
        User user = join.toEntity();
        userService.save(user);
        return "redirect:/user";
    }
}
