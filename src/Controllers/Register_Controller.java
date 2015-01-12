package Controllers;


import model.User;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import javax.activation.DataSource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.core.io.*;
import model.User;
@Controller

/**
 * Created by akshay.Gupta on 1/9/2015.
 */
public class Register_Controller {
    @RequestMapping("/register")
    public ModelAndView Register_into_db(HttpServletRequest request, HttpServletResponse res) {
        String s1 = request.getParameter("Name");
        String s2 = request.getParameter("Username");
        String s3 = request.getParameter("Password");
        String s4 = request.getParameter("Confirm_Password");

        ApplicationContext ctx = new ClassPathXmlApplicationContext("applicationContext.xml");
        Authentication d1 = (Authentication) ctx.getBean("auth");

        User r = new User();
        r.setName(s1);
        r.setUsername(s2);
        r.setPassword(s3);
        r.setConfirm_Password(s4);
        boolean status = d1.authenticate(r);
        if(!status){
            return new ModelAndView("User_already_exists", "message", "User_exists");
        }

        String s = d1.Enter_into_db(r);

        if (s == "Blank") {
            return new ModelAndView("blank", "message", "blank");
        } else if (s == "Password_error") {
            return new ModelAndView("Password_error", "message", "pwd_error");

        } else {
            return new ModelAndView("welcome", "message", s2);
        }

    }
}
