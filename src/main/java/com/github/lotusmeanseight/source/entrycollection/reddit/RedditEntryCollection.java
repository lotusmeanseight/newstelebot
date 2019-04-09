package com.github.lotusmeanseight.source.entrycollection.reddit;

import com.github.lotusmeanseight.source.entrycollection.EntryCollection;
import net.dean.jraw.RedditClient;
import net.dean.jraw.http.OkHttpNetworkAdapter;
import net.dean.jraw.http.UserAgent;
import net.dean.jraw.oauth.Credentials;
import net.dean.jraw.oauth.OAuthHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public abstract class RedditEntryCollection extends EntryCollection {

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

    protected RedditClient getRedditClient() {
        return redditClient;
    }

}
