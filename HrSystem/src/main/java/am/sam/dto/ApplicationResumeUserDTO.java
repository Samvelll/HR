package am.sam.dto;

import am.sam.entity.Application;

import java.util.HashSet;
import java.util.Set;

public class ApplicationResumeUserDTO {
    private Long id;
    private String name;

    private Set<ResumeDTO> resumeDTOSet = new HashSet<>();
    private Set<UserDTO> userDTOSet = new HashSet<>();

    public ApplicationResumeUserDTO() {
    }

    public ApplicationResumeUserDTO(Application application) {
        this.id = application.getId();
        this.name = application.getName();

        application.getResumes().forEach(t -> resumeDTOSet.add(new ResumeDTO(t)));
        application.getUsers().forEach(t -> userDTOSet.add(new UserDTO(t)));
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

    public Set<ResumeDTO> getResumes() {
        return resumeDTOSet;
    }

    public void setResumes(Set<ResumeDTO> resumeDTOSet) {
        this.resumeDTOSet = resumeDTOSet;
    }

    public Set<UserDTO> getUsers() {
        return userDTOSet;
    }

    public void setUsers(Set<UserDTO> userDTOSet) {
        this.userDTOSet = userDTOSet;
    }
}
