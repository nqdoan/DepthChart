package main;

import controller.PlayerObjectToDatabase;
import controller.PlayerSourceToObject;

public class DepthChart {

    public static void main(String[] args) {
        PlayerSourceToObject sto = new PlayerSourceToObject();
        PlayerObjectToDatabase  otd = new PlayerObjectToDatabase();
        otd.loadPlayers();

    }
}
