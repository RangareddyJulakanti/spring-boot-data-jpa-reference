package com.ranga.service.operations.crud;

import org.springframework.validation.annotation.Validated;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import java.util.List;

/**
 * Created by RANGA on 1/10/2019.
 */
@Validated
public interface BaseCrudOperations<M,ID> {

    M create(@Valid M request);
    M update(@NotNull ID id,@Valid M request);

    List<M> findAll();
    M find(@NotNull ID id);

    void delete(@NotNull ID id);
}
