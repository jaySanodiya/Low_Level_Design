package com.masai.SocialMedia;

public class SocialMediaContext {
    SocialmediaStrategy socialmediaStrategy;

    public void setSocialmediaStrategy(SocialmediaStrategy socialmediaStrategy) {
        this.socialmediaStrategy = socialmediaStrategy;
    }

    public void connect(String name){
        socialmediaStrategy.connect(name);
    }
}
