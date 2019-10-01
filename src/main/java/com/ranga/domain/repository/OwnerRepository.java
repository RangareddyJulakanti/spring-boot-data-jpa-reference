package com.ranga.domain.repository;

import com.ranga.domain.entity.EOwner;
import org.springframework.stereotype.Repository;

import java.util.UUID;

/**
 * Created by RANGA on 2/26/2017.
 */
@Repository
public interface OwnerRepository extends BaseRepository<EOwner,UUID> {
}
