package am.sam.dto;

import am.sam.entity.User;

import java.time.LocalDate;
import java.time.Period;
import java.util.HashSet;
import java.util.Set;

public class UserRoleApplicationDTO {
    private Long id;
    private String name;
    private String surname;
    private Integer age;
    private String email;
    private String phoneNumber;

    private RoleDTO roleDTO;
    private Set<ApplicationDTO> applicationDTOSet = new HashSet<>();

    public UserRoleApplicationDTO(User user) {
        this.id = user.getId();
        this.name = user.getName();
        this.surname = user.getSurname();

        if(user.getAge() != null) {
            LocalDate now = LocalDate.now();
            LocalDate birthday = user.getAge();
            this.age = Period.between(birthday, now).getYears();
        }

        this.email = user.getEmail();
        this.phoneNumber = user.getPhoneNumber();

        if(user.getRole() != null) {
            roleDTO = new RoleDTO(user.getRole());
        }
        user.getApplications().forEach(t -> applicationDTOSet.add(new ApplicationDTO(t)));
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

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public RoleDTO getRole() {
        return roleDTO;
    }

    public void setRole(RoleDTO roleDTO) {
        this.roleDTO = roleDTO;
    }

    public Set<ApplicationDTO> getApplications() {
        return applicationDTOSet;
    }

    public void setApplications(Set<ApplicationDTO> applicationDTOSet) {
        this.applicationDTOSet = applicationDTOSet;
    }
}
