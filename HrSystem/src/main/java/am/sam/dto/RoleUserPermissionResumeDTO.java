package am.sam.dto;

import am.sam.entity.Role;

import java.util.HashSet;
import java.util.Set;

public class RoleUserPermissionResumeDTO {
    private Long id;
    private String name;

    private Set<UserDTO> userDTOSet = new HashSet<>();
    private Set<PermissionDTO> permissionDTOSet = new HashSet<>();
    private Set<ResumeDTO> resumeDTOSet = new HashSet<>();

    public RoleUserPermissionResumeDTO(Role role) {
        this.id = role.getId();
        this.name = role.getName();

        role.getUsers().forEach(t -> userDTOSet.add(new UserDTO(t)));
        role.getPermissions().forEach(t -> permissionDTOSet.add(new PermissionDTO(t)));
        role.getResumes().forEach(t -> resumeDTOSet.add(new ResumeDTO(t)));
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

    public Set<UserDTO> getUsers() {
        return userDTOSet;
    }

    public void setUsers(Set<UserDTO> userDTOSet) {
        this.userDTOSet = userDTOSet;
    }

    public Set<PermissionDTO> getPermissions() {
        return permissionDTOSet;
    }

    public void setPermissions(Set<PermissionDTO> permissionDTOSet) {
        this.permissionDTOSet = permissionDTOSet;
    }

    public Set<ResumeDTO> getResumes() {
        return resumeDTOSet;
    }

    public void setResumes(Set<ResumeDTO> resumeDTOSet) {
        this.resumeDTOSet = resumeDTOSet;
    }
}
