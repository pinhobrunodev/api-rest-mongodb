package com.pinhobrunodev.workshopmongo.models.dto;

import com.pinhobrunodev.workshopmongo.models.embedded.Author;
import com.pinhobrunodev.workshopmongo.models.embedded.Comment;

import java.time.Instant;

public class CommentDTO {

    private String text;
    private Instant moment;
    private Author author;


    public CommentDTO(){

    }

    public CommentDTO(Comment comment){
        text = comment.getText();
        moment = comment.getMoment();
        author = comment.getAuthor();
    }


    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public Instant getMoment() {
        return moment;
    }

    public void setMoment(Instant moment) {
        this.moment = moment;
    }

    public Author getAuthor() {
        return author;
    }

    public void setAuthor(Author author) {
        this.author = author;
    }
}
