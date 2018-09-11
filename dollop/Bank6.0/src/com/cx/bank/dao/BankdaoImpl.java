package com.cx.bank.dao;

import java.util.Iterator;
import java.util.List;

import com.cx.bank.model.*;
import com.cx.bank.util.*;
import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.transaction.annotation.Transactional;


@Transactional
public class BankdaoImpl implements BankdaoInterface{

    private HibernateTemplate hibernateTemplate;
    public void setHibernateTemplate(HibernateTemplate hibernateTemplate){
        this.hibernateTemplate = hibernateTemplate;
    }

    MoneyBean moneyBean = MoneyBean.getInstance();
    MD5 md5 = new MD5();


    public BankdaoImpl(){}

    @Override
    public void save(double money){

        try {
            moneyBean.setMoney(money);
            hibernateTemplate.update(moneyBean);
        }catch (Exception e){
            e.printStackTrace();
        }

    }

    @Override
    public boolean register(UserBean user){

        try {
            moneyBean.setMoney(0);
            user.setMoneyBean(moneyBean);
            //session.save(moneyBean);
            hibernateTemplate.save(user);
            return true;
        }
        catch (Exception e){
            e.printStackTrace();
            return false;
        }

    }

    @Override
    public boolean login(UserBean user){

        String name = user.getName();
        String password = user.getPassword();
        System.out.println(name+"yy");
        System.out.println(password+"yy");

        try {
            String sql= "from UserBean u where u.name= ? and u.password= ? ";
            List<UserBean> result = (List<UserBean>)hibernateTemplate.find(sql,name,password);
            if(result.isEmpty())return false;
            for (Iterator iterator = result.iterator();iterator.hasNext();){
                UserBean userBean = (UserBean)iterator.next();
                moneyBean.setMoney(userBean.getMoneyBean().getMoney());
                moneyBean.setId(userBean.getId());
            }
        }
        catch (Exception e){
            e.printStackTrace();
            return false;
        }
        return true;
    }

    @Override
    public boolean transfer(String InAccount,double money){
        double left = moneyBean.getMoney() - money;
        moneyBean.setMoney(left);
        try {
            String sql= "from UserBean u where u.name= ?";
            List<UserBean> result = (List<UserBean>)hibernateTemplate.find(sql,InAccount);

            if(result.isEmpty())return false;
            /**for (Iterator iterator = user.iterator();iterator.hasNext();){
                UserBean userBean = (UserBean)iterator.next();
                inmoney =  userBean.getMoneyBean().getMoney() + money;
                accountId = userBean.getId();
            }
             */

            String accountId = null;
            for (UserBean user : result){
                accountId = user.getId();
            }
            MoneyBean mb = hibernateTemplate.load(MoneyBean.class,accountId);
            double inmoney =  mb.getMoney() + money;
            mb.setMoney(inmoney);
            hibernateTemplate.update(mb);

            hibernateTemplate.update(moneyBean);
        }
        catch (Exception e){
            e.printStackTrace();
            return false;
        }
        return true;
    }

}
