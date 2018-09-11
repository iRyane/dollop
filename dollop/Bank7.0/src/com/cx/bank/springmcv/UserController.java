package com.cx.bank.springmcv;

import com.cx.bank.service.ManagerInterface;
import com.cx.bank.mybatis.User;
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
        this.manager = manager;
        System.out.println(this.manager);
    }

    @RequestMapping("/login.do")
    public String login(User user, ModelMap map, HttpServletRequest request, Model model){
        String name = user.getName();
        System.out.println(user.getName());
        System.out.println(user.getPassword());
        boolean flag;
        flag = manager.login(user);
        if(!flag) {
            RequestContext requestContext = new RequestContext(request);
            model.addAttribute("message",requestContext.getMessage("page.loginfail"));
            return "index";
        }
        map.addAttribute("name",name);
        if(name.equals("admin")){
            return "admin";
        }else {
            return "login";
        }
    }

    @RequestMapping("/register.do")
    public String register(User user, HttpServletRequest request){
        boolean flag;
        flag = manager.register(user);
        if (!flag){
            RequestContext requestContext = new RequestContext(request);
            request.setAttribute("message",requestContext.getMessage("page.registerfail"));
            return "register";
        }
        return "index";
    }

    @RequestMapping("/admin.do")
    public String admin(String name,HttpServletRequest request){
        boolean flag = manager.lockuser(name);
        if (flag) {
            request.setAttribute("message", "成功冻结账户");
        }else {
            request.setAttribute("message","冻结失败");
        }
        return "admin";
    }
}
