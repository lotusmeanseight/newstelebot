package com.github.lotusmeanseight.sources.reddit.service;

import com.github.lotusmeanseight.entry.NewsEntry;
import com.github.lotusmeanseight.sources.RedditSource;
import com.github.lotusmeanseight.sources.entry.EntryCollectionFactory;
import com.github.lotusmeanseight.sources.entry.RedditEntryCollection;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RedditSimpleService implements RedditSource {

    private RedditEntryCollection collection;

/*
    private List<NewsEntry> iterateSubmissions(Listing<Submission> submissions){
        List<NewsEntry> entries = new ArrayList<>();
        for (Submission s : submissions) {
            try {
                NewsEntry entry = new SimpleEntry((s.getTitle()), new URL(s.getUrl()));
                entries.add(entry);
            } catch (MalformedURLException e) {
                e.printStackTrace();
            }
        }
        return entries;
    }
*/

    public RedditSimpleService(){
        EntryCollectionFactory factory = new EntryCollectionFactory();
        this.collection = (RedditEntryCollection) factory.getEntryCollection("reddit", "simple");
    }


    @Override
    public List<NewsEntry> getControversialEntries(int numberOfEntries) {
        collection.setLimit(numberOfEntries);
        return collection.getEntries("controversial");
    }

    @Override
    public List<NewsEntry> getControversialEntriesByCategory(int numberOfEntries, String category) {
        collection.setLimit(numberOfEntries);
        return collection.getEntriesByCategory("controversial", category);
    }

    @Override
    public List<NewsEntry> getRisingEntries(int numberOfEntries) {
        collection.setLimit(numberOfEntries);
        return collection.getEntries("rising");
    }

    @Override
    public List<NewsEntry> getRisingEntriesByCategory(int numberOfEntries, String category) {
        collection.setLimit(numberOfEntries);
        return collection.getEntriesByCategory("rising", category);
    }

    @Override
    public List<NewsEntry> getHotEntries(int numberOfEntries) {
        collection.setLimit(numberOfEntries);
        return collection.getEntries("hot");
    }

    @Override
    public List<NewsEntry> getHotEntriesByCategory(int numberOfEntries, String category) {
        collection.setLimit(numberOfEntries);
        return collection.getEntriesByCategory("hot", category);
    }

    @Override
    public List<NewsEntry> getTopEntries(int numberOfEntries) {
        collection.setLimit(numberOfEntries);
        return collection.getEntries("top");
    }

    @Override
    public List<NewsEntry> getTopEntriesByCategory(int numberOfEntries, String category) {
        collection.setLimit(numberOfEntries);
        return collection.getEntriesByCategory("top", category);
    }

    @Override
    public List<NewsEntry> getNewEntries(int numberOfEntries) {
        collection.setLimit(numberOfEntries);
        return collection.getEntries("new");
    }

    @Override
    public List<NewsEntry> getNewEntriesByCategory(int numberOfEntries, String category) {
        collection.setLimit(numberOfEntries);
        return collection.getEntriesByCategory("new", category);
    }
}
