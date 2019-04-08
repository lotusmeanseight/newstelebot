package com.github.lotusmeanseight.sources.entry;

import com.github.lotusmeanseight.entry.NewsEntry;

import java.time.LocalDate;
import java.util.List;

public abstract class EntryCollection {

    private int limit;
    private LocalDate startDate;
    private LocalDate endDate;


    protected EntryCollection(){

    }

    public abstract List<NewsEntry> getEntries(String sortingMethod);
    public abstract List<NewsEntry> getEntriesByCategory(String sortingMethod, String category);
    public abstract List<NewsEntry> getEntriesByCategoryBeforeDate(String sortingMethod, String category, LocalDate before);
    public abstract List<NewsEntry> getEntriesByCategoryAfterDate(String sortingMethod, String category, LocalDate after);
    public abstract List<NewsEntry> getEntriesByCategoryBetweenDates(String sortingMethod, String category,
                                                      LocalDate start, LocalDate end);

    public int getLimit() {
        return limit;
    }

    public void setLimit(int limit) {
        this.limit = limit;
    }

    public LocalDate getStartDate() {
        return startDate;
    }

    public void setStartDate(LocalDate startDate) {
        this.startDate = startDate;
    }

    public LocalDate getEndDate() {
        return endDate;
    }

    public void setEndDate(LocalDate endDate) {
        this.endDate = endDate;
    }

}
