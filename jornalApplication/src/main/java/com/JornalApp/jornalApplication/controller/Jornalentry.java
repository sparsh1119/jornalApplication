package com.JornalApp.jornalApplication.controller;

import com.JornalApp.jornalApplication.entity.Entries;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

@RestController
@RequestMapping("/jornal")
public class Jornalentry {

    private HashMap<Long,Entries> jornalEntry = new HashMap<>();

    @GetMapping("/get")
    public List<Entries> getAll(){
        return new ArrayList<>(jornalEntry.values());
    }

    @PostMapping("/post")
    public boolean createEntry(@RequestBody Entries myEntry){
        jornalEntry.put(myEntry.getId(),myEntry);
        return  true;
    }


    @GetMapping("/id/{myid}")
    public Entries getOne(@PathVariable long myid){
        return jornalEntry.get(myid);
    }

    @PutMapping("/update/{myid}")
    public boolean updateEntry(@PathVariable Long myid,@RequestBody Entries myEntry){
         jornalEntry.put(myid,myEntry);
         return true;
    }

    @DeleteMapping("/dlt/{myid}")
    public boolean remove(@PathVariable long myid){
        jornalEntry.remove(myid);
        return true;
    }
}
