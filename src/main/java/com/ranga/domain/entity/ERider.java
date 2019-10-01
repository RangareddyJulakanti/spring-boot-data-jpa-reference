package com.ranga.domain.entity;

import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * Created by RANGA on 1/10/2019.
 */
@Entity
@Table(name = "RIDER")
public class ERider extends EUser {

    // Some More details


    public ERider() {

    }

    public ERider(String name, EContact contact) {
        super(name, contact);
    }
}
