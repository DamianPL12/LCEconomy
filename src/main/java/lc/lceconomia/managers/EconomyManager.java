package lc.lceconomia.managers;

import lc.lceconomia.model.LCoinsPlayer;
import lc.lceconomia.model.VipPointsPlayer;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

public class EconomyManager {
    private Map<UUID, LCoinsPlayer> LCoinsPlayers;
    private Map<UUID, VipPointsPlayer> VipPointsPlayers;

    public EconomyManager() {
        LCoinsPlayers = new HashMap<>();
        VipPointsPlayers = new HashMap<>();
    }

    public LCoinsPlayer getLCoinsPlayer(UUID uuid) {
        return LCoinsPlayers.get(uuid);
    }

    public LCoinsPlayer getLCoinsPlayer(String nickname) {
        for (LCoinsPlayer economy : LCoinsPlayers.values()) {
            if (economy.getNickname().equalsIgnoreCase(nickname)) {
                return economy;
            }
        }
        return null;
    }

    public void createLCoinsPlayer(UUID uuid, String nickname) {
        if (!LCoinsPlayers.containsKey(uuid)) {
            LCoinsPlayer economy = new LCoinsPlayer(uuid, nickname, 0);
            LCoinsPlayers.put(uuid, economy);
        }
    }

    public void removeVipPointsPlayer(UUID uuid) {
        VipPointsPlayers.remove(uuid);
    }

    public VipPointsPlayer getVipPointsPlayer(UUID uuid) {
        return VipPointsPlayers.get(uuid);
    }

    public VipPointsPlayer getVipPointsPlayer(String nickname) {
        for (VipPointsPlayer economy : VipPointsPlayers.values()) {
            if (economy.getNickname().equalsIgnoreCase(nickname)) {
                return economy;
            }
        }
        return null;
    }

    public void createVipPointsPlayer(UUID uuid, String nickname) {
        if (!VipPointsPlayers.containsKey(uuid)) {
            VipPointsPlayer economy = new VipPointsPlayer(uuid, nickname, 0);
            VipPointsPlayers.put(uuid, economy);
        }
    }

    public void removeLCoinsPlayer(UUID uuid) {
        LCoinsPlayers.remove(uuid);
    }
}
