package com.github.lotusmeanseight.sources.reddit.service;

import com.github.lotusmeanseight.entry.NewsEntry;
import com.github.lotusmeanseight.entry.impl.SimpleEntry;
import com.github.lotusmeanseight.sources.RedditSource;
import net.dean.jraw.RedditClient;
import net.dean.jraw.http.OkHttpNetworkAdapter;
import net.dean.jraw.http.UserAgent;
import net.dean.jraw.models.Listing;
import net.dean.jraw.models.Submission;
import net.dean.jraw.models.SubredditSort;
import net.dean.jraw.oauth.Credentials;
import net.dean.jraw.oauth.OAuthHelper;
import net.dean.jraw.pagination.DefaultPaginator;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

@Service
public class RedditSimpleService implements RedditSource {


/*
    private List<NewsEntry> iterateSubmissions(Listing<Submission> submissions){
        List<NewsEntry> entries = new ArrayList<>();
        for (Submission s : submissions) {
            try {
                NewsEntry entry = new SimpleEntry((s.getTitle()), new URL(s.getUrl()));
                entries.add(entry);
            } catch (MalformedURLException e) {
                e.printStackTrace();
            }
        }
        return entries;
    }
*/


    @Override
    public List<NewsEntry> getControversialEntries(int numberOfEntries) {
/*        DefaultPaginator<Submission> frontPage = redditClient.frontPage()
                .sorting(SubredditSort.CONTROVERSIAL)
                .limit(numberOfEntries)
                .build();
        Listing<Submission> submissions = frontPage.next();
        return iterateSubmissions(submissions);*/
        return null;
    }

    @Override
    public List<NewsEntry> getControversialEntriesByCategory(int numberOfEntries, String category) {
        return null;
    }

    @Override
    public List<NewsEntry> getRisingEntries(int numberOfEntries) {
        return null;
    }

    @Override
    public List<NewsEntry> getRisingEntriesByCategory(int numberOfEntries, String category) {
        return null;
    }

    @Override
    public List<NewsEntry> getHotEntries(int numberOfEntries) {
        return null;
    }

    @Override
    public List<NewsEntry> getHotEntriesByCategory(int numberOfEntries, String category) {
        return null;
    }

    @Override
    public List<NewsEntry> getTopEntries(int numberOfEntries) {
        return null;
    }

    @Override
    public List<NewsEntry> getTopEntriesByCategory(int numberOfEntries, String category) {
        return null;
    }

    @Override
    public List<NewsEntry> getNewEntries(int numberOfEntries) {
        return null;
    }

    @Override
    public List<NewsEntry> getNewEntriesByCategory(int numberOfEntries, String category) {
        return null;
    }
}
