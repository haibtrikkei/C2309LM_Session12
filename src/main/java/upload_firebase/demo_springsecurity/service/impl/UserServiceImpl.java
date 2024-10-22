package upload_firebase.demo_springsecurity.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import upload_firebase.demo_springsecurity.model.entity.Users;
import upload_firebase.demo_springsecurity.repository.UserRepository;
import upload_firebase.demo_springsecurity.service.UserService;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private PasswordEncoder passwordEncoder;

    @Override
    public Users save(Users user) {
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        return userRepository.save(user);
    }

    @Override
    public Users findUsersByUsername(String username) {
        return userRepository.findUsersByUsername(username);
    }
}
