package com.github.lotusmeanseight.service;

import com.github.lotusmeanseight.entry.NewsEntry;
import com.github.lotusmeanseight.source.entrycollection.EntryCollectionFactory;
import com.github.lotusmeanseight.source.entrycollection.reddit.RedditEntryCollection;
import com.github.lotusmeanseight.source.entrycollection.reddit.RedditSimpleEntryCollection;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

public class RedditSimpleServiceIT {

    private int numberOfEntries;
    private List<NewsEntry> entryList;
    private EntryCollectionFactory factory;
    private RedditEntryCollection simpleEntryCollection;

    @BeforeAll
    public void setup(){
        this.numberOfEntries = 5;
        entryList = new ArrayList<>();
    }

    @AfterEach
    public void resetList(){
        entryList = new ArrayList<>();
    }

    @Test
    public void testControversialEntries(){

    }

    @Test
    public void testControversialEntriesByCategory(){

    }

    @Test
    public void testTopEntries(){

    }

    @Test
    public void testTopEntriesByCategory(){

    }

    @Test
    public void testNewEntries(){

    }

    @Test
    public void testNewEntriesByCategory(){

    }

    @Test
    public void testHotEntries(){

    }

    @Test
    public void testHotEntriesByCategory(){

    }

    @Test
    public void getRisingEntries(){

    }

    @Test
    public void getRisingEntriesByCategory(){

    }

}
