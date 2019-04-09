package com.github.lotusmeanseight.source;

import com.github.lotusmeanseight.entry.NewsEntry;

import java.util.List;

public interface NewsSource {

    List<NewsEntry> getTopEntries(int numberOfEntries);

    List<NewsEntry> getTopEntriesByCategory(int numberOfEntries, String category);

    List<NewsEntry> getNewEntries(int numberOfEntries);

    List<NewsEntry> getNewEntriesByCategory(int numberOfEntries, String category);
}
