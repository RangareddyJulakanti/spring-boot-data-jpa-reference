package com.ranga.rest.crud;

import com.ranga.model.Captain;
import com.ranga.service.operations.crud.CaptainCrudOperations;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.inject.Inject;
import java.util.UUID;

/**
 * Created by RANGA on 2/26/2017.
 */
@RestController("CaptainCrudResource")
@RequestMapping(value = "v1/api/captain")
public class CaptainCrudResource extends BaseResource<Captain,UUID> {

    CaptainCrudOperations captainOperations;


    @Inject
    public CaptainCrudResource(CaptainCrudOperations captainOperations) {
        super(captainOperations);
        this.captainOperations = captainOperations;
    }
}
