package com.knoldus;

import twitter4j.Status;
import twitter4j.TwitterException;

import java.util.List;

interface TwitterData {
    List<Status> getData(String keyword) throws TwitterException;
}
