package com.cx.bank.service;

import com.cx.bank.mybatis.*;
import com.cx.bank.util.*;
import com.cx.bank.dao.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import java.text.SimpleDateFormat;
import java.util.Date;


@Transactional
public class ManagerImpl implements ManagerInterface{

    @Autowired private BankMapper bankMapper;

    @Autowired private AccountMapper accountMapper;

    @Autowired private RecordMapper recordMapper;

    public void setRecordMapper(RecordMapper recordMapper) {
        this.recordMapper = recordMapper;
    }

    public void setBankMapper(BankMapper bankMapper) {
        this.bankMapper = bankMapper;
    }

    public void setAccountMapper(AccountMapper accountMapper) {
        this.accountMapper = accountMapper;
    }

    Account account = Account.getInstance();
    User users = new User();


    /**
     * 用户注册
     * @param user
     * @return
     */
    public boolean register(User user){
        user.setLockuser(1);
        bankMapper.addUser(user);
        User list = bankMapper.selectUser(user);
        account.setId(list.getId());
        account.setMoney(0.0);
        accountMapper.addAccount(account);
        System.out.println(account.getId());
        return true;
    }


    /**
     * 用户登陆
     * @param user
     * @return
     */
    public boolean login(User user){
        try {
            User list = bankMapper.selectUser(user);
            users.setLockuser(list.getLockuser());
            users.setName(list.getName());

            account.setId(list.getId());
            Account ac = accountMapper.selectAccount(list.getId());
            account.setMoney(ac.getMoney());
            System.out.println(list.getLockuser());
        }catch (Exception e){
            e.printStackTrace();
            return false;
        }
        return true;
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
        else if (users.getLockuser() == 1){
            double d = money + this.account.getMoney();
            System.out.println(account.getId());
            account.setMoney(d);
            accountMapper.updateAccount(account);

            this.record("充值", money);
            return true;
        }
        else {
            return false;
        }
    }

    /**
     * 支付
     * @param money
     * @throws AccountOverDrawnException
     */
    public boolean withdrawals(double money) throws AccountOverDrawnException{
        if(money > this.account.getMoney()){
            throw new AccountOverDrawnException();
        }
        else if (users.getLockuser() == 1){
            double b = this.account.getMoney() - money;
            this.account.setMoney(b);
            accountMapper.updateAccount(account);

            this.record("支付", money);
            return true;
        }
        else {
            return false;
        }
    }

    /**
     * 查询余额
     * @return
     */
    public double inquiry(){
        double money = account.getMoney();
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
     * 转账
     * @param inAccount
     * @param money
     * @return
     */
    public int transfer(String inAccount,double money){
       if(money <= 0 && money > this.account.getMoney()){
           System.out.println("Beyond the balance transfer amount!");
           return 0;
       }
       else if (users.getLockuser() == 1){

           double leftmoney = this.account.getMoney() - money;

           User list = bankMapper.queryUser(inAccount);

           double inmoney = list.getAccount().getMoney();
           System.out.println(inmoney);
           System.out.println(list.getId());
           Account account1 = new Account();
           account1.setMoney(inmoney);
           account1.setId(list.getId());
           accountMapper.updateAccount(account1);

           account.setMoney(leftmoney);
           accountMapper.updateAccount(account);

           this.record("转账", money);
           return 1;
       }
       else {
           return 2;
       }
    }

    /**
     * 冻结账户
     * @param name
     * @return
     */
    public boolean lockuser(String name){
        User user = new User();
        user.setName(name);
        user.setLockuser(0);
        try {
            bankMapper.updateUser(user);
        }catch (Exception e){
            return false;
        }
        return true;
    }

    /**
     * 解冻
     * @param name
     * @return
     */
    public boolean unlock(String name){
        User user = new User();
        user.setName(name);
        user.setLockuser(1);
        try {
            bankMapper.updateUser(user);
        }catch (Exception e){
            return false;
        }
        return true;
    }

    /**
     * 账户操作记录
     * @param message
     * @param money
     */
    public void record(String message, double money){
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Record record = new Record();
        record.setName(users.getName());
        String operte = message + money;
        record.setRecord(operte);
        record.setTime(simpleDateFormat.format(new Date()));
        recordMapper.addRecord(record);
        System.out.println(operte);
    }

}
