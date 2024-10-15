package com.restapi.RestfullAPIDB.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Schema(
        description = "User DTO details...."
)

public class UserDto {

    @Schema(
            description = "User Id "
    )

    private Long id;
    @Schema(
            description = "User first Name"
    )
    @NotEmpty(message = "user first name should not be null or empty please enter the value.")
    private String firstName;
    @NotEmpty(message = "user last name should not be not null or an empty please enter the value.")
    @Schema(
            description = "User Last Name"
    )
    private String lastName;
    @Schema(
            description = "User email "
    )
    @NotEmpty(message = "user email should not be null or an empty.")
    @Email
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
