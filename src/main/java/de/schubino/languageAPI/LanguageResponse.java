package de.schubino.languageAPI;

import de.schubino.languageAPI.Suggestion;
import java.util.List;

public class LanguageResponse {
    private String language;
    private List<Suggestion> suggestions;

    public LanguageResponse(String language, List<Suggestion> suggestions) {
        this.language = language;
        this.suggestions = suggestions;
    }

    public String getLanguage() {
        return language;
    }

    public void setLanguage(String language) {
        this.language = language;
    }

    public List<Suggestion> getSuggestions() {
        return suggestions;
    }

    public void setSuggestions(List<Suggestion> result) {
        this.suggestions = result;
    }

    @Override
    public String toString() {
        return "LanguageResponse{" +
                "language='" + language + '\'' +
                ", suggestions='" + suggestions + '\'' +
                '}';
    }

}

