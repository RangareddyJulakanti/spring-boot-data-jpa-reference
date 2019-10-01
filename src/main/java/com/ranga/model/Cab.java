package com.ranga.model;

/**
 * Created by RANGA on 1/10/2019.
 */
public abstract class Cab extends User{

    private String type;
    private String registrationId;
    private String company;

    public Cab(Builder2 builder) {
        super(builder);
        this.type = builder.type;
        this.registrationId = builder.registrationId;
        this.company = builder.company;
    }

    public String getType() {
        return type;
    }

    public String getRegistrationId() {
        return registrationId;
    }

    public String getCompany() {
        return company;
    }

    public abstract static class Builder2<C extends Cab, B extends Builder2> extends User.Builder2<C, B> {

        private String type;
        private String registrationId;
        private String company;

        public B type(String type) {
            this.type = type;
            return self();
        }

        public B registrationId(String registrationId) {
            this.registrationId = registrationId;
            return self();
        }

        public B company(String company) {
            this.company = company;
            return self();
        }
    }

    @Override
    public String toString() {
        return "Cab{" +
                "type='" + type + '\'' +
                ", registrationId='" + registrationId + '\'' +
                ", company='" + company + '\'' +
                '}';
    }
}
