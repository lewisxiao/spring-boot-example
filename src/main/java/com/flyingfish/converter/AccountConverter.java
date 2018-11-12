package com.flyingfish.converter;

import com.flyingfish.dto.AccountDto;
import com.flyingfish.entity.Account;
import com.flyingfish.utils.PasswordUtil;
import com.flyingfish.vo.AccountVo;

public class AccountConverter {
    public static Account dtoToEntity(AccountDto dto) {
        Account entity = new Account();
        entity.setEmail(dto.getEmail());
        entity.setPassword(dto.getPassword());

        // set password salt
        String salt = PasswordUtil.getRandomSalt();
        entity.setSalt(salt);

        return entity;
    }

    public static AccountVo entityToVo(Account entity) {
        AccountVo vo = new AccountVo();
        vo.setEmail(entity.getEmail());

        return vo;
    }
}
