package com.intertec.model.data;

import javax.persistence.*;
import java.io.Serializable;

/**
 * Created by Userpc on 13/05/2018.
 */

@Entity
@Table(name = "restricted_words")
public class RestrictedWord implements Serializable{
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private int id;

    private String word;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getWord() {
        return word;
    }

    public void setWord(String word) {
        this.word = word;
    }
}
