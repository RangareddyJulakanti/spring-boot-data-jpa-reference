package com.ranga.service.impl.crud;

import com.ranga.domain.repository.BaseRepository;
import com.ranga.exception.NotFoundException;
import com.ranga.service.impl.BaseEntityValidator;
import com.ranga.service.operations.crud.BaseCrudOperations;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.ObjectUtils;
import org.springframework.validation.annotation.Validated;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.util.List;
import java.util.function.BiFunction;
import java.util.function.Function;
import java.util.stream.Collectors;

/**
 * Common Operations are performed in this class
 * <p>
 * Created by jabbars on 1/31/2017.
 */
@Validated
public abstract class BaseCrudTemplate<M, E, ID extends Serializable>
        implements BaseCrudOperations<M, ID> {

    Logger LOGGER = LoggerFactory.getLogger(BaseCrudTemplate.class);

    protected BaseRepository<E, ID> baseRepository;
    protected Function<E, M> modelMapper;
    protected Function<M, E> entityMapper;
    protected BiFunction<M, E, E> updateMapper;
    protected BaseEntityValidator<M> baseEntityValidator;

    public BaseCrudTemplate(BaseRepository<E, ID> baseRepository,
                            Function<E, M> modelMapper,
                            Function<M, E> entityMapper,
                            BiFunction<M, E, E> updateMapper,
                            BaseEntityValidator<M> baseEntityValidator) {
        this.baseRepository = baseRepository;
        this.modelMapper = modelMapper;
        this.entityMapper = entityMapper;
        this.updateMapper = updateMapper;
        this.baseEntityValidator = baseEntityValidator;
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRED)
    public M create(@Valid M request) {
        E entity = entityMapper.apply(request);
        entity = baseRepository.save(entity);
        return modelMapper.apply(entity);
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRED)
    public M update(@NotNull ID id, @Valid M request) {
        E entity = findOne(id);
        entity = updateMapper.apply(request, entity);
        entity = baseRepository.save(entity);
        return modelMapper.apply(entity);
    }

    @Override
    @Transactional(propagation = Propagation.SUPPORTS)
    public List<M> findAll() {
        List<E> result = baseRepository.findAll();
        return result.stream().map(modelMapper)
                .collect(Collectors.toList());
    }

    @Override
    @Transactional(propagation = Propagation.SUPPORTS)
    public M find(@NotNull ID id) {
        E entity = findOne(id);
        return modelMapper.apply(entity);
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRED)
    public void delete(@NotNull ID id) {
        findOne(id);
        baseRepository.delete(id);
    }


    protected E findOne(ID id) {
        E entity = baseRepository.findOne(id);
        if (ObjectUtils.isEmpty(entity)) {
            throw new NotFoundException("Given User with ID " + id + "Not exist, Please Provide Valid data");
        }
        return entity;
    }
}
