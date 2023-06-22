package com.example.taw_zaliczenie;

import org.springframework.lang.Nullable;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api")
public class Aplikacja {
    @Autowired
    private BazaDanych bazadanych;
    private Integer addedItemsCounter = 1;
    @GetMapping("/ping")
    public String ping()
    {
        return "tralala";
    }

    @PostMapping(value="/zaliczenia", consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public void addClass(@RequestBody Aktywnosci newClass)
    {
        newClass.setId(addedItemsCounter++);
        bazadanych.add(newClass);
    }

    @GetMapping(value="/zaliczenia", consumes = MediaType.APPLICATION_JSON_VALUE,
            produces=MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<Aktywnosci>> getClasses(
            @Nullable @RequestParam("nazwa") String name,
            @Nullable @RequestParam("punkty") Integer points,
            @Nullable @RequestParam("sala") String room,
            @Nullable @RequestParam("zaliczenie") String pass
    )
    {
        return ResponseEntity.ok(bazadanych.get(name, points, room, pass));
    }

    @DeleteMapping(value= "/zaliczenia")
    public void deleteClasses()
    {
        bazadanych.clean();
    }

    @GetMapping(value="/zaliczenia/{id}", consumes = MediaType.APPLICATION_JSON_VALUE,
            produces=MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Aktywnosci> activitiesList(@PathVariable(value="id") String id)
    {
        Aktywnosci res = bazadanych.getById(Integer.valueOf(id));
        if(res != null) {
            return ResponseEntity.ok(res);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping(value="/zaliczenia/{id}")
    public ResponseEntity activitiesList(@PathVariable(value="id") Integer id)
    {
        boolean res = bazadanych.clean(id);
        if (res) {
            return ResponseEntity.ok().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}
