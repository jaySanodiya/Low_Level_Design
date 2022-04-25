package com.masai.SocialMedia;

public class GooglePlusStrategy implements SocialmediaStrategy {
    @Override
    public void connect(String name) {
        System.out.println("Connecting with "+name+ " through GooglePlus");
    }
}
