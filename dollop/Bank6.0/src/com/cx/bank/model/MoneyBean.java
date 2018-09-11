package com.cx.bank.model;

public class MoneyBean{

    private double money;
    private String id;
    private static MoneyBean moneyBean;

    public MoneyBean(){}

    public static MoneyBean getInstance(){
        if(moneyBean == null){
            moneyBean = new MoneyBean();
        }
        return moneyBean;
    }

    public void setMoney(double m){
        money = m;
    }
    public double getMoney(){
        return  money;
    }
    public void setId(String id){
        this.id = id;
    }
    public String getId(){
        return id;
    }
}
