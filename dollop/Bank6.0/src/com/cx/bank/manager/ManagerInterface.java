package com.cx.bank.manager;
import com.cx.bank.model.UserBean;
import com.cx.bank.util.*;

public interface ManagerInterface{
    boolean deposit(double money) throws InvalidDepositException;
    boolean register(UserBean userBean);
    boolean login(UserBean userBean);
    boolean withdrawals(double money) throws AccountOverDrawnException;
    double inquiry();
    boolean transfer(String inAccount,double money);
    boolean exitSystem(String name);

}
