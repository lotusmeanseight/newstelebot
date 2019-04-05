package com.github.lotusmeanseight.sources;

import com.github.lotusmeanseight.entry.NewsEntry;

import java.util.List;

public interface RedditSource extends NewsSource {

    List<NewsEntry> getControversialEntries(int numberOfEntries);

    List<NewsEntry> getControversialEntriesByCategory(int numberOfEntries, String category);

    List<NewsEntry> getRisingEntries(int numberOfEntries);

    List<NewsEntry> getRisingEntriesByCategory(int numberOfEntries, String category);

    List<NewsEntry> getHotEntries(int numberOfEntries);

    List<NewsEntry> getHotEntriesByCategory(int numberOfEntries, String category);

}
