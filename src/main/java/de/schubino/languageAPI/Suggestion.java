package de.schubino.languageAPI;

import java.util.List;

public class Suggestion{

    private int startPos;
    private int endPos;
    private List<String> replacement;
    private String message;

    public Suggestion(int startPos, int endPos, List<String> replacement, String message) {
        this.startPos = startPos;
        this.endPos = endPos;
        this.replacement = replacement;
        this.message = message;
    }

    public int getStartPos() {
        return startPos;
    }

    public void setStartPos(int startPos) {
        this.startPos = startPos;
    }

    public int getEndPos() {
        return endPos;
    }

    public void setEndPos(int endPos) {
        this.endPos = endPos;
    }

    public List<String> getReplacement() {
        return replacement;
    }

    public void setReplacement(List<String> replacement) {
        this.replacement = replacement;
    }

    public void addReplacement(String replacement) {
        this.replacement.add(replacement);
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    @Override
    public String toString() {
        return "Suggestion{" +
                "startPos=" + startPos +
                ", endPos=" + endPos +
                ", replacement=" + replacement +
                ", message='" + message + '\'' +
                '}';
    }


} 
