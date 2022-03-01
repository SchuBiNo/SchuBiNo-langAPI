package de.schubino.languageAPI;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.ArrayList;
import java.util.List;

import org.languagetool.JLanguageTool;
import org.languagetool.Language;
import org.languagetool.language.*;
import org.languagetool.rules.*;

import java.io.IOException;

import de.schubino.languageAPI.Suggestion;
import de.schubino.languageAPI.LanguageResponse;
import de.schubino.languageAPI.Payload;

@RestController
@RequestMapping("/api/v1/language/check")
public class LanguageController {
    

    
    @PostMapping("/en")
    public LanguageResponse en(@RequestBody com.fasterxml.jackson.databind.JsonNode payload) throws IOException {
        return new LanguageResponse("en", getSuggestions(new BritishEnglish(), payload.get("text").asText()));    
    }

    @PostMapping("/de")
    public LanguageResponse de(@RequestBody com.fasterxml.jackson.databind.JsonNode payload) throws IOException {
        return new LanguageResponse("de", getSuggestions(new GermanyGerman(), payload.get("text").asText()));
    }

    @PostMapping("/es")
    public LanguageResponse es(@RequestBody com.fasterxml.jackson.databind.JsonNode payload) throws IOException {
        return new LanguageResponse("es", getSuggestions(new Spanish(), payload.get("text").asText()));
    }

    @PostMapping("/fr")
    public LanguageResponse fr(@RequestBody com.fasterxml.jackson.databind.JsonNode payload) throws IOException {
        return new LanguageResponse("fr", getSuggestions(new French(), payload.get("text").asText()));
    }

    @PostMapping("/it")
    public LanguageResponse it(@RequestBody com.fasterxml.jackson.databind.JsonNode payload) throws IOException {
        return new LanguageResponse("it", getSuggestions(new Italian(), payload.get("text").asText()));
    }

    @PostMapping("/nl")
    public LanguageResponse nl(@RequestBody com.fasterxml.jackson.databind.JsonNode payload) throws IOException {
        return new LanguageResponse("nl", getSuggestions(new Dutch(), payload.get("text").asText()));
    }

    @PostMapping("/pt")
    public LanguageResponse pt(@RequestBody com.fasterxml.jackson.databind.JsonNode payload) throws IOException {
        return new LanguageResponse("pt", getSuggestions(new Portuguese(), payload.get("text").asText()));
    }

    @PostMapping("/ru")
    public LanguageResponse ru(@RequestBody com.fasterxml.jackson.databind.JsonNode payload) throws IOException {
        return new LanguageResponse("ru", getSuggestions(new Russian(), payload.get("text").asText()));
    }

    @PostMapping("/zh")
    public LanguageResponse zh(@RequestBody com.fasterxml.jackson.databind.JsonNode payload) throws IOException {
        return new LanguageResponse("zh", getSuggestions(new Chinese(), payload.get("text").asText()));
    }

    

    private List<Suggestion> getSuggestions(Language lang, String text) {
        try {
            JLanguageTool langTool = new JLanguageTool(lang);
            List<RuleMatch> matches = langTool.check(text);
            List<Suggestion> result = new ArrayList<>();
            for (RuleMatch match : matches) {
                Suggestion suggestion = new Suggestion(match.getFromPos(), match.getToPos(), match.getSuggestedReplacements(), match.getMessage());
                result.add(suggestion);
            }
            return result;

        } catch (IOException e) {
            e.printStackTrace();
            return(null);
        }
    }
}




