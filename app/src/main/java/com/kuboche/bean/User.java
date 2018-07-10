package com.kuboche.bean;

import com.orm.SugarRecord;
import com.orm.annotation.Table;

import java.io.Serializable;

@Table
public class User extends SugarRecord implements Serializable {
    String account;
    String nickname;
    String password;
    String securityQuestion;
    String securityAnswer;


    public User(String account,String nickname,String password,String securityQuestion,String securityAnswer){
        this.account=account;
        this.nickname=nickname;
        this.password=password;
        this.securityQuestion=securityQuestion;
        this.securityAnswer=securityAnswer;
    }
}

class UserTest {
    public static void main(String[] args) {


        User U1;
        U1 = new User("18171370371", "可可", "123456", "爸爸的生日", "8月7日");

    }
}
