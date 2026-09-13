package net.engineeringdigest.journalApp.service;

import net.engineeringdigest.journalApp.entity.JournalEntry;
import net.engineeringdigest.journalApp.entity.User;
import net.engineeringdigest.journalApp.repository.JournalEntryRepository;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Component
public class JournalEntryService {
    @Autowired
    private JournalEntryRepository journalEntryRepository;
    @Autowired
    private UserService userservice;


    @Transactional
    public void saveEntry(JournalEntry journalEntry, String username){
        try{
            User user = userservice.findByUserName(username);
            journalEntry.setDate(LocalDateTime.now());
            JournalEntry saved = journalEntryRepository.save(journalEntry);
            user.getJournalEntries().add(saved);
            userservice.saveEntry(user);
        }
         catch (Exception e) {
            System.out.println(e);
            throw new RuntimeException("An error occured while saving the entry" + e);
        }
    }
    //method overloading to save without username (for updating journal entry)
    public void saveEntry(JournalEntry journalEntry){
        journalEntryRepository.save(journalEntry);
    }

    public List<JournalEntry> getAll(){
        return journalEntryRepository.findAll();
    }

    public Optional<JournalEntry> findById(ObjectId id){
        return journalEntryRepository.findById(id);
    }

    public void deleteById(ObjectId id, String username){
        User user = userservice.findByUserName(username);
        user.getJournalEntries().removeIf(x -> x.getId().equals(id)); //woh wali journal entry remove where the id matches
        userservice.saveEntry(user); //user saved with new journal entries
        journalEntryRepository.deleteById(id); //journal entry deleted
    }



}


//krne ko sb kuch controller m kr skte h but best practice is controller service ko call
//krega controller --> service --> repository