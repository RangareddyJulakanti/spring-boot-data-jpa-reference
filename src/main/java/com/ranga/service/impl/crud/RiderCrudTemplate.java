package com.ranga.service.impl.crud;

import com.ranga.domain.entity.ERider;
import com.ranga.domain.repository.RiderRepository;
import com.ranga.mapper.RiderMapper;
import com.ranga.model.Rider;
import com.ranga.service.impl.BaseEntityValidator;
import com.ranga.service.operations.crud.RiderCrudOperations;

import javax.inject.Inject;
import javax.inject.Named;
import java.util.UUID;

/**
 * Created by RANGA on 2/26/2017.
 */
@Named("RiderCrudTemplate")
public class RiderCrudTemplate extends BaseCrudTemplate<Rider, ERider, UUID> implements RiderCrudOperations {

    private RiderRepository riderRepository;

    @Inject
    public RiderCrudTemplate(BaseEntityValidator<Rider> baseEntityValidator,
                             RiderRepository riderRepository) {
        super(riderRepository, RiderMapper.entity, RiderMapper.model, RiderMapper.update, baseEntityValidator);
        this.riderRepository = riderRepository;
    }
}
