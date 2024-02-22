package com.meet5.task;

import com.meet5.task.model.GenderType;
import com.meet5.task.model.RelationshipStatus;
import com.meet5.task.model.UserProfile;
import com.meet5.task.repository.InteractionRepository;
import com.meet5.task.repository.UserProfileRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.Arrays;
import java.util.List;

@SpringBootApplication
public class TaskApplication {

    public static void main(String[] args) {
        SpringApplication.run(TaskApplication.class, args);
    }

    @Bean
    CommandLineRunner commandLineRunner(UserProfileRepository userProfileRepository, InteractionRepository interactionRepository) {
        return args -> {
            UserProfile userProfile1 = new UserProfile();
            userProfile1.setName("Martin");
            userProfile1.setAge(25);
            userProfile1.setJob("Football Player");
            userProfile1.setLocation("London");
            userProfile1.setGender(GenderType.MALE);
            userProfile1.setRelationshipStatus(RelationshipStatus.MARRIED);

            UserProfile userProfile2 = new UserProfile();
            userProfile2.setName("Patrik");
            userProfile2.setAge(33);
            userProfile2.setJob("Software Developer");
            userProfile2.setLocation("Spain, Madrid");
            userProfile2.setGender(GenderType.OTHER);
            userProfile2.setRelationshipStatus(RelationshipStatus.OTHER);

            UserProfile userProfile3 = new UserProfile();
            userProfile3.setName("Julia");
            userProfile3.setAge(28);
            userProfile3.setJob("English Teacher");
            userProfile3.setLocation("Germany");
            userProfile3.setGender(GenderType.FEMALE);
            userProfile3.setRelationshipStatus(RelationshipStatus.SINGLE);

            UserProfile userProfile4 = new UserProfile();
            userProfile4.setName("Lando");
            userProfile4.setAge(20);
            userProfile4.setJob("Driver");
            userProfile4.setLocation("Rome, Italy");
            userProfile4.setGender(GenderType.MALE);
            userProfile4.setRelationshipStatus(RelationshipStatus.SINGLE);

            List<UserProfile> userProfiles = Arrays.asList(userProfile1, userProfile2, userProfile3, userProfile4);
            userProfileRepository.saveAll(userProfiles);
        };
    }

}
