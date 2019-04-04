package com.github.lotusmeanseight.entry.impl;

import com.github.lotusmeanseight.entry.NewsEntry;

import java.net.URL;

public class SimpleEntry implements NewsEntry {

    private final String title;
    private final URL url;

    public SimpleEntry(String title, URL url) {
        this.title = title;
        this.url = url;
    }

    public String getTitle() {
        return title;
    }

    public URL getURL() {
        return url;
    }


}
