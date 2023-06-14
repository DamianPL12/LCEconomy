package lc.lceconomia.comandos;

import lc.lceconomia.LCEconomia;
import lc.lceconomia.managers.EconomyManager;
import lc.lceconomia.model.LCoinsPlayer;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;

public class RemoveLCoins extends SubComando{
    EconomyManager em = LCEconomia.getInstance().getEconomyManager();
    @Override
    public String getName() {
        return "remove";
    }

    @Override
    public String getSyntax() {
        return "/lcoins remove <jugador> <cantidad>";
    }

    @Override
    public String getDescription() {
        return "Quitar Lcoins.";
    }

    @Override
    public void perform(Player p, String[] args) {
        if(args.length > 2){
            Player t = Bukkit.getPlayer(args[1]);
            if(em.getLCoinsPlayer(t.getName()) == null){
                p.sendMessage(ChatColor.RED + "Ese jugador no esta registrado en la base de datos.");
                return;
            }
            LCoinsPlayer lc = em.getLCoinsPlayer(t.getName());
            double amount;
            try {
                amount = Double.parseDouble(args[2]);
            } catch (NumberFormatException e) {
                p.sendMessage(ChatColor.RED + "La cantidad debe ser un número válido.");
                return;
            }
            if (amount <= 0) {
                p.sendMessage(ChatColor.RED + "La cantidad debe ser mayor que cero.");
                return;
            }
            lc.subtractLCoins(amount);
            t.sendMessage(ChatColor.GREEN + "Se han removido " + ChatColor.GRAY + amount + ChatColor.GREEN +" LCoins a tu cuenta.");
            p.sendMessage(ChatColor.GREEN + "Se han removido " + ChatColor.GRAY + amount + ChatColor.GREEN +" LCoins a la cuenta de "+ChatColor.YELLOW+t.getName()+""+ChatColor.GREEN+".");
        }else{
            p.sendMessage(ChatColor.RED + "Usa: "+ChatColor.GRAY+getSyntax()+""+ChatColor.RED+".");
        }
    }
}
