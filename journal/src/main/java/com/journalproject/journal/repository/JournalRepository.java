package com.journalproject.journal.repository;
import com.journalproject.journal.entity.*;


import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface JournalRepository extends MongoRepository<JournalEntity,ObjectId>{

    
}