package com.ems.moderation.api.controller;

import com.ems.moderation.api.model.ModerationInput;
import com.ems.moderation.api.model.ModerationOutput;
import com.ems.moderation.api.service.ModerationService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/moderate")
@RequiredArgsConstructor
public class ModerationController {

    private final ModerationService moderationService;

    @PostMapping
    public ModerationOutput saveComment(@RequestBody ModerationInput commentInput) {

        boolean allowed = moderationService.checkNotAllowedWords(commentInput);
        return ModerationOutput.builder().approved(allowed).reason("OK").build();
    }
}
