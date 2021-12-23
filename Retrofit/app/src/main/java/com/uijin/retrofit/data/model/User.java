package com.uijin.retrofit.data.model;

import com.google.gson.annotations.SerializedName;

// 3. DTO 모델 Class 생성
public class User {

    @SerializedName("id")
    private int id;

    @SerializedName("email")
    private String email;

    @SerializedName("nick")
    private String nick;

    @SerializedName("password")
    private String password;

    @SerializedName("name")
    private String name;

    @SerializedName("snsId")
    private String snsId;

    @SerializedName("profile_img")
    private String profile_img;

    public User(String email, String password, String nick, String name,String snsId, String profile_img) {
        this.email = email;
        this.nick = nick;
        this.password = password;
        this.name = name;
        this.snsId = snsId;
        this.profile_img = profile_img;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getNick() {
        return nick;
    }

    public void setNick(String nick) {
        this.nick = nick;
    }

    public String getPassword() {
        return password;
    }

    public String getName() {
        return name;
    }

    public void setSnsId(String snsId) {
        this.snsId = snsId;
    }

    public String getSnsId() {
        return snsId;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getProfile_img() {
        return profile_img;
    }

    public void setProfile_img(String profile_img) {
        this.profile_img = profile_img;
    }
}
