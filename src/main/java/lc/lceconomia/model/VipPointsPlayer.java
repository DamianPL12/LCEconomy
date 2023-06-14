package lc.lceconomia.model;

import java.util.UUID;

public class VipPointsPlayer {
    private UUID uuid;
    private String nickname;
    private int vipPoints;

    public VipPointsPlayer(UUID uuid, String nickname, int vipPoints) {
        this.uuid = uuid;
        this.nickname = nickname;
        this.vipPoints = vipPoints;
    }

    public UUID getUUID() {
        return uuid;
    }

    public String getNickname() {
        return nickname;
    }

    public int getVipPoints() {
        return vipPoints;
    }

    public void setVipPoints(int vipPoints) {
        this.vipPoints = vipPoints;
    }

    public void addVipPoints(int amount) {
        this.vipPoints += amount;
    }

    public void subtractVipPoints(int amount) {
        this.vipPoints -= amount;
    }
}
