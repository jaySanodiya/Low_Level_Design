package com.masai.SocialMedia;

public class TwitterStrategy implements SocialmediaStrategy {
    @Override
    public void connect(String name) {
        System.out.println("Connecting with "+name+ " through Twitter");
    }
}
