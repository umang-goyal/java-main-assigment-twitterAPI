package com.knoldus;

import twitter4j.Query;
import twitter4j.QueryResult;
import twitter4j.Status;
import twitter4j.TwitterException;

import java.util.List;

public class TwitterDataForHashTag implements TwitterData {
    ConfigBuilder configuration = new MyConfig();

    @Override
    public List<Status> getData(String keyword) throws TwitterException {
        Query query = new Query("#" + keyword);
        query.setCount(20);
        QueryResult result = configuration.twitter.search(query);
        return result.getTweets();
    }

    public List<Status> getData(String keyword, int limit) throws TwitterException {
        Query query = new Query("#" + keyword);
        query.setCount(limit);
        QueryResult result = configuration.twitter.search(query);
        return result.getTweets();
    }


}
