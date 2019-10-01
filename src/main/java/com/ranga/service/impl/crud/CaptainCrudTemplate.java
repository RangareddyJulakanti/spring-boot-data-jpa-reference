package com.ranga.service.impl.crud;

import com.ranga.domain.entity.ECaptain;
import com.ranga.domain.repository.CaptainRepository;
import com.ranga.mapper.CaptainMapper;
import com.ranga.model.Captain;
import com.ranga.service.impl.BaseEntityValidator;
import com.ranga.service.operations.crud.CaptainCrudOperations;

import javax.inject.Inject;
import javax.inject.Named;
import java.util.UUID;

/**
 * Created by RANGA on 2/26/2017.
 */
@Named("CaptainCrudTemplate")
public class CaptainCrudTemplate extends BaseCrudTemplate<Captain,ECaptain,UUID> implements CaptainCrudOperations{

    CaptainRepository captainRepository;

    @Inject
    public CaptainCrudTemplate(BaseEntityValidator<Captain> baseEntityValidator,
                               CaptainRepository captainRepository) {
        super(captainRepository, CaptainMapper.entity,  CaptainMapper.model,  CaptainMapper.update, baseEntityValidator);
        this.captainRepository = captainRepository;
    }

}
