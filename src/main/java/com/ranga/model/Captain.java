package com.ranga.model;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonPOJOBuilder;

/**
 * Created by jabbars on 2/25/2017.
 */
@JsonDeserialize(builder = Captain.Builder.class)
public class Captain extends Cab{


    public Captain(Builder builder) {
        super(builder);
    }

    @JsonPOJOBuilder(buildMethodName = "build", withPrefix = "")
    public static class Builder extends Cab.Builder2<Captain, Builder> {
        @Override
        public Builder self() {
            return this;
        }

        @Override
        public Captain build() {
            self().userType(UserType.CAPTAIN);
            return new Captain(self());
        }
    }


}
