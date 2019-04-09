package com.github.lotusmeanseight.source.entrycollection;

import com.github.lotusmeanseight.source.entrycollection.reddit.RedditSimpleEntryCollection;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class EntryCollectionFactory {

    @Autowired
    private RedditSimpleEntryCollection redditSimpleEntryCollection;

    public EntryCollection getEntryCollection(String source, String entryType){
        if(source.toLowerCase().equals("reddit")){
            if(entryType.toLowerCase().equals("simple")){
                return redditSimpleEntryCollection;
            }
        }
        return null;
    }

}
