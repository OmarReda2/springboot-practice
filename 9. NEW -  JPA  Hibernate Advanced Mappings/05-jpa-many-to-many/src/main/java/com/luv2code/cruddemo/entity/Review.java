package com.luv2code.cruddemo.entity;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name="review")
public class Review {

    // annotate the class as an entity and map to db table

    // define constructor

    // define getter setter

    // define toString

    // annotate fields

    @Id
    @GeneratiedValue(strategy = GenerationType.IDENTITY)
    @Column(name=id)
    public int id;

    @Column(name="comment")
    public String comment;


    public Review(){

    }

    public Review(String comment) {
        this.comment = comment;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }



    @Override
    public String toString() {
        return "Review{" +
                "id=" + id +
                ", comment='" + comment + '\'' +
                '}';
    }
}
