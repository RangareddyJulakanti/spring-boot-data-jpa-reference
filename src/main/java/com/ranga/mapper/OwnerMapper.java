package com.ranga.mapper;

import com.ranga.domain.entity.EOwner;
import com.ranga.model.Owner;

import java.util.function.BiFunction;
import java.util.function.Function;

/**
 * Created by jabbars on 2/26/2017.
 */
public class OwnerMapper {


    public static Function<EOwner, Owner> entity = new Function<EOwner, Owner>() {

        @Override
        public Owner apply(EOwner captain) {
            return new Owner.Builder()
                    .uuid(captain.getUuid().toString())
                    .type(captain.getType())
                    .contact(ContactMapper.entity.apply(captain.getContact()))
                    .name(captain.getName())
                    .build();
        }
    };

    public static Function<Owner, EOwner> model = new Function<Owner, EOwner>() {

        @Override
        public EOwner apply(Owner captain) {
            return new EOwner(
                    captain.getName(),
                    ContactMapper.model.apply(captain.getContact()),
                    captain.getType(),
                    captain.getRegistrationId(),
                    captain.getCompany()
            );
        }
    };

    public static BiFunction<Owner, EOwner, EOwner> update = new BiFunction<Owner, EOwner, EOwner>() {
        @Override
        public EOwner apply(Owner updated, EOwner dbOwner) {
            dbOwner.setCompany(updated.getCompany());
            dbOwner.setName(updated.getName());
            dbOwner.setRegistrationId(updated.getRegistrationId());
            dbOwner.setType(updated.getType());
            // Contact need to updtae
            return dbOwner;
        }
    };
}
