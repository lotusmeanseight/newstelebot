package com.github.lotusmeanseight.source.entrycollection;

import com.github.lotusmeanseight.source.entrycollection.reddit.RedditFactory;

public class FactoryCreator {

    public static AbstractFactory getFactory(String factory){
        if(factory.equalsIgnoreCase("reddit")){
            return new RedditFactory();
        }else if(factory.equalsIgnoreCase("")){
            //TODO add other factory
        }
        return null;
    }
}
