package model;

public class User {
    String Name;
    String Username;
    String Password;
    String Confirm_Password;

    public void setName(String s){
        this.Name = s;
    }

    public void setUsername(String s){
        this.Username = s;
    }

    public void setPassword(String s){
        this.Password = s;
    }
    public void setConfirm_Password(String s){
        this.Confirm_Password = s;
    }

    public String getName(){
        return this.Name;
    }

    public String getUsername(){
        return this.Username;
    }

    public String getPassword(){
        return this.Password;
    }

    public String getConfirm_Password(){
        return this.Confirm_Password;
    }


}
