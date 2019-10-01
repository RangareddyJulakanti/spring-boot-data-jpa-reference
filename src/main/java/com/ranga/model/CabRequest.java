package com.ranga.model;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonPOJOBuilder;

import java.time.ZonedDateTime;

/**
 * Created by jabbars on 2/25/2017.
 */
@JsonDeserialize(builder = CabRequest.Builder.class)
public class CabRequest {

    private String location;
    private ZonedDateTime requestTime;
    private String cabType;

    public CabRequest(Builder builder) {
        this.location = builder.location;
        this.requestTime = builder.requestTime;
        this.cabType = builder.cabType;
    }

    public String getLocation() {
        return location;
    }

    public ZonedDateTime getRequestTime() {
        return requestTime;
    }

    public String getCabType() {
        return cabType;
    }

    @JsonPOJOBuilder(withPrefix = "", buildMethodName = "build")
    public static class Builder {

        private String location;
        private ZonedDateTime requestTime;
        private String cabType;

        public Builder location(String location) {
            this.location = location;
            return this;
        }

        public Builder requestTime(ZonedDateTime requestTime) {
            this.requestTime = requestTime;
            return this;
        }

        public Builder cabType(String cabType) {
            this.cabType = cabType;
            return this;
        }

        public CabRequest build(){
            return new CabRequest(this);
        }
    }
}
