package com.knoldus;


import com.typesafe.config.Config;
import com.typesafe.config.ConfigFactory;
import twitter4j.auth.AccessToken;

public class MyConfig implements ConfigBuilder {
    Config config = ConfigFactory.load();

    public MyConfig() {
        twitter.setOAuthConsumer(config.getString("consumer.key"),
                config.getString("consumer.key"));
        twitter.setOAuthAccessToken(new AccessToken(config.getString("consumer.key"),
                config.getString("consumer.key")));
    }
}
