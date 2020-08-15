package am.sam.dto;

import am.sam.entity.Permission;

import java.util.HashSet;
import java.util.Set;

public class PermissionRoleDTO {
    private Long id;
    private String name;

    private Set<RoleDTO> roleDTOSet = new HashSet<>();

    public PermissionRoleDTO() {
    }

    public PermissionRoleDTO(Permission permission) {
        this.id = permission.getId();
        this.name = permission.getName();

        permission.getRoles().forEach(t -> roleDTOSet.add(new RoleDTO(t)));
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Set<RoleDTO> getRoles() {
        return roleDTOSet;
    }

    public void setRoles(Set<RoleDTO> roleDTOSet) {
        this.roleDTOSet = roleDTOSet;
    }
}
