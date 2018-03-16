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

public class ToggleBuildCommand implements CommandExecutor {

    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String s, String[] args) {
        if (!(sender instanceof Player)) {
            return true;
        }
        Player p = (Player) sender;
        if (Rank.getRankLadder(p) >= 2) {
            CommandSpy.logCommand(p, "build");
            if (Main.getInstance().buildModePlayers.contains(p.getUniqueId().toString()) || p.getGameMode().equals(GameMode.CREATIVE)) {
                p.setGameMode(GameMode.ADVENTURE);
                try {
                    Main.getInstance().buildModePlayers.remove(p.getUniqueId().toString());
                } catch (IOError ioError) {
                    Main.error(ioError.toString());
                }
                Chat.sendMessage(p, "Build", "You are no longer in build mode.");
            } else {
                p.setGameMode(GameMode.CREATIVE);
                try {
                    Main.getInstance().buildModePlayers.add(p.getUniqueId().toString());
                } catch (IOError ioError) {
                    Main.error(ioError.toString());
                }
                Chat.sendMessage(p, "Build", "You are now in build mode.");
            }
        } else {
            Chat.permsError(p);
        }
        return true;
    }
}
