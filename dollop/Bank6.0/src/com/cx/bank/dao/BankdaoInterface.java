package com.cx.bank.dao;

import com.cx.bank.model.UserBean;

public interface BankdaoInterface{

    boolean register(UserBean user);

    boolean login(UserBean user);

    boolean transfer(String inAccount, double money);

    void save(double money);
}
