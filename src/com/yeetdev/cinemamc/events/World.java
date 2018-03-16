package com.yeetdev.cinemamc.events;

import com.yeetdev.cinemamc.Main;
import org.bukkit.Bukkit;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockBreakEvent;
import org.bukkit.event.block.BlockPlaceEvent;
import org.bukkit.event.player.PlayerMoveEvent;
import org.bukkit.event.weather.WeatherChangeEvent;

public class World implements Listener {

    @EventHandler
    public void onBlockBreak(BlockBreakEvent e) {
        if (!Main.getInstance().buildModePlayers.contains(e.getPlayer().getUniqueId().toString())) {
            e.setCancelled(true);
        }
    }

    @EventHandler
    public void onBlockPlace(BlockPlaceEvent e) {
        if (!Main.getInstance().buildModePlayers.contains(e.getPlayer().getUniqueId().toString())) {
            e.setCancelled(true);
        }
    }

    @EventHandler
    public void onWeather(WeatherChangeEvent e) {
        e.setCancelled(true);
    }

    @EventHandler
    public void onPlayerMove(PlayerMoveEvent e){
        for (org.bukkit.World world : Bukkit.getServer().getWorlds()){
            if (world.getTime() >= 13000){
                world.setTime(0);
            }
        }
    }

}
