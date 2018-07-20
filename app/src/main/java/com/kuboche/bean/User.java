package com.kuboche.bean;

import com.orm.SugarRecord;
import com.orm.annotation.Table;

import java.io.Serializable;

@Table
public class User extends SugarRecord implements Serializable {
    private String account;
    private String nickname;
    private String password;
    private String securityQuestion;
    private String securityAnswer;
    private boolean parking;


    public User(String account, String nickname, String password, String securityQuestion, String securityAnswer,boolean parking) {
        this.account = account;
        this.nickname = nickname;
        this.password = password;
        this.securityQuestion = securityQuestion;
        this.securityAnswer = securityAnswer;
        this.parking = parking;
    }

    public User() {
    }

    public String getAccount() {
        return account;
    }

    public void setAccount(String account) {
        this.account = account;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public String getSecurityAnswer() {
        return securityAnswer;
    }

    public String getSecurityQuestion() {
        return securityQuestion;
    }

    public void setSecurityAnswer(String securityAnswer) {
        this.securityAnswer = securityAnswer;
    }

    public void setSecurityQuestion(String securityQuestion) {
        this.securityQuestion = securityQuestion;
    }

    public boolean isParking() {
        return parking;
    }

    public void setParking(boolean parking) {
        this.parking = parking;
    }

}

