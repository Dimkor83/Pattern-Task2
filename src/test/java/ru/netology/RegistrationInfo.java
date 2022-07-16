package ru.netology;

import lombok.Data;

@Data
public class RegistrationInfo {
    String login;
    String password;
    String status;

    public RegistrationInfo(String login, String password,String status) {
        this.login = login;
        this.password = password;
        this.status = status;
    }
}
