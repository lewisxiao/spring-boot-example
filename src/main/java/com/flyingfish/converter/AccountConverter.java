package com.flyingfish.converter;

import com.flyingfish.dto.AccountDto;
import com.flyingfish.entity.Account;
import com.flyingfish.utils.PasswordUtil;
import com.flyingfish.vo.AccountVo;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

public class AccountConverter {
    public static Account dtoToEntity(AccountDto dto) {
        Account entity = new Account();
        entity.setUsername(dto.getUsername());
        entity.setPassword(new BCryptPasswordEncoder().encode(dto.getPassword()));

        // set password salt
        String salt = PasswordUtil.getRandomSalt();
        entity.setSalt(salt);

        return entity;
    }

    public static AccountVo entityToVo(Account entity) {
        AccountVo vo = new AccountVo();
        vo.setUsername(entity.getUsername());

        return vo;
    }
}
