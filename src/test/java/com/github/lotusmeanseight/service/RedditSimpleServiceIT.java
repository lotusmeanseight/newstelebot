package com.github.lotusmeanseight.service;

import com.github.lotusmeanseight.entry.NewsEntry;
import com.github.lotusmeanseight.source.entrycollection.AbstractFactory;
import com.github.lotusmeanseight.source.entrycollection.FactoryCreator;
import com.github.lotusmeanseight.source.entrycollection.reddit.RedditEntryCollection;
import com.github.lotusmeanseight.source.entrycollection.reddit.RedditFactory;
import com.github.lotusmeanseight.source.service.reddit.RedditSimpleService;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.List;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class RedditSimpleServiceIT {

    private int numberOfEntries;
    private String category;
    private List<NewsEntry> entryList;
    @Autowired
    private RedditSimpleService simpleService;



    @BeforeAll
    public void setup(){
        this.numberOfEntries = 5;
        this.category = "HumansBeingBros";
        this.entryList = new ArrayList<>();
    }

    @AfterEach
    public void resetList(){
        this.entryList = new ArrayList<>();
    }

    @Test
    public void testControversialEntries(){
        this.entryList = simpleService.getControversialEntries(numberOfEntries);
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
