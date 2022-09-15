package com.game.mafia;

public class ModelClass {

    String PlayerId;
    String PlayerName;

    public ModelClass() {

    }

    public ModelClass(String playerId, String playerName) {
        PlayerId = playerId;
        PlayerName = playerName;
    }

    public String getPlayerId() {
        return PlayerId;
    }

    public String getPlayerName() {
        return PlayerName;
    }
}
