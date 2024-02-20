package brian.sang.hotelmns.roles;

import brian.sang.hotelmns.exceptions.NotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RoleService {
    private final RoleRepository repository;

    public RoleService(RoleRepository repository) {
        this.repository = repository;
    }

    public List<Role> findAllRoles() {
        return repository.findAll();
    }

    public Role findRoleById(Integer roleId) {
        return repository.findById(roleId)
                .orElseThrow(() ->
                    new NotFoundException("User with id:"+roleId+" was not found in the database")
                );
    }

    public void addNewRole(Role role) {
        repository.save(role);
    }

    public void updateRole(Role role) {
        repository.save(role);
    }

    public void deleteRole(Integer id) {
        repository.deleteById(id);
    }
}
