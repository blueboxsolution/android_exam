package com.bbx.androidexam.models;

import com.bluelinelabs.logansquare.annotation.JsonField;
import com.bluelinelabs.logansquare.annotation.JsonObject;

import java.io.Serializable;
import java.util.List;

/**
 * Created by macbookair on 27/09/2017.
 */

@JsonObject
public class PersonList implements Serializable{

    @JsonField(name = "person")
    public List<Person> person;
}
