package com.ranga.domain.entity;

import javax.persistence.Column;
import javax.persistence.Embeddable;

/**
 * Created by RANGA on 1/10/2019.
 */
@Embeddable
public class EContact {

    @Column(name = "COUNTRY_CODE")
    private String countryCode;

    @Column(name = "ZIP_CODE")
    private String zipCode;

    @Column(name = "PHONE")
    private Long phone;

    @Column(name = "CITY")
    private String city;

    @Column(name = "STATE")
    private String state;

    public EContact() {
    }

    public EContact(String countryCode, String zipCode, Long phone, String city, String state) {
        this.countryCode = countryCode;
        this.zipCode = zipCode;
        this.phone = phone;
        this.city = city;
        this.state = state;
    }

    public String getCountryCode() {
        return countryCode;
    }

    public void setCountryCode(String countryCode) {
        this.countryCode = countryCode;
    }

    public String getZipCode() {
        return zipCode;
    }

    public void setZipCode(String zipCode) {
        this.zipCode = zipCode;
    }

    public Long getPhone() {
        return phone;
    }

    public void setPhone(Long phone) {
        this.phone = phone;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }
}
