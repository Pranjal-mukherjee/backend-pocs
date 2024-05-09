package com.pattern.design.builder.home;

public class HomeMain {
    public static void main(String[] args) {
        Home home = new Home.HomeBuilder().garden(false).doors(true).roof(true).swimPool(true).walls(12).build();
        System.out.println(home.toString());
        HomeDirector director = new HomeDirector();

        Home fancyHome = director.constructFancyHome();
        System.out.println(fancyHome);

        Home simpleHome = director.constructSimpleHome();
        System.out.println(simpleHome);

    }
}
