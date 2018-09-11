package com.cx.bank.dao;

import com.cx.bank.mybatis.Account;

import java.util.List;

public interface AccountMapper {
    int addAccount(Account account);

    Account selectAccount(String id);

    int updateAccount(Account account);
}
