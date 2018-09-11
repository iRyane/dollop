package com.cx.bank.springmcv;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.i18n.SessionLocaleResolver;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Locale;

@Controller
public class LanguageController {

    @RequestMapping("/changelanguage.do")
    public ModelAndView test(HttpServletRequest request, HttpServletResponse response,String lan){
        ModelAndView modelAndView = new ModelAndView("index");
        System.out.println(lan);
        if(lan.equals("zh")){
            Locale locale = new Locale("zh", "CN");
            request.getSession().setAttribute(SessionLocaleResolver.LOCALE_SESSION_ATTRIBUTE_NAME,locale);
        }
        else if(lan.equals("en")) {
            Locale locale = new Locale("en", "US");
            request.getSession().setAttribute(SessionLocaleResolver.LOCALE_SESSION_ATTRIBUTE_NAME, locale);
        }
        return modelAndView;
    }
}
