package com.ranga.mapper;

import com.ranga.domain.entity.ECaptain;
import com.ranga.model.Captain;

import java.util.function.BiFunction;
import java.util.function.Function;

/**
 * Created by jabbars on 2/26/2017.
 */
public class CaptainMapper {

    public static Function<ECaptain, Captain> entity = new Function<ECaptain, Captain>() {

        @Override
        public Captain apply(ECaptain captain) {
            return new Captain.Builder()
                    .uuid(captain.getUuid().toString())
                    .type(captain.getType())
                    .contact(ContactMapper.entity.apply(captain.getContact()))
                    .name(captain.getName())
                    .build();
        }
    };

    public static Function<Captain, ECaptain> model = new Function<Captain, ECaptain>() {

        @Override
        public ECaptain apply(Captain captain) {
            return new ECaptain(
                    captain.getName(),
                    ContactMapper.model.apply(captain.getContact()),
                    captain.getType(),
                    captain.getRegistrationId(),
                    captain.getCompany()
            );
        }
    };

    public static BiFunction<Captain, ECaptain, ECaptain> update = new BiFunction<Captain, ECaptain, ECaptain>() {
        @Override
        public ECaptain apply(Captain updated, ECaptain dbCaptain) {
            dbCaptain.setCompany(updated.getCompany());
            dbCaptain.setName(updated.getName());
            dbCaptain.setRegistrationId(updated.getRegistrationId());
            dbCaptain.setType(updated.getType());
            // Contact need to updtae
            return dbCaptain;
        }
    };
}
