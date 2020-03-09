package com.knoldus;

import twitter4j.Twitter;
import twitter4j.TwitterFactory;
import twitter4j.auth.AccessToken;

interface ConfigBuilder {
    Twitter twitter = new TwitterFactory().getInstance();
}
