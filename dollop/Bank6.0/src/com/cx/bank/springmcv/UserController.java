package com.cx.bank.springmcv;

import com.cx.bank.manager.ManagerInterface;
import com.cx.bank.model.UserBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.support.RequestContext;

import javax.servlet.http.HttpServletRequest;

@Controller
@SessionAttributes("name")
public class UserController {

    @Autowired private ManagerInterface manager;
    public void setManager(ManagerInterface manager){
        System.out.println(this.manager);
        this.manager = manager;
        System.out.println(this.manager);
    }

    @RequestMapping("/login.do")
    public String login(UserBean user, ModelMap map, HttpServletRequest request, Model model){
        String name = user.getName();
        System.out.println(user.getName());
        System.out.println(user.getPassword());
        boolean flag;
        System.out.println(manager == null);
        flag = manager.login(user);
        if(!flag) {
            RequestContext requestContext = new RequestContext(request);
            model.addAttribute("message",requestContext.getMessage("page.loginfail"));
            return "index";
        }
        map.addAttribute("name",name);
        return "login";
    }

    @RequestMapping("/register.do")
    public String register(UserBean user,HttpServletRequest request){
        boolean flag;
        flag = manager.register(user);
        if (!flag){
            RequestContext requestContext = new RequestContext(request);
            request.setAttribute("message",requestContext.getMessage("page.registerfail"));
            return "register";
        }
        return "index";
    }
}
