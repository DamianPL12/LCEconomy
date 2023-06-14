package lc.lceconomia.comandos;

import lc.lceconomia.LCEconomia;
import lc.lceconomia.managers.EconomyManager;
import lc.lceconomia.model.LCoinsPlayer;
import lc.lceconomia.model.VipPointsPlayer;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;

public class GiveVipPoints extends SubComando{
    EconomyManager em = LCEconomia.getInstance().getEconomyManager();
    @Override
    public String getName() {
        return "give";
    }

    @Override
    public String getSyntax() {
        return "/vippoints give <jugador> <cantidad>";
    }

    @Override
    public String getDescription() {
        return "Dar VipPoints.";
    }

    @Override
    public void perform(Player p, String[] args) {
        if(args.length > 2){
            Player t = Bukkit.getPlayer(args[1]);
            if(em.getVipPointsPlayer(t.getName()) == null){
                p.sendMessage(ChatColor.RED + "Ese jugador no esta registrado en la base de datos.");
                return;
            }
            VipPointsPlayer vp = em.getVipPointsPlayer(t.getName());
            int amount;
            try {
                amount = Integer.parseInt(args[2]);
            } catch (NumberFormatException e) {
                p.sendMessage(ChatColor.RED + "La cantidad debe ser un número válido.");
                return;
            }
            if (amount <= 0) {
                p.sendMessage(ChatColor.RED + "La cantidad debe ser mayor que cero.");
                return;
            }
            vp.addVipPoints(amount);
            t.sendMessage(ChatColor.GREEN + "Se han agregado " + ChatColor.GRAY + amount + ChatColor.GREEN +" VipPoints a tu cuenta.");
            p.sendMessage(ChatColor.GREEN + "Se han agregado " + ChatColor.GRAY + amount + ChatColor.GREEN +" VipPoints a la cuenta de "+ChatColor.YELLOW+t.getName()+""+ChatColor.GREEN+".");
        }else{
            p.sendMessage(ChatColor.RED + "Usa: "+ChatColor.GRAY+getSyntax()+""+ChatColor.RED+".");
        }
    }
}
