package com.example.workshop.users;

public class Body {
    private int id;
    private String firstname;
    private String lastname;

    public Body(){

    }
    public Body(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
