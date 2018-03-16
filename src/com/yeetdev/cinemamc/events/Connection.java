package com.yeetdev.cinemamc.events;

import com.yeetdev.cinemamc.utils.Chat;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerQuitEvent;

public class Connection implements Listener {

    @EventHandler
    public void onJoin(PlayerJoinEvent e) {
        e.setJoinMessage(Chat.sendColorFree("&7[&b+&7] &b" + e.getPlayer().getName()));
    }

    @EventHandler
    public void onLeave(PlayerQuitEvent e) {
        e.setQuitMessage(Chat.sendColorFree("&7[&c-&7] &c" + e.getPlayer().getName()));
    }

}

