package com.yeetdev.cinemamc.utils;

import com.yeetdev.cinemamc.Main;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;

import static org.bukkit.Bukkit.getOnlinePlayers;

public class CommandSpy {

    public static void logCommand(Player p, String cmd) {
        for (Player pl : Bukkit.getOnlinePlayers()) {
            if (pl == p) return;
            if (Main.getInstance().commandSpyPlayers.contains(pl.getUniqueId().toString())) {
                Chat.sendMessage(pl, "Command Spy", p.getName() + ": /" + cmd);
            }
        }
        Main.log(p.getName() + ": /" + cmd);
    }

}
