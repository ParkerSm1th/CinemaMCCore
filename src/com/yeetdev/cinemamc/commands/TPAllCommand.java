package com.yeetdev.cinemamc.commands;

import com.google.common.base.Joiner;
import com.yeetdev.cinemamc.utils.Chat;
import com.yeetdev.cinemamc.utils.CommandSpy;
import com.yeetdev.cinemamc.utils.Rank;
import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.event.player.PlayerTeleportEvent;

public class TPAllCommand implements CommandExecutor {

    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String s, String[] args) {
        if (!(sender instanceof Player)) {
            return true;
        }
        Player p = (Player) sender;
        if (Rank.getRankLadder(p) >= 2) {
            if(args.length == 0) {
                Location l = p.getLocation();
                for(Player onlinePlayer : Bukkit.getOnlinePlayers()) {
                    onlinePlayer.teleport(l, PlayerTeleportEvent.TeleportCause.COMMAND);

                }
                Chat.sendMessage(p, "Teleport", "Teleported all players to you.");

            } else if (args.length > 0) {
                Chat.sendMessage(p, "Command", "Please do /tpall");

            }


        } else {
            Chat.permsError(p);
        }
        return true;
    }

}
