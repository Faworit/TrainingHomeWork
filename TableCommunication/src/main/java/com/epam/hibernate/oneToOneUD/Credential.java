package com.epam.hibernate.oneToOneUD;

import javax.persistence.*;

@Entity
@Table(name = "credential")
public class Credential {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "credential_id")
    private int credentialId;
    @Column(name = "user_name")
    private String userName;
    @Column(name = "password")
    private String password;

    public Credential(String userName, String password) {
        this.userName = userName;
        this.password = password;
    }

    public Credential() {
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
