package com.tamseo.ws.model;

import javax.persistence.Entity;
import javax.validation.constraints.NotNull;

@Entity
public class Greeting extends TransactionalEntity {

    private static final long serialVersionUID = 1L;

    @NotNull
    private String text;

    public Greeting() {

    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

}
