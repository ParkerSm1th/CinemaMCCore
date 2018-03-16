package com.yeetdev.cinemamc.commands;

import com.yeetdev.cinemamc.Main;
import com.yeetdev.cinemamc.utils.Chat;
import com.yeetdev.cinemamc.utils.CommandSpy;
import com.yeetdev.cinemamc.utils.Rank;
import org.bukkit.GameMode;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import java.io.IOError;

public class FlyCommand implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String s, String[] args) {
        if (!(sender instanceof Player)) {
            return true;
        }
        Player p = (Player) sender;
        if (Rank.getRankLadder(p) >= 1) {
            CommandSpy.logCommand(p, "fly");
            if (p.isFlying()) {
                p.setAllowFlight(false);
                p.setFlying(false);
                Chat.sendMessage(p, "Flight", "You can no longer fly.");
            } else {
                p.setAllowFlight(true);
                p.setFlying(true);
                Chat.sendMessage(p, "Flight", "You can now fly.");
            }
        } else {
            Chat.permsError(p);
        }
        return true;
    }
}
