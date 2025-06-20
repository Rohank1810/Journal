package com.journalproject.journal.service;

import java.util.List;

import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.journalproject.journal.entity.JournalEntity;
import com.journalproject.journal.repository.JournalRepository;

@Service
public class JournalServiceImpl implements JournalService {
    
    @Autowired
    private JournalRepository journalRepository;

    public List<JournalEntity> getAllEntry()
    {
       return journalRepository.findAll();   
    }
   
    public JournalEntity addEntry(JournalEntity journalEntity)
    {
        return journalRepository.save(journalEntity);
    }

    public JournalEntity findOne(ObjectId id)
    {
        return journalRepository.findById(id).orElse(null);
    }

    public JournalEntity deleteEntry(ObjectId id){
         journalRepository.deleteById(id);
         return journalRepository.findById(id).orElse(null);
    }    
} 