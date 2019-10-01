package com.ranga.model;

import com.fasterxml.jackson.databind.annotation.JsonPOJOBuilder;

/**
 * Created by jabbars on 2/25/2017.
 */
public abstract class User {


    private UserType userType;
    private String uuid;
    private String name;
    private Contact contact;


    public User(Builder2 builder) {
        this.userType = builder.userType;
        this.uuid = builder.uuid;
        this.name = builder.name;
        this.contact = builder.contact;
    }


    public UserType getUserType() {
        return userType;
    }

    public String getUuid() {
        return uuid;
    }

    public String getName() {
        return name;
    }

    public Contact getContact() {
        return contact;
    }
    @JsonPOJOBuilder(buildMethodName = "build", withPrefix = "")
    public static class Builder extends Builder2<User, Builder> {
        public Builder self() {
            return this;
        }

        public User build() {
            return new User(this) {
            };
        }
    }

    @JsonPOJOBuilder(buildMethodName = "build", withPrefix = "")
    public abstract static class Builder2<U extends User, B extends Builder2> {


        private String uuid;
        UserType userType;
        private String name;
        private Contact contact;

        protected abstract B self();

        public B uuid(String uuid) {
            this.uuid = uuid;
            return self();
        }

        public B userType(UserType userType) {
            this.userType = userType;
            return self();
        }

        public B name(String name) {
            this.name = name;
            return self();
        }

        public B contact(Contact contact) {
            this.contact = contact;
            return self();
        }

        public abstract U build();
    }
}
