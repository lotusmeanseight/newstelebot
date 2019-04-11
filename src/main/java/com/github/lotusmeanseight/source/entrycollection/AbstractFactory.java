package com.github.lotusmeanseight.source.entrycollection;

public interface AbstractFactory<T> {

     T create(String entryType);

}
