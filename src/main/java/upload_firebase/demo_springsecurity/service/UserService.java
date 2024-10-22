package upload_firebase.demo_springsecurity.service;

import upload_firebase.demo_springsecurity.model.entity.Users;

public interface UserService {
    Users save(Users user);
    Users findUsersByUsername(String username);
}
