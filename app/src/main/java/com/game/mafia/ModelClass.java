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

    public void setPlayerId(String playerId) {
        PlayerId = playerId;
    }

    public String getPlayerName() {
        return PlayerName;
    }

    public void setPlayerName(String playerName) {
        PlayerName = playerName;
    }
}
