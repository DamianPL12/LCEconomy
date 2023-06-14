package lc.lceconomia.comandos;

import org.bukkit.entity.Player;

public abstract class SubComando {
    public abstract String getName();

    public abstract String getSyntax();

    public abstract String getDescription();

    public abstract void perform(Player p, String args[]);
}
