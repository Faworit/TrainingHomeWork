package com.epam.ryabtsev.DTO;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;

public class UserDTO {

    private int personId;
    @NotBlank(message = "please enter user name")
    private String userName;
    @NotBlank(message = "please enter password")
    private String password;
    @NotBlank(message = "please enter email")
    @Email(message = "not correct email format")
    private String email;

    public int getPersonId() {
        return personId;
    }

    public void setPersonId(int personId) {
        this.personId = personId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
