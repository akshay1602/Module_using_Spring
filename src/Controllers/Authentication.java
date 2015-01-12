package Controllers;

import javax.sql.DataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcOperations;
import org.springframework.jdbc.core.simple.SimpleJdbcTemplate;
import org.springframework.stereotype.Component;
import Controllers.Login_Controller;
import org.springframework.jdbc.core.JdbcTemplate;
import java.util.ArrayList;
import java.util.List;
import model.User;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;


public class Authentication {

    private JdbcTemplate jt;

    public boolean authenticate(User u){
        String query = " Select * from Employee where Username = '"+ u.getUsername() + "' AND Password = '"+ u.getPassword() +"'";
        List <User> l1 = jt.query(query,new BeanPropertyRowMapper(User.class));

        if(l1.isEmpty()){
            return false;
        } else {
            return true;
        }
    }
    public String Enter_into_db(User r){

        if(r.getName() == "" || r.getUsername() == "" || r.getPassword() == "" || r.getConfirm_Password() == ""){
            return "Blank";
        } else if(r.getPassword() != r.getConfirm_Password()){
            return "Password_error";
        } else {
            String query = "insert into employee(Name, Username, Password, Confirm_Password) VALUES ('" + r.getName() + "','" + r.getUsername() + "','" + r.getPassword() + "','" + r.getConfirm_Password() + "')";
            jt.update( query );
            return "success";
        }
    }

    public void setJt(JdbcTemplate jt) {
        this.jt = jt;
    }

    public JdbcTemplate getJt() {
        return jt;
    }
}
