package com.cx.bank.model;

public class UserBean{

    private String name;//用户名
    private String password;//密码
    private String repass;
    private String id;
    private String inAccount;
    private double money;

    private MoneyBean moneyBean = new MoneyBean();
    
    public UserBean(){}

    public void setName(String name){
        this.name = name;
    }
    public String getName(){
        return name;
    }
    public void setPassword(String password){
        this.password = password;
    }
    public String getPassword(){
        return password;
    }
    public void setId(String id){
        this.id = id;
    }
    public String getId(){
        return id;
    }
    public void setMoneyBean(MoneyBean moneyBean){
        this.moneyBean = moneyBean;
    }
    public MoneyBean getMoneyBean(){
        return moneyBean;
    }
    public void setRepass(String repass){
        this.repass = repass;
    }
    public String getRepass(){
        return repass;
    }
    public void setMoney(double money) {
        this.money = money;
    }

    public double getMoney() {
        return money;
    }

    public void setInAccount(String inAccount) {
        this.inAccount = inAccount;
    }

    public String getInAccount() {
        return inAccount;
    }
}
