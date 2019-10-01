package com.ranga.domain.repository;

import com.ranga.domain.entity.ECaptain;
import org.springframework.stereotype.Repository;

import java.util.UUID;

/**
 * Created by RANGA on 2/26/2017.
 */
@Repository
public interface CaptainRepository extends BaseRepository<ECaptain,UUID>{
}
