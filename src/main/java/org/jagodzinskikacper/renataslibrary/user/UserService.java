package org.jagodzinskikacper.renataslibrary.user;

public interface UserService {
    User findByUserName(String name);
    void saveUser(User user);
}