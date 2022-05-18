package com.epam.ta.model;

import java.util.Objects;

public class Mail {

    private String to;
    private String subject;
    private String text;


    public Mail(String to, String subject, String text) {
        this.to = to;
        this.subject = subject;
        this.text = text;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public String getTo() {
        return to;
    }

    public void setTo(String to) {
        this.to = to;
    }

    @Override
    public String toString() {
        return "Mail{" +
                "to='" + to + '\'' +
                ", subject='" + subject + '\'' +
                ", text='" + text + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Mail)) return false;
        Mail mail = (Mail) o;
        return Objects.equals(getSubject(), mail.getSubject()) &&
                Objects.equals(getText(), mail.getText()) &&
                Objects.equals(getTo(), mail.getTo());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getTo() ,getSubject(), getText());
    }
}
