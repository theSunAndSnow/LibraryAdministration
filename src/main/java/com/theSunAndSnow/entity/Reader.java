package com.theSunAndSnow.entity;

public class Reader {
    private Integer id;
    private String username;
    private String password;
    private String name;

    public Reader(String name) {
        this.name = name;
    }

    private String telephone;
    private String cardid;
    private String gender;

    public Reader() {
    }

    public Reader(Integer id, String username, String password, String name, String telephone, String cardid, String gender) {
        this.id = id;
        this.username = username;
        this.password = password;
        this.name = name;
        this.telephone = telephone;
        this.cardid = cardid;
        this.gender = gender;
    }

    public Integer getId() {
        return id;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    public String getName() {
        return name;
    }

    public String getTelephone() {
        return telephone;
    }

    public String getCardid() {
        return cardid;
    }

    public String getGender() {
        return gender;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

    public void setCardid(String cardid) {
        this.cardid = cardid;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }
}
