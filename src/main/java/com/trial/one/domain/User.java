package com.trial.one.domain;

import javax.persistence.*;
import java.util.LinkedHashSet;
import java.util.Set;

/**
 * Created with IntelliJ IDEA.
 * User: Arun
 * Date: 8/1/13
 * Time: 1:11 PM
 * To change this template use File | Settings | File Templates.
 */
@Entity
public class User {

    @Column(name = "ID", nullable = false)
    @Basic(fetch = FetchType.EAGER)
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "FIRST_NAME", nullable = true)
    @Basic(fetch = FetchType.EAGER)
    private String firstName;

    @Column(name = "LAST_NAME", nullable = true)
    @Basic(fetch = FetchType.EAGER)
    private String lastName;

    @Column(name = "EMAIL", nullable = false, unique = true)
    @Basic(fetch = FetchType.EAGER)
    private String email;

    @Column(name = "PASSWORD", nullable = false)
    @Basic(fetch = FetchType.EAGER)
    private String password;



    public User(){

    }

    public User(String email, String password){
        new User();
        this.email = email;
        this.password = password;

    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }



    public void setPassword(String password) {
        this.password = password;
    }


}
