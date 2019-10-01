package com.ranga.domain.repository;

import com.ranga.domain.entity.ERider;
import org.springframework.stereotype.Repository;

import java.util.UUID;

/**
 * Created by jabbars on 2/26/2017.
 */
@Repository
public interface RiderRepository extends BaseRepository<ERider,UUID> {
}
