package com.example.taw_zaliczenie;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import lombok.Data;

@JsonSerialize
@Data
public class Aktywnosci {
    @JsonProperty("id")
    Integer id;

    @JsonProperty("nazwa")
    String name;

    @JsonProperty("punkty")
    Integer points;

    @JsonProperty("sala")
    String room;

    @JsonProperty("zaliczenie")
    Boolean pass;

    public Aktywnosci(Integer id, String name, Integer points, String room, Boolean pass) {
        this.id = id;
        this.name = name;
        this.points = points;
        this.room = room;
        this.pass = pass;
    }
}
