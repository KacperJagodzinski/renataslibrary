package org.jagodzinskikacper.renataslibrary.user;

import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
@Transactional
public interface UserService {

    User findByUserName(String name);

    void saveUser(User user);

    void updateUser(User user);

    User findById(Long id);
}