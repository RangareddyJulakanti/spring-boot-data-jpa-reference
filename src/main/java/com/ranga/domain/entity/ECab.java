package com.ranga.domain.entity;

import javax.persistence.Column;
import javax.persistence.MappedSuperclass;

/**
 * Created by ANGA on 1/10/2019.
 */
@MappedSuperclass
public abstract class ECab extends EUser {

    @Column(name = "CAR_TYPE")
    private String type;

    @Column(name = "REGISTRATION_ID")
    private String registrationId;

    @Column(name = "CAR_COMPANY")
    private String company;
    // Some other Details


    public ECab() {
    }

    public ECab(String name, EContact contact, String type, String registrationId, String company) {
        super(name, contact);
        this.type = type;
        this.registrationId = registrationId;
        this.company = company;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getRegistrationId() {
        return registrationId;
    }

    public void setRegistrationId(String registrationId) {
        this.registrationId = registrationId;
    }

    public String getCompany() {
        return company;
    }

    public void setCompany(String company) {
        this.company = company;
    }
}
