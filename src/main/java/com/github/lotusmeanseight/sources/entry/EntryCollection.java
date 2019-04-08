package com.github.lotusmeanseight.sources.entry;

import com.github.lotusmeanseight.entry.NewsEntry;

import java.time.LocalDate;
import java.util.List;

public abstract class EntryCollection<T extends NewsEntry> {

    private int limit;
    private LocalDate startDate;
    private LocalDate endDate;


    protected EntryCollection(){

    }

    abstract List<T> getEntries(String sortingMethod);
    abstract List<T> getEntriesByCategory(String sortingMethod, String category);
    abstract List<T> getEntriesByCategoryBeforeDate(String sortingMethod, String category, LocalDate before);
    abstract List<T> getEntriesByCategoryAfterDate(String sortingMethod, String category, LocalDate after);
    abstract List<T> getEntriesByCategoryBetweenDates(String sortingMethod, String category,
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
