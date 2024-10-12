package com.restapi.RestfullAPIDB.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;



public class UserDto {

    private Long id;
    private String firstName;
    private String lastName;
    private String email;
    UserDto(){}


    public UserDto(Long id, String firstName, String lastName, String email) {
        this.id=id;
        this.firstName=firstName;
        this.lastName=lastName;
        this.email=email;
    }


    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }
}
