package com.cx.bank.dao;

import com.cx.bank.mybatis.User;

import java.util.List;

public interface BankMapper {

    int addUser(User user);

    User selectUser(User user);

    User queryUser(String name);

    int updateUser(User user);


}
