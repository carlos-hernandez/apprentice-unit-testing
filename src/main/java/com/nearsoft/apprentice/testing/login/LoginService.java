package com.nearsoft.apprentice.testing.login;

import static org.apache.commons.lang3.StringUtils.isNotEmpty;

public class LoginService {

    private LoginRepository loginRepository;
    private String currentUser;

    public boolean login(UserForm userForm) {
        assert null != userForm;

        int loginResults = loginRepository.login(userForm);
        switch (loginResults) {
            case 1:
                return true;
            default:
                return false;
        }
    }

    public void setCurrentUser(String username) {
        if (isNotEmpty(username)) {
            this.currentUser = username;
        }
    }
}
