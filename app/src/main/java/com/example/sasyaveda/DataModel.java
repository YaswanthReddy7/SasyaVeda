package com.example.sasyaveda;

public class DataModel {

    String userMail,userPassword,userName,userPhone;
    public DataModel(){

    }

    public DataModel(String userMail, String userPassword, String userName, String userPhone) {
        this.userMail = userMail;
        this.userPassword = userPassword;
        this.userName = userName;
        this.userPhone = userPhone;
    }

    public String getUserMail() {
        return userMail;
    }

    public void setUserMail(String userMail) {
        this.userMail = userMail;
    }

    public String getUserPassword() {
        return userPassword;
    }

    public void setUserPassword(String userPassword) {
        this.userPassword = userPassword;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getUserPhone() {
        return userPhone;
    }

    public void setUserPhone(String userPhone) {
        this.userPhone = userPhone;
    }
}
