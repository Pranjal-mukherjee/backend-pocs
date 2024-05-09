package com.pattern.design.builder.home;

public class HomeDirector {
    public Home constructFancyHome() {
        return new Home.HomeBuilder()
                .walls(4)
                .roof(true)
                .doors(true)
                .garage(true)
                .swimPool(true)
                .garden(true)
                .build();
    }

    public Home constructSimpleHome() {
        return new Home.HomeBuilder()
                .walls(4)
                .roof(true)
                .doors(true)
                .build();
    }
}
