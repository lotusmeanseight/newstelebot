package com.github.lotusmeanseight.source.entrycollection.reddit;

import com.github.lotusmeanseight.entry.NewsEntry;
import com.github.lotusmeanseight.entry.impl.SimpleEntry;
import net.dean.jraw.models.Listing;
import net.dean.jraw.models.Submission;
import net.dean.jraw.models.SubredditSort;
import net.dean.jraw.pagination.DefaultPaginator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

@Component
public class RedditSimpleEntryCollection extends RedditEntryCollection {

    @Autowired
    public RedditSimpleEntryCollection(String name, String pass, String clientID, String secret, String botName) {
        super(name, pass, clientID, secret, botName);
    }

    @Override
    public List<NewsEntry> getEntries(String sortingMethod) {
        DefaultPaginator<Submission> defaultPaginator = super.getRedditClient().frontPage()
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
