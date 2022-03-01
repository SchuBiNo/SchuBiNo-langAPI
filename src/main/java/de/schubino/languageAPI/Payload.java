package de.schubino.languageAPI;

public class Payload {
    private String text;

    public Payload(String text) {
        this.text = text;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }
}
