package am.sam.service;

import am.sam.dto.RoleUserPermissionResumeDTO;
import am.sam.entity.Permission;
import am.sam.entity.Resume;
import am.sam.entity.Role;
import am.sam.repository.RoleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;

@Service
public class RoleService {

    @Autowired
    private RoleRepository roleRepository;

    public List<RoleUserPermissionResumeDTO> getAllRoles() {
        List<RoleUserPermissionResumeDTO> roleList = new ArrayList<>();
        roleRepository.findAll().forEach(t ->roleList.add(new RoleUserPermissionResumeDTO(t)));

        return roleList;
    }

    public RoleUserPermissionResumeDTO getRole(Long id) {

        try {
            return new RoleUserPermissionResumeDTO(roleRepository.findById(id).get());
        }
        catch(NoSuchElementException e) {
            e.printStackTrace();
        }

        return null;
    }

    public void addRole(Role role) {
        roleRepository.save(role);
    }

    public void addPermissionToRole(Long id, Long permissionId) {

        try {
            Role role = roleRepository.findById(id).get();
            role.addPermission(new Permission(permissionId, ""));
            roleRepository.save(role);
        }
        catch(NoSuchElementException e) {
            e.printStackTrace();
        }
    }

    public void addResumeToRole(Long id, Long resumeId) {
        try {
            Role role = roleRepository.findById(id).get();
            byte[] data = {};
            role.addResume(new Resume(resumeId, "", "", data));
            roleRepository.save(role);
        }
        catch(NoSuchElementException e) {
            e.printStackTrace();
        }
    }

    public void updateRole(Role role) {
        roleRepository.save(role);
    }

    public void deleteRole(Long id) {
        roleRepository.deleteById(id);
    }
}
