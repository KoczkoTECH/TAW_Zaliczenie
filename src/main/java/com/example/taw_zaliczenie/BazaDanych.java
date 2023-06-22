package com.example.taw_zaliczenie;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Component
@Scope("singleton")
public class BazaDanych {
    private List<Aktywnosci> classes = new ArrayList<>();

    public void add(Aktywnosci cl)
    {
        classes.add(cl);
    }

    public Aktywnosci getById(int id)
    {
        for(Aktywnosci el : classes)
        {
            if (el.getId().equals(id)) return el;
        }
        return null;
    }

    public List<Aktywnosci> get(String name, Integer points, String room, String pass) {
        List<Aktywnosci> filtered = new ArrayList<>(classes);

        if(name!=null) {
            filtered = filtered.stream().filter(el -> el.getName().equals(name)).collect(Collectors.toList());
        }
        if(points!=null) {
            filtered = filtered.stream().filter(el -> el.getPoints().equals(points)).collect(Collectors.toList());
        }
        if(room!=null) {
            filtered = filtered.stream().filter(el -> el.getRoom().equals(room)).collect(Collectors.toList());
        }
        if(pass!=null) {
            Boolean isPassRequrired;
            if(pass.toUpperCase().equals("TRUE") || pass.toUpperCase().equals("TAK")) {
                isPassRequrired = true;
            } else {
                isPassRequrired = false;
            }
            filtered = filtered.stream().filter(el -> el.getPass()==isPassRequrired).collect(Collectors.toList());
        }

        return filtered;
    }

    public void clean()
    {
        classes.clear();
    }

    public boolean clean(Integer id)
    {
        return classes.removeIf(el -> el.getId()==id);
    }

}
