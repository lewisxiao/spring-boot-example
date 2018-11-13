package com.flyingfish.infrastructure.authentication;

import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class UserService implements IUserService {
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        /*模拟数据库操作*/
        User user = new User();
        user.setUsername("123");
        /*password: reader1234*/
        user.setPassword("$2a$08$dwYz8O.qtUXboGosJFsS4u19LHKW7aCQ0LXXuNlRfjjGKwj5NfKSe");
        return new UserDetails(user);
    }
}
