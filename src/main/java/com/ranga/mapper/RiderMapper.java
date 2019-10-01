package com.ranga.mapper;

import com.ranga.domain.entity.ERider;
import com.ranga.model.Rider;

import java.util.function.BiFunction;
import java.util.function.Function;

/**
 * Created by jabbars on 2/26/2017.
 */
public class RiderMapper {

    public static Function<ERider, Rider> entity = new Function<ERider, Rider>() {

        @Override
        public Rider apply(ERider captain) {
            return new Rider.Builder()
                    .uuid(captain.getUuid().toString())
                    .contact(ContactMapper.entity.apply(captain.getContact()))
                    .name(captain.getName())
                    .build();
        }
    };

    public static Function<Rider, ERider> model = new Function<Rider, ERider>() {

        @Override
        public ERider apply(Rider rider) {
            return new ERider(
                    rider.getName(),
                    ContactMapper.model.apply(rider.getContact())
            );
        }
    };

    public static BiFunction<Rider, ERider, ERider> update = new BiFunction<Rider, ERider, ERider>() {
        @Override
        public ERider apply(Rider updated, ERider dbRider) {
            dbRider.setName(updated.getName());
            // Contact need to updtae            
            return dbRider;
        }
    };

}
