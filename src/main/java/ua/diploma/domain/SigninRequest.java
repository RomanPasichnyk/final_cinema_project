package ua.diploma.domain;


import lombok.Data;

@Data
public class SigninRequest {

    private String email;
    private String password;

}
