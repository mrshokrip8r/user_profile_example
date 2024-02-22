package com.meet5.task.controller;

import com.meet5.task.exception.InteractionException;
import com.meet5.task.model.Interaction;
import com.meet5.task.model.InteractionType;
import com.meet5.task.model.UserProfile;
import com.meet5.task.service.InteractionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
public class UserProfileController {

    @Autowired
    InteractionService interactionService;

    @GetMapping("/allVisitors/{id}")
    public Iterable<UserProfile> getAllVisitors(@PathVariable Integer id) {
        return interactionService.getAllVisitors(id);
    }

    @GetMapping("/user/visit")
    public ResponseEntity<?> visit(@RequestParam Integer sourceId, @RequestParam Integer destinationId) {
        try {
            interactionService.validation(sourceId, destinationId);
            Interaction interaction = interactionService.interaction(sourceId, destinationId, InteractionType.VISIT);
            return new ResponseEntity<>(interaction, HttpStatus.CREATED);
        } catch (InteractionException e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping("/user/like")
    public ResponseEntity<?> like(@RequestParam Integer sourceId, @RequestParam Integer destinationId) {
        try {
            interactionService.validation(sourceId, destinationId);
            Interaction interaction = interactionService.interaction(sourceId, destinationId, InteractionType.VISIT);
            return new ResponseEntity<>(interaction, HttpStatus.CREATED);
        } catch (InteractionException e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }
}
