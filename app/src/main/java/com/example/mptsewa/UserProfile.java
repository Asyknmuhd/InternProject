package com.example.mptsewa;

public class UserProfile {
    public String userEmail;
    public String userName;
    public String userPhone;

    public UserProfile(){
    }

    public UserProfile(String userEmail,String userName, String userPhone){
        this.userEmail = userEmail;
        this.userName = userName;
        this.userPhone = userPhone;
    }

    public String getUserEmail() {
        return userEmail;
    }

    public void setUserEmail(String userEmail) {
        this.userEmail = userEmail;
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
