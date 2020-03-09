package com.knoldus;

import twitter4j.*;
import twitter4j.auth.AccessToken;
import twitter4j.conf.ConfigurationBuilder;
import javax.security.auth.login.Configuration;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.Month;
import java.util.ArrayList;
import java.util.List;

public class App {
    public static void main(String[] args) throws TwitterException {
        TwitterOperations obj = new TwitterOperations();
        System.out.println(obj.newToOldTweets("happy",10).size());
        System.out.println("========================================");
        System.out.println(obj.oldToNewTweets("happy",10).size());
        System.out.println("========================================");
        System.out.println(obj.likeCount("happy").size());
        System.out.println("========================================");
        System.out.println(obj.reTweetCount("happy").size());
        System.out.println("========================================");
        LocalDate day = LocalDate.of(2020, Month.MARCH, 9);
        System.out.println(obj.ofDay("happy",day).size());
        System.out.println("========================================");
        System.out.println(obj.forDuration("happy",30));
    }
}



