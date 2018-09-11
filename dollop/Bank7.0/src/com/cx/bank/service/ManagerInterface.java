package com.cx.bank.service;
import com.cx.bank.mybatis.User;
import com.cx.bank.util.*;

public interface ManagerInterface{
    boolean deposit(double money) throws InvalidDepositException;
    boolean register(User user);
    boolean login(User user);
    boolean withdrawals(double money) throws AccountOverDrawnException;
    double inquiry();
    int transfer(String inAccount,double money);
    boolean exitSystem(String name);
    boolean lockuser(String name);
    boolean unlock(String name);

}
