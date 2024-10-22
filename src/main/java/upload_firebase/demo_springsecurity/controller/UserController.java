package upload_firebase.demo_springsecurity.controller;

import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import upload_firebase.demo_springsecurity.security.CustomUserDetail;

@Controller
@RequestMapping("/user")
public class UserController {
    @GetMapping
    public String homeUser(Model model){
        CustomUserDetail user = (CustomUserDetail) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        model.addAttribute("user",user);
        return "user";
    }
}
