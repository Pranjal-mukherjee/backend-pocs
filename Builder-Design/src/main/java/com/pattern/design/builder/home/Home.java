package com.pattern.design.builder.home;

import lombok.Getter;

@Getter

public class Home {

    private final int walls;
    private final boolean paints;
    private final boolean doors;
    private final boolean roof;
    private final boolean garage;
    private final boolean swimPool;
    private final boolean garden;

    private Home(HomeBuilder homeBuilder) {
        this.walls = homeBuilder.walls;
        this.paints = homeBuilder.paints;
        this.doors = homeBuilder.doors;
        this.roof = homeBuilder.roof;
        this.garage = homeBuilder.garage;
        this.swimPool = homeBuilder.swimPool;
        this.garden = homeBuilder.garden;
    }

    @Override
    public String toString() {
        String stringBuilder = "Home Details:\n" +
                "Number of Walls: " + walls + "\n" +
                "Painted: " + paints + "\n" +
                "Doors Installed: " + doors + "\n" +
                "Roof Installed: " + roof + "\n" +
                "Garage: " + garage + "\n" +
                "Swimming Pool: " + swimPool + "\n" +
                "Garden: " + garden + "\n";
        return stringBuilder;
    }


    public static class HomeBuilder {

        private int walls;
        private boolean paints;
        private boolean doors;
        private boolean roof;
        private boolean garage;
        private boolean swimPool;
        private boolean garden;

        public HomeBuilder walls(int walls) {
            this.walls = walls;
            return this;
        }

        public HomeBuilder roof(boolean roof) {
            this.roof = roof;
            return this;
        }

        public HomeBuilder doors(boolean doors) {
            this.doors = doors;
            return this;
        }

        public HomeBuilder garage(boolean garage) {
            this.garage = garage;
            return this;
        }

        public HomeBuilder swimPool(boolean swimPool) {
            this.swimPool = swimPool;
            return this;
        }

        public HomeBuilder garden(boolean garden) {
            this.garden = garden;
            return this;
        }

        public Home build() {
            return new Home(this);
        }

    }
}
