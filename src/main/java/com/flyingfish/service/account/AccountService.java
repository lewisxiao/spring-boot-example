package com.flyingfish.service.account;

import com.flyingfish.converter.AccountConverter;
import com.flyingfish.dto.AccountDto;
import com.flyingfish.entity.Account;
import com.flyingfish.exception.AccountExistsException;
import com.flyingfish.infrastructure.error.ErrorCode;
import com.flyingfish.infrastructure.error.ErrorMsg;
import com.flyingfish.repository.AccountRepository;
import com.flyingfish.service.account.impl.IAccountService;
import com.flyingfish.vo.AccountVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AccountService implements IAccountService {
    @Autowired
    private AccountRepository accountRepository;

    @Override
    public AccountVo createAccount(AccountDto accountDto) {
        if (this.isAccountExists(accountDto.getEmail())) {
            throw new AccountExistsException(ErrorMsg.ACCOUNT_EMAIL_EXISTS, ErrorCode.ACCOUNT_EMAIL_EXISTS);
        }

        Account account = AccountConverter.dtoToEntity(accountDto);
        account = accountRepository.save(account);
        AccountVo accountVo = AccountConverter.entityToVo(account);

        return accountVo;
    }

    private boolean isAccountExists(String email) {
        Account account = accountRepository.findByEmailEquals(email);

        if (account == null) {
            return false;
        }

        return true;
    }
}
