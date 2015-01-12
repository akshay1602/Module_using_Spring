package Controllers;

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

public class Login_Controller {
    @RequestMapping("/login")
    public ModelAndView Login_into_db(HttpServletRequest request, HttpServletResponse res) {
        String name = request.getParameter("username");
        String password = request.getParameter("password");

        ApplicationContext ctx=new ClassPathXmlApplicationContext("applicationContext.xml");
        Authentication d1 = (Authentication) ctx.getBean("auth");

        boolean status = false;

        User u = new User();
        u.setUsername(name);
        u.setPassword(password);
        status = d1.authenticate(u);


        if(status){
            return new ModelAndView("welcome","message",name);
        } else {
            return new ModelAndView("error","message","Authentication Failed");
        }

    }
}