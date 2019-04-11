package com.github.lotusmeanseight.source.entrycollection.reddit;

import com.github.lotusmeanseight.source.entrycollection.AbstractFactory;
import org.springframework.beans.factory.annotation.Autowired;

public class RedditFactory implements AbstractFactory<RedditEntryCollection> {

    @Autowired
    RedditSimpleEntryCollection simpleEntryCollection;

    @Override
    public RedditEntryCollection create(String entryType) {
        if(entryType.equalsIgnoreCase("simple")){
            return simpleEntryCollection;
        }else if(entryType.equalsIgnoreCase("")){
            //TODO add other entryType
        }
        return null;
    }
}
