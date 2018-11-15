package com.flyingfish.infrastructure.authentication;

import com.flyingfish.entity.Account;
import com.flyingfish.repository.AccountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class UserService implements IUserService {

    @Autowired
    private AccountRepository accountRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Account account = this.accountRepository.findByUsernameEquals(username);
        User user = new User();
        user.setUsername(account.getUsername());
        user.setPassword(account.getPassword());

        return new UserDetails(user);
    }
}
