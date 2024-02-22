package com.meet5.task.repository;

import com.meet5.task.model.Interaction;
import com.meet5.task.model.UserProfile;
import org.springframework.data.jdbc.repository.query.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface InteractionRepository extends CrudRepository<Interaction, Integer> {

    @Query(value = "SELECT DISTINCT UP.*, MAX(I.INTERACTION_DATE) FROM USER_PROFILE UP " +
            "JOIN INTERACTION I ON UP.ID = I.SRC_USER_PROFILE_ID " +
            "WHERE I.DEST_USER_PROFILE_ID = :userId AND I.INTERACTION_TYPE = 'VISIT' " +
            "GROUP BY UP.ID ORDER BY MAX(I.INTERACTION_DATE) DESC, UP.ID;")
    List<UserProfile> getAllVisitors(Integer userId);
}
