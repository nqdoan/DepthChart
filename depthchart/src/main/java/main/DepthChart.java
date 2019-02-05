package main;

import model.PlayerLoader;

public class Main {

    public static void main(String[] args) {
        PlayerLoader lp = new PlayerLoader();
        lp.loadPlayers();
        lp.cleanThirdCellFromPlayerName();
        lp.displayPlayers();

    }
}
