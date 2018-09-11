package com.cx.bank.mybatis;

public class User {

    private String name;//用户名
    private String password;//密码
    private String repass;
    private String id;
    private String inAccount;
    private double money;
    private int lockuser;

    private Account account = new Account();
    
    public User(){}

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
    public void setAccount(Account account){
        this.account = account;
    }
    public Account getAccount(){
        return account;
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

    public void setLockuser(int lockuser){
        this.lockuser = lockuser;
    }
    public int getLockuser(){
        return lockuser;
    }
}
