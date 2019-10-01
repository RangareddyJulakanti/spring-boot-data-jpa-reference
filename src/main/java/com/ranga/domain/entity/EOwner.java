package com.ranga.domain.entity;

import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * Created by RANGA on 1/10/2019.
 */
@Entity
@Table(name = "OWNER")
public class EOwner extends ECab {

    // Owner specific Data can be added


    public EOwner() {
    }

    public EOwner(String name, EContact contact, String type, String registrationId, String company) {
        super(name, contact, type, registrationId, company);
    }

}
