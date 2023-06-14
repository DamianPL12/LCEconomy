package lc.lceconomia.comandos;

import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.command.TabCompleter;
import org.bukkit.entity.Player;

import java.util.ArrayList;
import java.util.List;

public class LCoinsComandoBase implements CommandExecutor, TabCompleter {

    List<SubComando> subComandos = new ArrayList<>();

    public LCoinsComandoBase() {
        subComandos.add(new GiveLCoins());
        subComandos.add(new RemoveLCoins());
        subComandos.add(new SetLCoins());
    }

    @Override
    public boolean onCommand(CommandSender commandSender, Command command, String s, String[] strings) {
        if(commandSender instanceof Player) {
            Player p = (Player) commandSender;
            if(strings.length > 0) {
                for(int i = 0 ; i < subComandos.size() ; i++) {
                    if(strings[0].equalsIgnoreCase(subComandos.get(i).getName())) {
                        if(p.hasPermission("lcoins."+subComandos.get(i).getName())) {
                            subComandos.get(i).perform(p, strings);
                            return true;
                        }else {
                            p.sendMessage(ChatColor.translateAlternateColorCodes('&', "No tienes permisos."));
                            return true;
                        }
                    }
                }
                p.sendMessage(ChatColor.translateAlternateColorCodes('&', "&e▏ &bListado de Sub-Comandos:"));
                for(SubComando scmd : subComandos) {
                    p.sendMessage(ChatColor.translateAlternateColorCodes('&',"&e▏ &e"+scmd.getSyntax()+" &7- &f"+scmd.getDescription()));
                }

            }else {
                p.sendMessage(ChatColor.translateAlternateColorCodes('&', "&e▏ &bListado de Sub-Comandos:"));
                for(SubComando scmd : subComandos) {
                    p.sendMessage(ChatColor.translateAlternateColorCodes('&',"&e▏ &e"+scmd.getSyntax()+" &7- &f"+scmd.getDescription()));
                }
            }
        }
        return true;

    }

    @Override
    public List<String> onTabComplete(CommandSender commandSender, Command command, String s, String[] strings) {
        List<String> l = new ArrayList<>();
        for(SubComando sc : subComandos){
            l.add(sc.getName());
        }
        return l;
    }
}
