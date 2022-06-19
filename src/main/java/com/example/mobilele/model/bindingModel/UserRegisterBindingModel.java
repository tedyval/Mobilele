package com.example.mobilele.model.bindingModel;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

public class UserRegisterBindingModel {

    @NotBlank
    @Size(min = 2,max = 20, message = "Username must be between 2 and 20 characters.")
    private String username;
    @NotBlank
    @Size(min = 2,max = 20, message = "First name must be between 2 and 20 characters.")
    private String firstName;
    @NotBlank
    @Size(min = 2,max = 20, message = "Last name must be between 2 and 20 characters.")
    private String lastName;
    @NotBlank
    @Size(min = 2,max = 20, message ="Password must be between 2 and 20 characters.")
    private String password;
    @NotBlank
    @Size(min = 2,max = 20, message = "Password should match.")
    private String confirmPassword;

    public UserRegisterBindingModel() {
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getConfirmPassword() {
        return confirmPassword;
    }

    public void setConfirmPassword(String confirmPassword) {
        this.confirmPassword = confirmPassword;
    }
}
