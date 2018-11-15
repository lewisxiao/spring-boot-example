package com.flyingfish.controller;

import com.flyingfish.dto.AccountDto;
import com.flyingfish.infrastructure.web.Response;
import com.flyingfish.service.account.impl.AccountService;
import com.flyingfish.vo.AccountVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@RequestMapping("/api/account")
public class AccountController {
    @Autowired
    private AccountService accountService;

    @PostMapping("/register")
    public Response register(@RequestBody @Valid AccountDto accountDto) {
        AccountVo vo = this.accountService.createAccount(accountDto);

        return new Response(vo);
    }
}
