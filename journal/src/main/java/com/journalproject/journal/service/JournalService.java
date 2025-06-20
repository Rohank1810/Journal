package com.journalproject.journal.service;

import java.util.List;

import org.bson.types.ObjectId;

import com.journalproject.journal.entity.JournalEntity;

public interface JournalService {

    List<JournalEntity>getAllEntry();
    JournalEntity addEntry(JournalEntity journalEntity);
    JournalEntity findOne(ObjectId id);
    JournalEntity  deleteEntry(ObjectId id);
} 