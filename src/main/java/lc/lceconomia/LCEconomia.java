package lc.lceconomia;

import lc.lceconomia.comandos.LCoinsComandoBase;
import lc.lceconomia.managers.EconomyManager;
import org.bukkit.plugin.java.JavaPlugin;

public final class LCEconomia extends JavaPlugin {

    EconomyManager economyManager;

    private static LCEconomia instance;

    public static LCEconomia getInstance() {
        return instance;
    }

    @Override
    public void onEnable() {
        instance = this;
        economyManager = new EconomyManager();

        getCommand("lcoins").setExecutor(new LCoinsComandoBase());
        getCommand("lcoins").setTabCompleter(new LCoinsComandoBase());

        getCommand("vippoints").setExecutor(new LCoinsComandoBase());
        getCommand("vippoints").setTabCompleter(new LCoinsComandoBase());
    }
    @Override
    public void onDisable() {
        instance = null;
        economyManager = null;
    }

    public EconomyManager getEconomyManager() {
        return economyManager;
    }
}
