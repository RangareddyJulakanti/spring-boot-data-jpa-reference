package com.ranga.domain.entity;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.UUID;

/**
 * Created by jabbars on 2/25/2017.
 */
@MappedSuperclass
public abstract class EUser{


    @Id
    @GeneratedValue(generator = "uuid2")
    @GenericGenerator(name = "uuid2", strategy = "uuid2")
    @Column(columnDefinition = "CHAR(32)")
    private UUID uuid;

    @Column(name = "name")
    private String name;

    @Embedded
    private EContact contact;

    @Version
    @Column(name = "version")
    private Long version;

    public EUser() {
    }

    public EUser(String name, EContact contact) {
        this.name = name;
        this.contact = contact;
    }

    public UUID getUuid() {
        return uuid;
    }

    public void setUuid(UUID uuid) {
        this.uuid = uuid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public EContact getContact() {
        return contact;
    }

    public void setContact(EContact contact) {
        this.contact = contact;
    }

    public Long getVersion() {
        return version;
    }

    public void setVersion(Long version) {
        this.version = version;
    }
}
