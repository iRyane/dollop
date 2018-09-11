package com.cx.bank.mybatis;

public class Account {

    private String id;
    private double money;


    private static Account account;
    public Account(){}
    public static Account getInstance(){
        if(account == null){
            account = new Account();
        }
        return account;
    }

    public void setMoney(double m){
        money = m;
    }
    public double getMoney(){
        return money;
    }
    public void setId(String id){
        this.id = id;
    }
    public String getId(){
        return id;
    }
}
