package org.jagodzinskikacper.renataslibrary.user;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.User;

import java.util.Collection;

public class CurrentUser extends User {
    private final org.jagodzinskikacper.renataslibrary.user.User user;

    public CurrentUser(String username, String password,
                       Collection<? extends GrantedAuthority> authorities,
                       org.jagodzinskikacper.renataslibrary.user.User user) {
        super(username, password, authorities);
        this.user = user;
    }

    public org.jagodzinskikacper.renataslibrary.user.User getUser() {
        return user;
    }
}