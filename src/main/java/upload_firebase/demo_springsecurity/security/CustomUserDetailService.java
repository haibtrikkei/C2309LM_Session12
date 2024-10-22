package upload_firebase.demo_springsecurity.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import upload_firebase.demo_springsecurity.model.entity.Role;
import upload_firebase.demo_springsecurity.model.entity.Users;
import upload_firebase.demo_springsecurity.service.UserService;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Service
public class CustomUserDetailService implements UserDetailsService {
    @Autowired
    private UserService userService;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Users user = userService.findUsersByUsername(username);
        if(user==null)
            throw new UsernameNotFoundException("Username không đúng!");


        return CustomUserDetail.builder()
                .username(user.getUsername())
                .password(user.getPassword())
                .fullName(user.getFullName())
                .gender(user.getGender())
                .birthday(user.getBirthday())
                .email(user.getEmail())
                .phone(user.getPhone())
                .enabled(user.getEnable())
                .authorities(mapToGrandAuthories(user.getRoles()))
                .build();
    }

    private List<GrantedAuthority> mapToGrandAuthories(Set<Role> roles) {
        return roles.stream().map(role -> new SimpleGrantedAuthority(role.getRoleName())).collect(Collectors.toList());
    }
}
