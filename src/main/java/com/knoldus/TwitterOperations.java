package com.knoldus;

import twitter4j.Status;
import twitter4j.TwitterException;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.*;
import java.util.stream.Collectors;

public class TwitterOperations {
    TwitterDataForHashTag data = new TwitterDataForHashTag();
    Comparator<Status> compareByDate = Comparator.comparing(Status::getCreatedAt);
    Comparator<Status> compareByReTweetCount = Comparator.comparing(Status::getRetweetCount);
    Comparator<Status> getCompareByFavCount = Comparator.comparing(Status::getFavoriteCount);

    public List<Status> newToOldTweets(String hashTagKeyword, int limit) throws TwitterException {
        List<Status> tweets = data.getData(hashTagKeyword, limit);
        return tweets.stream()
                .sorted(compareByDate.reversed())
                .collect(Collectors.toList());
    }

    public List<Status> oldToNewTweets(String hashTagKeyword, int limit) throws TwitterException {
        List<Status> tweets = data.getData(hashTagKeyword, limit);
        return tweets.stream()
                .sorted(compareByDate)
                .collect(Collectors.toList());
    }

    public List<Integer> reTweetCount(String hashTagKeyword) throws TwitterException{
        List<Status> tweets = data.getData(hashTagKeyword);
        return tweets.stream()
                .sorted(compareByReTweetCount.reversed())
                .map(Status::getRetweetCount)
                .collect(Collectors.toList());
    }

    public List<Integer> likeCount(String hashTagKeyword) throws TwitterException{
        List<Status> tweets = data.getData(hashTagKeyword);
        return tweets.stream()
                .sorted(getCompareByFavCount.reversed())
                .map(Status::getFavoriteCount)
                .collect(Collectors.toList());
    }

    public List<Status> ofDay(String hashTagKeyword, LocalDate localDate) throws TwitterException {
        List<Status> tweets = data.getData(hashTagKeyword);
        return tweets.stream()
                .filter(status -> status.getCreatedAt()
                        .toInstant()
                        .atZone(ZoneId.systemDefault())
                        .toLocalDate().isEqual(localDate))
                .collect(Collectors.toList());
    }

    public List<Status> forDuration(String hashTagKeyword, int minutes) throws TwitterException {

        List<Status> tweets = data.getData(hashTagKeyword);
        Optional<LocalDateTime> dateOfFirstTweet =  tweets.stream()
                .sorted(compareByDate.reversed())
                .map(status -> status.getCreatedAt()
                        .toInstant()
                        .atZone(ZoneId.systemDefault())
                        .toLocalDateTime())
                .findFirst();

        LocalDateTime dateLimit = dateOfFirstTweet.map(date -> date.minusMinutes(minutes)).get();
        System.out.println(dateLimit);
        System.out.println(dateOfFirstTweet);
        return tweets.stream()
                .filter(status -> status.getCreatedAt()
                        .toInstant()
                        .atZone(ZoneId.systemDefault())
                        .toLocalDateTime().isBefore(dateLimit))
                .collect(Collectors.toList());
    }
}
