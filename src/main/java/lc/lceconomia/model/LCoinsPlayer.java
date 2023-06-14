package lc.lceconomia.model;

import java.util.UUID;

public class LCoinsPlayer {
    private UUID uuid;
    private String nickname;
    private double lccoins;

    public LCoinsPlayer(UUID uuid, String nickname, double balance) {
        this.uuid = uuid;
        this.nickname = nickname;
        this.lccoins = balance;
    }

    public UUID getUUID() {
        return uuid;
    }

    public String getNickname() {
        return nickname;
    }

    public double getLCoins() {
        return lccoins;
    }

    public void setLCoins(double balance) {
        this.lccoins = balance;
    }

    public void addLCoins(double amount) {
        this.lccoins += amount;
    }

    public void subtractLCoins(double amount) {
        this.lccoins -= amount;
    }
}
