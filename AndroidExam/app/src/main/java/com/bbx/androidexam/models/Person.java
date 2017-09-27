package com.bbx.androidexam.models;

import com.bluelinelabs.logansquare.annotation.JsonField;
import com.bluelinelabs.logansquare.annotation.JsonObject;

import java.io.Serializable;

/**
 * Created by macbookair on 27/09/2017.
 */

@JsonObject
public class Person implements Serializable{

    @JsonField
    private int id;
    @JsonField(name = "first_name")
    private String firstname;
    @JsonField(name = "last_name")
    private String lastname;
    @JsonField(name = "birth_date")
    private String birthdate;
    @JsonField
    private String email;
    @JsonField
    private String mobile;
    @JsonField
    private String address;
    @JsonField(name = "contact_person")
    private String contactperson;
    @JsonField(name = "cp_number")
    private String contactpnumber;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public String getBirthdate() {
        return birthdate;
    }

    public void setBirthdate(String birthdate) {
        this.birthdate = birthdate;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getContactperson() {
        return contactperson;
    }

    public void setContactperson(String contactperson) {
        this.contactperson = contactperson;
    }

    public String getContactpnumber() {
        return contactpnumber;
    }

    public void setContactpnumber(String contactpnumber) {
        this.contactpnumber = contactpnumber;
    }


}
