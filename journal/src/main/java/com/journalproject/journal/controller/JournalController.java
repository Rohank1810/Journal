package com.journalproject.journal.controller;

import org.springframework.web.bind.annotation.RestController;

import com.journalproject.journal.entity.JournalEntity;
import com.journalproject.journal.service.JournalService;

import java.util.List;

import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;

@RestController
class JournalController{

    @Autowired
    private JournalService journalService;
   
    @GetMapping("/check")
    public String show()
    {
        return "hi";
    }

    @GetMapping("/getAll")
    public ResponseEntity<List<JournalEntity>> getAllJournal()
    {
      List <JournalEntity>allentry= journalService.getAllEntry();
      return new ResponseEntity<>(allentry, HttpStatus.OK);
    }

    @PostMapping("/add")
    public ResponseEntity<JournalEntity> addEntry(@RequestBody JournalEntity journalEntity)
    {
        return new ResponseEntity<>(journalService.addEntry(journalEntity),HttpStatus.CREATED);
    }
    
    @GetMapping("/findOne/{id}")
    public ResponseEntity<JournalEntity> findJournalEntry(@PathVariable ObjectId id) {
        return new ResponseEntity<>(journalService.findOne(id),HttpStatus.OK);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<JournalEntity> deleteEntry(@PathVariable ObjectId id) {
         JournalEntity deleted = journalService.deleteEntry(id);
         return new ResponseEntity<>(deleted, HttpStatus.OK);
    }


    @PutMapping("/update/{id}")
    public ResponseEntity<JournalEntity> updateEntry(@PathVariable ObjectId id, @RequestBody JournalEntity journalEntity) {
        JournalEntity oldEntry = journalService.findOne(id);
        
        if (oldEntry != null) {
            oldEntry.setContent(journalEntity.getContent());
            oldEntry.setDate(journalEntity.getDate());
            oldEntry.setTitle(journalEntity.getTitle());
            journalService.addEntry(oldEntry); 
            return new ResponseEntity<>(oldEntry, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
    
    
}