package com.ranga.domain.entity;

import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * Created by RANGA on 1/10/2019.
 */
@Entity
@Table(name ="CAPTAIN" )
public class ECaptain extends ECab {

    public ECaptain() {
    }

    public ECaptain(String name, EContact contact, String type, String registrationId, String company) {
        super(name, contact, type, registrationId, company);
    }


}
