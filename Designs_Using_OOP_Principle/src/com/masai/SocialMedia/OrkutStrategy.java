package com.masai.SocialMedia;

public class OrkutStrategy implements SocialmediaStrategy {
    @Override
    public void connect(String name) {
        System.out.println("Connecting with "+name+ " through Orkut");
    }
}
