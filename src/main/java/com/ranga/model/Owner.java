package com.ranga.model;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonPOJOBuilder;

/**
 * Created by jabbars on 2/25/2017.
 */
@JsonDeserialize(builder = Owner.Builder.class)
public class Owner extends Cab {

    public Owner(Owner.Builder builder) {
        super(builder);
    }

    @JsonPOJOBuilder(buildMethodName = "build", withPrefix = "")
    public static class Builder extends Cab.Builder2<Owner, Builder> {
        @Override
        public Builder self() {
            return this;
        }

        @Override
        public Owner build() {
            self().userType(UserType.OWNER);
            return new Owner(self());
        }
    }

}
