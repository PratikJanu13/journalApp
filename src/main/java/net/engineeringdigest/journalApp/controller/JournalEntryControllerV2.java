package net.engineeringdigest.journalApp.controller;

import net.engineeringdigest.journalApp.entity.JournalEntry;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/journal")  //creates a mapping for the class
public class JournalEntryControllerV2 {


    @GetMapping
    public List<JournalEntry> getAll(){
        return null;
    }

    @PostMapping
    public boolean createEntry(@RequestBody JournalEntry myEntry){ //reqbody is like saying take the data from the req and turn it into a java obj that i can use in my code
        return true;
    }
    @GetMapping("id/{myId}")
    public JournalEntry getJournalEntrybyId(@PathVariable Long myId){
        return null;
    }

    @DeleteMapping("id/{myId}")
    public JournalEntry deleteJournalEntryById(@PathVariable Long myId){
        return null;
    }

    @PutMapping("id/{id}")
    public JournalEntry updateJournalById(@PathVariable Long id, @RequestBody JournalEntry myEntry){
        return null;
    }
}
