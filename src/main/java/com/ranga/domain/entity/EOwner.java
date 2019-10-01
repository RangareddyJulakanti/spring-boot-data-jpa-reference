package com.ranga.domain.entity;

import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * Created by jabbars on 2/25/2017.
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
