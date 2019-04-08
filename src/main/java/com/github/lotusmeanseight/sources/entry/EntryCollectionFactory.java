package com.github.lotusmeanseight.sources.entry;

import com.github.lotusmeanseight.entry.NewsEntry;
import com.github.lotusmeanseight.entry.impl.SimpleEntry;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class EntryCollectionFactory {

    @Autowired
    private RedditEntryCollection<SimpleEntry> redditSimpleEntryCollection;

    public EntryCollection getEntryCollection(String source, String entryType){
        if(source.toLowerCase().equals("reddit")){
            if(entryType.toLowerCase().equals("simple")){
                return redditSimpleEntryCollection;
            }
        }

        return null;
    }

}
