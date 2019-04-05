package com.github.lotusmeanseight.sources.impl.reddit;

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
public class RedditService implements RedditSource {

    @Value("${redditUser}")
    private String name;
    @Value("${redditPW}")
    private String pass;
    @Value("${redditID}")
    private String clientID;
    @Value("${redditSecret}")
    private String secret;
    private RedditClient redditClient;

    public RedditService(String botUserName){
        var credentials = Credentials.script(name, pass , clientID, secret);
        var userAgent = new UserAgent("bot", "com.github.lotusmeanseight", "v0.1", botUserName);
        var adapter = new OkHttpNetworkAdapter(userAgent);
        redditClient = OAuthHelper.automatic(adapter, credentials);
    }


    @Override
    public List<NewsEntry> getControversialEntries(int numberOfEntries) {
        DefaultPaginator<Submission> frontPage = redditClient.frontPage()
                .sorting(SubredditSort.CONTROVERSIAL)
                .limit(numberOfEntries)
                .build();
        Listing<Submission> submissions = frontPage.next();
        List<NewsEntry> newsEntries = new ArrayList<>();
        for(Submission s : submissions){
            try {
                SimpleEntry entry = new SimpleEntry(s.getTitle(), new URL(s.getUrl()));
                newsEntries.add(entry);
            } catch (MalformedURLException e) {
                e.printStackTrace();
            }
        }
        return newsEntries;
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
