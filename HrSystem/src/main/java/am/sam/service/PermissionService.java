package am.sam.service;

import am.sam.dto.PermissionRoleDTO;
import am.sam.entity.Permission;
import am.sam.repository.PermissionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;

@Service
public class PermissionService {

    @Autowired
    private PermissionRepository permissionRepository;

    public List<PermissionRoleDTO> getAllPermissions() {
        List<PermissionRoleDTO> permissionList = new ArrayList<>();

        permissionRepository.findAll().forEach(t -> permissionList.add(new PermissionRoleDTO(t)));
        return permissionList;
    }

    public PermissionRoleDTO getPermission(Long id) {
        try {
            return new PermissionRoleDTO(permissionRepository.findById(id).get());
        }
        catch(NoSuchElementException e) {
            e.printStackTrace();
        }
        return null;
    }

    public void addPermission(Permission permission) {
        permissionRepository.save(permission);
    }

    public void updatePermission(Permission permission, Long id) {
        if(permission.getId().equals(id)) {
            permissionRepository.save(permission);
        }
    }

    public void deletePermission(Long id) {
        permissionRepository.deleteById(id);
    }
}
