package upload_firebase.demo_springsecurity.service;

import upload_firebase.demo_springsecurity.model.entity.Role;

public interface RoleService {
    Role findRoleByRoleName(String roleName);
}
