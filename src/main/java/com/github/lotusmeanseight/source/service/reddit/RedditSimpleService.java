package com.github.lotusmeanseight.source.service.reddit;

import com.github.lotusmeanseight.entry.NewsEntry;
import com.github.lotusmeanseight.source.RedditSource;
import com.github.lotusmeanseight.source.entrycollection.EntryCollectionFactory;
import com.github.lotusmeanseight.source.entrycollection.reddit.RedditEntryCollection;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RedditSimpleService implements RedditSource {

    private RedditEntryCollection collection;

    public RedditSimpleService(){
        EntryCollectionFactory factory = new EntryCollectionFactory();
        this.collection = (RedditEntryCollection) factory.getEntryCollection("reddit", "simple");
    }

    @Override
    public List<NewsEntry> getControversialEntries(int numberOfEntries) {
        collection.setLimit(numberOfEntries);
        return collection.getEntries("CONTROVERSIAL");
    }

    @Override
    public List<NewsEntry> getControversialEntriesByCategory(int numberOfEntries, String category) {
        collection.setLimit(numberOfEntries);
        return collection.getEntriesByCategory("CONTROVERSIAL", category);
    }

    @Override
    public List<NewsEntry> getRisingEntries(int numberOfEntries) {
        collection.setLimit(numberOfEntries);
        return collection.getEntries("RISING");
    }

    @Override
    public List<NewsEntry> getRisingEntriesByCategory(int numberOfEntries, String category) {
        collection.setLimit(numberOfEntries);
        return collection.getEntriesByCategory("RISING", category);
    }

    @Override
    public List<NewsEntry> getHotEntries(int numberOfEntries) {
        collection.setLimit(numberOfEntries);
        return collection.getEntries("HOT");
    }

    @Override
    public List<NewsEntry> getHotEntriesByCategory(int numberOfEntries, String category) {
        collection.setLimit(numberOfEntries);
        return collection.getEntriesByCategory("HOT", category);
    }

    @Override
    public List<NewsEntry> getTopEntries(int numberOfEntries) {
        collection.setLimit(numberOfEntries);
        return collection.getEntries("TOP");
    }

    @Override
    public List<NewsEntry> getTopEntriesByCategory(int numberOfEntries, String category) {
        collection.setLimit(numberOfEntries);
        return collection.getEntriesByCategory("TOP", category);
    }

    @Override
    public List<NewsEntry> getNewEntries(int numberOfEntries) {
        collection.setLimit(numberOfEntries);
        return collection.getEntries("NEW");
    }

    @Override
    public List<NewsEntry> getNewEntriesByCategory(int numberOfEntries, String category) {
        collection.setLimit(numberOfEntries);
        return collection.getEntriesByCategory("NEW", category);
    }
}
