package com.pinhobrunodev.workshopmongo.models.dto;

import com.pinhobrunodev.workshopmongo.models.embedded.Author;
import com.pinhobrunodev.workshopmongo.models.embedded.Comment;
import com.pinhobrunodev.workshopmongo.models.entities.Post;

import java.time.Instant;
import java.util.ArrayList;
import java.util.List;

public class PostDTO {

    private String id;
    private Instant moment;
    private String title;
    private String body;
    private Author author;
    private List<CommentDTO> comments = new ArrayList<>();

    public PostDTO() {
    }


    public PostDTO(Post entity){
        id = entity.getId();
        moment = entity.getMoment();
        title = entity.getTitle();
        body = entity.getBody();
        author = entity.getAuthor();
        entity.getComments().forEach(x->comments.add(new CommentDTO(x)));
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Instant getMoment() {
        return moment;
    }

    public void setMoment(Instant moment) {
        this.moment = moment;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }

    public Author getAuthor() {
        return author;
    }

    public void setAuthor(Author author) {
        this.author = author;
    }

    public List<CommentDTO> getComments() {
        return comments;
    }

}
