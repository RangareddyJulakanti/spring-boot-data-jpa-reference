package com.ranga.mapper;

import com.ranga.domain.entity.EContact;
import com.ranga.model.Contact;

import java.util.function.Function;

/**
 * Created by RANGA on 2/26/2017.
 */
public class ContactMapper {

    public static Function<EContact, Contact> entity = new Function<EContact, Contact>() {

        @Override
        public Contact apply(EContact dbContact) {
            return new Contact.Builder()
                    .city(dbContact.getCity())
                    .countryCode(dbContact.getCountryCode())
                    .state(dbContact.getState())
                    .zipCode(dbContact.getZipCode())
                    .phone(dbContact.getPhone())
                    .build();
        }
    };

    public static Function<Contact, EContact> model = new Function<Contact, EContact>() {

        @Override
        public EContact apply(Contact contact) {
            return new EContact(
                    contact.getCountryCode(),
                    contact.getZipCode(),
                    contact.getPhone(),
                    contact.getCity(),
                    contact.getState()
            );
        }
    };

}
