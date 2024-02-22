package com.meet5.task.service;

import com.meet5.task.exception.InteractionException;
import com.meet5.task.model.Fraudulent;
import com.meet5.task.model.Interaction;
import com.meet5.task.model.InteractionType;
import com.meet5.task.model.UserProfile;
import com.meet5.task.repository.FraudulentRepository;
import com.meet5.task.repository.InteractionRepository;
import com.meet5.task.repository.UserProfileRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jdbc.core.mapping.AggregateReference;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
public class InteractionService {

    @Autowired
    private UserProfileRepository userProfileRepository;
    @Autowired
    private InteractionRepository interactionRepository;
    @Autowired
    private FraudulentRepository fraudulentRepository;


    public Iterable<UserProfile> getAllVisitors(Integer id) {
        return interactionRepository.getAllVisitors(id);
    }

    public void validation(Integer sourceId, Integer destinationId) throws InteractionException {

        if (fraudulentRepository.findByUserId(sourceId).isPresent()) {
            throw new InteractionException("User with ID = " + sourceId + " is in the black list!");
        } else if (fraudulentRepository.isFraudulent(sourceId)) {
            Fraudulent fraudulent = new Fraudulent();
            fraudulent.setUserProfileId(AggregateReference.to(sourceId));
            fraudulent.setCreationDate(new Date());
            fraudulentRepository.save(fraudulent);
            throw new InteractionException("Fraud detected for user with ID = " + sourceId + "!");
        }

        if (sourceId.equals(destinationId)) {
            throw new InteractionException("Invalid Interaction!");
        }
    }

    public Interaction interaction(Integer sourceId, Integer destinationId, InteractionType interactionType) {
        Interaction interaction = new Interaction();
        interaction.setInteractionDate(new Date());
        interaction.setInteractionType((interactionType.equals(InteractionType.VISIT) ? InteractionType.VISIT : InteractionType.LIKE));
        interaction.setSrcUserProfileId(AggregateReference.to(sourceId));
        interaction.setDestUserProfileId(AggregateReference.to(destinationId));
        return interactionRepository.save(interaction);
    }

}
