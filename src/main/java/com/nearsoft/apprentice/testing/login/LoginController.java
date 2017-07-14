package com.nearsoft.apprentice.testing.login;

import lombok.Setter;

@Setter
public class LoginController {

    private LoginService loginService;

    public String login(UserForm userForm) {
        if (null == userForm) {
            return "ERROR";
        }

        boolean logged;
        try {
            logged = loginService.login(userForm);
        } catch (Exception e) {
            return "ERROR";
        }

        if (logged) {
            loginService.setCurrentUser(userForm.getUsername());
            return "OK";
        } else {
            return "KO";
        }
    }
}
