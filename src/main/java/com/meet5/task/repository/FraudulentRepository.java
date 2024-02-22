package com.meet5.task.repository;

import com.meet5.task.model.Fraudulent;
import org.springframework.data.jdbc.repository.query.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface FraudulentRepository extends CrudRepository<Fraudulent, Integer> {

    @Query(value = "SELECT * FROM FRAUDULENT F WHERE F.USER_PROFILE_ID = :userId;")
    Optional<Fraudulent> findByUserId(Integer userId);

    @Query(value = "SELECT COUNT(*) > 100 AS result FROM INTERACTION I WHERE I.SRC_USER_PROFILE_ID = :userId " +
            "AND I.INTERACTION_DATE >= CURRENT_TIMESTAMP - INTERVAL '10' MINUTE;")
    boolean isFraudulent(Integer userId);
}
