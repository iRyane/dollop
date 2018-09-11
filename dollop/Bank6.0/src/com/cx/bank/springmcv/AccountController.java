package com.cx.bank.springmcv;

import com.cx.bank.manager.ManagerInterface;
import com.cx.bank.util.AccountOverDrawnException;
import com.cx.bank.util.InvalidDepositException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.support.RequestContext;

import javax.servlet.http.HttpServletRequest;

@Controller
@SessionAttributes("name")
public class AccountController {

    @Autowired private ManagerInterface manager;
    public void setManager(ManagerInterface manager){
        this.manager = manager;
    }

    @RequestMapping("/deposit.do")
    public String deposit(double money,HttpServletRequest request){
        RequestContext requestContext = new RequestContext(request);
        try {
            manager.deposit(money);
        }catch (InvalidDepositException e){
            e.printStackTrace();
            request.setAttribute("message",requestContext.getMessage("page.deposit.fail"));
            return "error";
        }
        String message = requestContext.getMessage("page.deposit.succeed") + money + requestContext.getMessage("page.yuan");
        request.setAttribute("inputmessage",message);
        return "deposit";
    }

    @RequestMapping("/withdrawals.do")
    public String withdrawals(double money, HttpServletRequest request){
        RequestContext requestContext = new RequestContext(request);
        try {
            manager.withdrawals(money);
        }catch (AccountOverDrawnException e){
            e.printStackTrace();
            request.setAttribute("message",requestContext.getMessage("page.withdrawals.fail"));
            return "error";
        }
        String message = requestContext.getMessage("page.withdrawals.succeed") + money + requestContext.getMessage("page.yuan");
        request.setAttribute("inputmessage",message);
        return "withdrawals";
    }

    @RequestMapping("/inquiry.do")
    public String inquiry(HttpServletRequest request){
        double money = manager.inquiry();
        RequestContext requestContext = new RequestContext(request);
        String message = requestContext.getMessage("page.inquiry") + money + requestContext.getMessage("page.yuan");
        request.setAttribute("message",message);
        return "inquiry";
    }

    @RequestMapping("/transfer.do")
    public String transfer(String inAccount, double money, HttpServletRequest request){
        RequestContext requestContext = new RequestContext(request);
        boolean flag = false;
        try {
            flag = manager.transfer(inAccount,money);
        }catch (Exception e){
            e.printStackTrace();
        }
        if (!flag){
            request.setAttribute("message",requestContext.getMessage("page.transfer.fail"));
            return "error";
        }
        String message = requestContext.getMessage("page.transfer.succeed") + money + requestContext.getMessage("page.yuan");
        return "transfer";
    }

}