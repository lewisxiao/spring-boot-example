package com.flyingfish.service.account.impl;

import com.flyingfish.converter.AccountConverter;
import com.flyingfish.dto.AccountDto;
import com.flyingfish.entity.Account;
import com.flyingfish.exception.AccountExistsException;
import com.flyingfish.infrastructure.error.ErrorCode;
import com.flyingfish.infrastructure.error.ErrorMsg;
import com.flyingfish.repository.AccountRepository;
import com.flyingfish.service.account.IAccountService;
import com.flyingfish.vo.AccountVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AccountService implements IAccountService {
    @Autowired
    private AccountRepository accountRepository;

    @Override
    public AccountVo createAccount(AccountDto accountDto) {
        if (this.isAccountExists(accountDto.getUsername())) {
            throw new AccountExistsException(ErrorMsg.ACCOUNT_EMAIL_EXISTS, ErrorCode.ACCOUNT_EMAIL_EXISTS);
        }

        Account account = AccountConverter.dtoToEntity(accountDto);
        account = this.accountRepository.save(account);
        AccountVo accountVo = AccountConverter.entityToVo(account);

        return accountVo;
    }

    private boolean isAccountExists(String username) {
        Account account = this.accountRepository.findByUsernameEquals(username);

        if (account == null) {
            return false;
        }

        return true;
    }
}
