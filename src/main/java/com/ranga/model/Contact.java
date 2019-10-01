package com.ranga.model;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonPOJOBuilder;

/**
 * Created by RANGA on 2/26/2017.
 */
@JsonDeserialize(builder = Contact.Builder.class)
public class Contact {

    private String countryCode;

    private String zipCode;

    private Long phone;

    private String city;

    private String state;

    public Contact(Builder builder) {
        this.countryCode = builder.countryCode;
        this.zipCode = builder.zipCode;
        this.phone = builder.phone;
        this.city = builder.city;
        this.state = builder.state;
    }

    public String getCountryCode() {
        return countryCode;
    }

    public String getZipCode() {
        return zipCode;
    }

    public Long getPhone() {
        return phone;
    }

    public String getCity() {
        return city;
    }

    public String getState() {
        return state;
    }

    @JsonPOJOBuilder(withPrefix = "", buildMethodName = "build")
    public static class Builder {

        private String countryCode;
        private String zipCode;
        private Long phone;
        private String city;
        private String state;

        public Builder countryCode(String countryCode) {
            this.countryCode = countryCode;
            return this;
        }

        public Builder zipCode(String zipCode) {
            this.zipCode = zipCode;
            return this;
        }

        public Builder phone(Long phone) {
            this.phone = phone;
            return this;
        }

        public Builder city(String city) {
            this.city = city;
            return this;
        }

        public Builder state(String state) {
            this.state = state;
            return this;
        }
        public Contact build(){
            return new Contact(this);
        }
    }

}
