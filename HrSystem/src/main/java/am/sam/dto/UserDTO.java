package am.sam.dto;

import am.sam.entity.User;

import java.time.LocalDate;
import java.time.Period;

public class UserDTO {

    private Long id;
    private String name;
    private String surname;
    private Integer age;
    private String email;
    private String phoneNumber;

    public UserDTO(User user) {
        this.id = user.getId();
        this.name = user.getName();
        this.surname = user.getSurname();

        LocalDate now = LocalDate.now();
        LocalDate birthday = user.getAge();
        this.age = Period.between(birthday, now).getYears();

        this.email = user.getEmail();
        this.phoneNumber = user.getPhoneNumber();
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
}
