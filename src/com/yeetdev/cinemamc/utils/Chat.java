package com.yeetdev.cinemamc.utils;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;

public class Chat {

    public static boolean chatMuted = false;

    public static String sendColorFree(String msg) {
        return ChatColor.translateAlternateColorCodes('&', msg);
    }

    public static void permsError(Player player) {
        player.sendMessage(sendColorFree("&7Permissions » &cYou do not have permission to execute this command."));
    }

    public static void sendMessage(Player player, String topic, String msg) {
        player.sendMessage(sendColorFree("&7" + topic + "&7 » &b" + msg));
    }

    public static void announce(String msg) {
        Bukkit.getServer().broadcastMessage(sendColorFree("&7&lAnnouncement &4&7» &b" + msg));
    }

}
