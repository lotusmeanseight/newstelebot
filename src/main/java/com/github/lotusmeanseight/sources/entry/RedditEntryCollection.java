package com.github.lotusmeanseight.sources.entry;

import com.github.lotusmeanseight.entry.NewsEntry;
import com.github.lotusmeanseight.entry.impl.SimpleEntry;
import net.dean.jraw.RedditClient;
import net.dean.jraw.http.OkHttpNetworkAdapter;
import net.dean.jraw.http.UserAgent;
import net.dean.jraw.models.Listing;
import net.dean.jraw.models.Submission;
import net.dean.jraw.models.SubredditSort;
import net.dean.jraw.oauth.Credentials;
import net.dean.jraw.oauth.OAuthHelper;
import net.dean.jraw.pagination.DefaultPaginator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;

import java.net.MalformedURLException;
import java.net.URL;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class RedditEntryCollection extends EntryCollection {

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

    private RedditClient getRedditClient() {
        return redditClient;
    }

    @Override
    public List<NewsEntry> getEntries(String sortingMethod) {
        DefaultPaginator<Submission> defaultPaginator = getRedditClient().frontPage()
                .limit(getLimit())
                .sorting(SubredditSort.valueOf(sortingMethod))
                .build();
        return iterateSubmissions(defaultPaginator.next());
    }

    @Override
    public List<NewsEntry> getEntriesByCategory(String sortingMethod, String category) {
        DefaultPaginator<Submission> defaultPaginator = getRedditClient()
                .subreddit(category)
                .posts()
                .limit(getLimit())
                .sorting(SubredditSort.valueOf(sortingMethod))
                .build();
        return iterateSubmissions((defaultPaginator.next()));
    }

    @Override
    public List<NewsEntry> getEntriesByCategoryBeforeDate(String sortingMethod, String category, LocalDate before) {
        return null;
    }

    @Override
    public List<NewsEntry> getEntriesByCategoryAfterDate(String sortingMethod, String category, LocalDate after) {
        return null;
    }

    @Override
    public List<NewsEntry> getEntriesByCategoryBetweenDates(String sortingMethod, String category, LocalDate start, LocalDate end) {
        return null;
    }

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
}
