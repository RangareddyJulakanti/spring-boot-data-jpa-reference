package com.ranga.model;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonPOJOBuilder;

/**
 * Created by jabbars on 2/25/2017.
 */
@JsonDeserialize(builder = Rider.Builder.class)
public class Rider extends User{


    public Rider(Builder builder) {
        super(builder);
    }

    @JsonPOJOBuilder(buildMethodName = "build", withPrefix = "")
    public static class Builder extends User.Builder2<Rider, Builder> {

        @Override
        public Builder self() {
            return this;
        }
        @Override
        public Rider build() {
            self().userType(UserType.RIDER);
            return new Rider(self());
        }
    }
}
