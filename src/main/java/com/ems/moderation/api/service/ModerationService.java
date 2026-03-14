package com.ems.moderation.api.service;

import com.ems.moderation.api.model.ModerationInput;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ModerationService {

    public boolean checkNotAllowedWords(ModerationInput moderationInput) {

        List<String> notAllowedWords = new ArrayList<>();
        notAllowedWords.add("odio");
        notAllowedWords.add("xingamento");

        return notAllowedWords.stream().noneMatch(moderationInput.getText()::contains);
    }
}
