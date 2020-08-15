package am.sam.dto;

import am.sam.entity.Resume;

import java.util.HashSet;
import java.util.Set;

public class ResumeApplicationRoleDTO {

    private Long id;
    private String name;

    private ApplicationDTO applicationDTO;
    private Set<RoleDTO> roleDTOSet = new HashSet<>();

    public ResumeApplicationRoleDTO() {
    }

    public ResumeApplicationRoleDTO(Resume resume) {
        this.id = resume.getId();
        this.name = resume.getName();

        if(resume.getApplication() != null) {
            applicationDTO = new ApplicationDTO(resume.getApplication());
        }

        resume.getRoles().forEach(t -> roleDTOSet.add(new RoleDTO(t)));
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

    public ApplicationDTO getApplication() {
        return applicationDTO;
    }

    public void setApplication(ApplicationDTO applicationDTO) {
        this.applicationDTO = applicationDTO;
    }

    public Set<RoleDTO> getRoles() {
        return roleDTOSet;
    }

    public void setRoles(Set<RoleDTO> roleDTOSet) {
        this.roleDTOSet = roleDTOSet;
    }
}
