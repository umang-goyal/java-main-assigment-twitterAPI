package com.knoldus;

import java.util.Date;

public class TweetStatus {
    long id;
    int favoriteCount;
    int reTweetCount;
    Date createdAt;
    public TweetStatus(long id, int favoriteCount, int reTweetCount, Date createdAt){
        this.id = id;
        this.favoriteCount = favoriteCount;
        this.reTweetCount = reTweetCount;
        this.createdAt = createdAt;
    }
}
