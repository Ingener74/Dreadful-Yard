package ru.venusgames.pavel.dreadfulyard.database;

// THIS CODE IS GENERATED BY greenDAO, DO NOT EDIT. Enable "keep" sections if you want to edit. 
/**
 * Entity mapped to table "PHONE_NUMBER".
 */
public class PhoneNumber {

    private Long id;
    private String phoneNumber;

    public PhoneNumber() {
    }

    public PhoneNumber(Long id) {
        this.id = id;
    }

    public PhoneNumber(Long id, String phoneNumber) {
        this.id = id;
        this.phoneNumber = phoneNumber;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

}
