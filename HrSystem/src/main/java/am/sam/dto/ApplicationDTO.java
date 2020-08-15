package am.sam.dto;

import am.sam.entity.Application;

public class ApplicationDTO {

    private Long id;
    private String name;

    public ApplicationDTO() {

    }

    public ApplicationDTO(Application application) {
        this.id = application.getId();
        this.name = application.getName();
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
