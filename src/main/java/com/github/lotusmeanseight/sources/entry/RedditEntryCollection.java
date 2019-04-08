package com.github.lotusmeanseight.sources.entry;

import com.github.lotusmeanseight.entry.NewsEntry;
import net.dean.jraw.RedditClient;
import net.dean.jraw.http.OkHttpNetworkAdapter;
import net.dean.jraw.http.UserAgent;
import net.dean.jraw.oauth.Credentials;
import net.dean.jraw.oauth.OAuthHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;

import java.time.LocalDate;
import java.util.List;

public class RedditEntryCollection<T extends NewsEntry> extends EntryCollection<T> {

    private final String name;
    private final String pass;
    private final String clientID;
    private final String secret;
    private final String botName;
    private final RedditClient redditClient;

    @Autowired
    public RedditEntryCollection(@Value("${reddit.user}") String name,
                                 @Value("${reddit.password}") String pass,
                                 @Value("${reddit.client.id}") String clientID,
                                 @Value("${reddit.client.secret}") String secret,
                                 @Value("${reddit.bot}") String botName) {
        this.name = name;
        this.pass = pass;
        this.clientID = clientID;
        this.secret = secret;
        this.botName = botName;
        var credentials = Credentials.script(name, pass, clientID, secret);
        var userAgent = new UserAgent("bot", "com.github.lotusmeanseight", "v0.1", botName);
        var adapter = new OkHttpNetworkAdapter(userAgent);
        this.redditClient = OAuthHelper.automatic(adapter, credentials);
    }

    public RedditClient getRedditClient() {
        return redditClient;
    }

    @Override
    public List<T> getEntries(String sortingMethod) {
        return null;
    }

    @Override
    public List<T> getEntriesByCategory(String sortingMethod, String category) {
        return null;
    }

    @Override
    public List<T> getEntriesByCategoryBeforeDate(String sortingMethod, String category, LocalDate before) {
        return null;
    }

    @Override
    public List<T> getEntriesByCategoryAfterDate(String sortingMethod, String category, LocalDate after) {
        return null;
    }

    @Override
    public List<T> getEntriesByCategoryBetweenDates(String sortingMethod, String category, LocalDate start, LocalDate end) {
        return null;
    }
}
