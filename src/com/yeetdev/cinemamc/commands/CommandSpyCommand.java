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

public class CommandSpyCommand implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String s, String[] args) {
        if (!(sender instanceof Player)) {
            return true;
        }
        Player p = (Player) sender;
        if (Rank.getRankLadder(p) >= 4) {
            CommandSpy.logCommand(p, "spy");
            if (Main.getInstance().commandSpyPlayers.contains(p.getUniqueId().toString())) {
                try {
                    Main.getInstance().commandSpyPlayers.remove(p.getUniqueId().toString());
                } catch (IOError ioError) {
                    Main.error(ioError.toString());
                }
                Chat.sendMessage(p, "Command Spy", "You can no longer see command spy.");
            } else {
                try {
                    Main.getInstance().commandSpyPlayers.add(p.getUniqueId().toString());
                } catch (IOError ioError) {
                    Main.error(ioError.toString());
                }
                Chat.sendMessage(p, "Command Spy", "You can now see command spy.");
            }
        } else {
            Chat.permsError(p);
        }
        return true;
    }
}
