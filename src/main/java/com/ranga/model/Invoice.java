package com.ranga.model;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonPOJOBuilder;

/**
 * Created by jabbars on 2/25/2017.
 */
@JsonDeserialize(builder = Invoice.Builder.class)
public class Invoice {

    private String id;
    private Double price;
    private String user;
    private Path path;

    public Invoice(Builder builder) {
        this.id = builder.id;
        this.price = builder.price;
        this.user = builder.user;
        this.path = builder.path;
    }

    public String getId() {
        return id;
    }

    public Double getPrice() {
        return price;
    }

    public String getUser() {
        return user;
    }

    public Path getPath() {
        return path;
    }

    @JsonPOJOBuilder(withPrefix = "",buildMethodName = "build")
    public static class  Builder{

        private String id;
        private Double price;
        private String user;
        private Path path;

        public Builder id(String id) {
            this.id = id;
            return this;
        }

        public Builder price(Double price) {
            this.price = price;
            return this;
        }

        public Builder uer(String user) {
            this.user = user;
            return this;
        }

        public Builder path(Path path) {
            this.path = path;
            return this;
        }
    }

    @Override
    public String toString() {
        return "Invoice{" +
                "id='" + id + '\'' +
                ", price=" + price +
                ", user='" + user + '\'' +
                ", path=" + path +
                '}';
    }
}
