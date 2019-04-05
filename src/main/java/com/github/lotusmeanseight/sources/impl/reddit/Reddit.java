package com.github.lotusmeanseight.sources.impl.reddit;

import com.github.lotusmeanseight.entry.NewsEntry;
import com.github.lotusmeanseight.sources.RedditSource;
import net.dean.jraw.RedditClient;
import net.dean.jraw.http.OkHttpNetworkAdapter;
import net.dean.jraw.http.UserAgent;
import net.dean.jraw.oauth.Credentials;
import net.dean.jraw.oauth.OAuthHelper;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class Reddit implements RedditSource {

    @Value("${redditUser}")
    private String name;
    @Value("${redditPW}")
    private String pass;
    @Value("${redditID}")
    private String clientID;
    @Value("${redditSecret}")
    private String secret;
    private RedditClient redditClient;

    public Reddit(String botUserName){
        var credentials = Credentials.script(name, pass , clientID, secret);
        var userAgent = new UserAgent("bot", "com.github.lotusmeanseight", "v0.1", botUserName);
        var adapter = new OkHttpNetworkAdapter(userAgent);
        redditClient = OAuthHelper.automatic(adapter, credentials);
    }

    public List<NewsEntry> getControversialEntries(int numberOfEntries) {
        return null;
    }

    public List<NewsEntry> getControversialEntriesByCategory(int numberOfEntries, String category) {
        return null;
    }

    public List<NewsEntry> getRisingEntries(int numberOfEntries) {
        return null;
    }

    public List<NewsEntry> getRisingEntriesByCategory(int numberOfEntries, String category) {
        return null;
    }

    public List<NewsEntry> getTopEntries(int numberOfEntries) {
        return null;
    }

    public List<NewsEntry> getTopEntriesByCategory(int numberOfEntries, String category) {
        return null;
    }

    public List<NewsEntry> getNewEntries(int numberOfEntries) {
        return null;
    }

    public List<NewsEntry> getNewEntriesByCategory(int numberOfEntries, String category) {
        return null;
    }

}
