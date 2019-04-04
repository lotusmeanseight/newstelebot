package com.github.lotusmeanseight.entry;

import java.net.URL;

/**
 * Every NewsEntry needs to return at least
 * the title of the news story or discussion thread
 * to identify it from reading it once printed out.
 * Additionally a URL is needed for the User to see the full
 * article or read the comments made in the discussion on
 * the respective website.
 */
public interface NewsEntry {
    String getTitle();
    URL getURL();
}
