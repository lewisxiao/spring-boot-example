package com.flyingfish.service.account;

import com.flyingfish.dto.AccountDto;
import com.flyingfish.vo.AccountVo;

public interface IAccountService {
    AccountVo createAccount(AccountDto accountDto);
}
