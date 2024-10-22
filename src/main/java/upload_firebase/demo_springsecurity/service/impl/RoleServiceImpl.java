package upload_firebase.demo_springsecurity.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import upload_firebase.demo_springsecurity.model.entity.Role;
import upload_firebase.demo_springsecurity.repository.RoleRepository;
import upload_firebase.demo_springsecurity.service.RoleService;

@Service
public class RoleServiceImpl implements RoleService {
    @Autowired
    private RoleRepository roleRepository;

    @Override
    public Role findRoleByRoleName(String roleName) {
        return roleRepository.findRoleByRoleName(roleName);
    }
}
