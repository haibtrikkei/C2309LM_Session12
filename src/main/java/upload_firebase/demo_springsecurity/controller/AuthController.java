package upload_firebase.demo_springsecurity.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import upload_firebase.demo_springsecurity.model.dto.request.UserLogin;
import upload_firebase.demo_springsecurity.model.entity.Role;
import upload_firebase.demo_springsecurity.model.entity.Users;
import upload_firebase.demo_springsecurity.repository.RoleRepository;
import upload_firebase.demo_springsecurity.security.CustomUserDetail;
import upload_firebase.demo_springsecurity.service.RoleService;
import upload_firebase.demo_springsecurity.service.UserService;

import java.util.HashSet;
import java.util.Set;

@Controller
public class AuthController {
    @Autowired
    private UserService userService;
    @Autowired
    private RoleService roleService;
    @Autowired
    private RoleRepository roleRepository;

    @GetMapping("/auth/addUser")
    public String addUser(Model model){
        Users user = new Users();
        model.addAttribute("user",user);
        return "addUser";
    }

    @GetMapping("/auth/addAdmin")
    public String addAdmin(Model model){
        Users user = new Users();
        model.addAttribute("user",user);
        return "addAdmin";
    }

    @PostMapping("/auth/registerUser")
    public String registerUser(@ModelAttribute Users user, Model model){
        Set<Role> roles = new HashSet<>();
        Role roleUser = roleRepository.findRoleByRoleName("ROLE_USER");
        roles.add(roleUser);
        user.setRoles(roles);
        user.setEnable(true);

        userService.save(user);

        return "redirect:/login";
    }

    @PostMapping("/auth/registerAdmin")
    public String registerAdmin(@ModelAttribute Users user, Model model){
        Set<Role> roles = new HashSet<>();
        Role roleUser = roleRepository.findRoleByRoleName("ROLE_USER");
        roles.add(roleUser);
        Role roleAdmin = roleRepository.findRoleByRoleName("ROLE_ADMIN");
        roles.add(roleAdmin);
        user.setRoles(roles);
        user.setEnable(true);

        userService.save(user);

        return "redirect:/login";
    }

    @GetMapping("/login")
    public String login(Model model){
        return "login";
    }

}
