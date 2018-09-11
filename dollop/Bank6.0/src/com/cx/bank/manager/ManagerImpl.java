package com.cx.bank.manager;

import com.cx.bank.model.*;
import com.cx.bank.util.*;
import com.cx.bank.dao.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;


@Transactional
public class ManagerImpl implements ManagerInterface{

    MoneyBean moneyBean = MoneyBean.getInstance();

    @Autowired private BankdaoInterface dao;

    public void setDao(BankdaoInterface dao){
        this.dao = dao;
        System.out.println(this.dao);
    }


    /**
     * 充值
     * @param money
     * @throws InvalidDepositException
     */
    public boolean deposit(double money) throws InvalidDepositException{
        if(money < 0){
            throw new InvalidDepositException();
        }
        else {
            double d = money + moneyBean.getMoney();
            moneyBean.setMoney(d);
            dao.save(d);
            System.out.println("充值金额:" + money);
            return true;
        }
    }

    /**
     * 支付
     * @param money
     * @throws AccountOverDrawnException
     */
    public boolean withdrawals(double money) throws AccountOverDrawnException{
        if(money > moneyBean.getMoney()){
            throw new AccountOverDrawnException();
        }
        else{
            double b = moneyBean.getMoney() - money;
            moneyBean.setMoney(b);
            dao.save(b);
            System.out.println("支付金额:" + money);
            return true;
        }
    }

    /**
     * 查询余额
     * @return
     */
    public double inquiry(){
        double money = moneyBean.getMoney();
        System.out.println("余额" + money);
        return money;
    }

    /**
     * 退出系统
     * @param name
     * @return
     */
    public boolean exitSystem(String name){
        boolean flag = false;
        return flag;
    }

    /**
     * 用户登陆
     * @param userBean
     * @return
     */
    public boolean login(UserBean userBean){
        System.out.println(userBean+ "tt");
        System.out.println(this.dao);
        boolean flag = dao.login(userBean);
        return flag;
    }

    /**
     * 用户注册
     * @param userBean
     * @return
     */
    public boolean register(UserBean userBean){
        boolean flag = dao.register(userBean);
        return flag;
    }

    /**
     * 转账
     * @param inAccount
     * @param money
     * @return
     */
    public boolean transfer(String inAccount,double money){
       if(money >= 0 && money < moneyBean.getMoney()){
           dao.transfer(inAccount,money);
           double leftmoney = moneyBean.getMoney() - money;
           System.out.println("转账金额:" + money);
           return true;
       } 
       else{
           System.out.println("Beyond the balance transfer amount!");
           return false;
       }
    }
}
