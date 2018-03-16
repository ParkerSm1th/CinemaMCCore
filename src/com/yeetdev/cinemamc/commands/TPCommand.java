package com.yeetdev.cinemamc.commands;

import com.google.common.base.Joiner;
import com.yeetdev.cinemamc.Main;
import com.yeetdev.cinemamc.events.Message;
import com.yeetdev.cinemamc.utils.Chat;
import com.yeetdev.cinemamc.utils.CommandSpy;
import com.yeetdev.cinemamc.utils.Rank;
import org.bukkit.Bukkit;
import org.bukkit.GameMode;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import java.io.IOError;

public class TPCommand implements CommandExecutor {

    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String s, String[] args) {
        if (!(sender instanceof Player)) {
            return true;
        }
        Player p = (Player) sender;
        if (Rank.getRankLadder(p) >= 2) {
            CommandSpy.logCommand(p, "tp" + Joiner.on(' ').join(args));
            if(args.length == 0) {
                Chat.sendMessage(p, "Command", "Please do /tp (Player)");
            } else if (args.length == 1) {
                Player targp = Bukkit.getPlayer(args[0]);
                if(targp != null)
                {
                    p.teleport(targp);
                    Chat.sendMessage(p, "Teleport", "Teleported to " + targp.getName());
                } else{
                    Chat.sendMessage(p, "Teleport", "That player is not online!");
                }
            } else if(args.length > 1) {
                Chat.sendMessage(p, "Command", "Please do /tp (Player)");
            }
        } else {
            Chat.permsError(p);
        }
        return true;
    }

}
