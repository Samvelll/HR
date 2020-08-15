package am.sam.dto;

import am.sam.entity.Resume;

public class ResumeDTO {

    private Long id;
    private String name;

    public ResumeDTO() {
    }

    public ResumeDTO(Resume resume) {
        this.id = resume.getId();
        this.name = resume.getName();
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
}
