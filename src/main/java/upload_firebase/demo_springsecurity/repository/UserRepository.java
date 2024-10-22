package upload_firebase.demo_springsecurity.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import upload_firebase.demo_springsecurity.model.entity.Users;

@Repository
public interface UserRepository extends JpaRepository<Users, Integer> {
    Users findUsersByUsername(String username);
}
