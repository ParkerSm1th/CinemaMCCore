package com.yeetdev.cinemamc.events;

import com.yeetdev.cinemamc.utils.Chat;
import com.yeetdev.cinemamc.utils.Rank;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.player.AsyncPlayerChatEvent;
import org.bukkit.event.player.PlayerChatEvent;
import org.bukkit.event.player.PlayerCommandPreprocessEvent;
import org.bukkit.help.HelpTopic;

import java.util.ArrayList;
import java.util.List;

public class Message implements Listener {

    @EventHandler(priority= EventPriority.HIGHEST)
    public void onPlayerCommandPreprocess(PlayerCommandPreprocessEvent event)
    {
        Player p = event.getPlayer();
        if (!event.isCancelled())
        {
            String command = event.getMessage().split(" ")[0];
            HelpTopic htopic = Bukkit.getServer().getHelpMap().getHelpTopic(command);
            if (htopic == null)
            {
                Chat.sendMessage(p, "Command", "This command does not exist!");
                event.setCancelled(true);
            }


        }
    }

    @EventHandler(priority = EventPriority.LOWEST)
    public void onCommandPreProcess(PlayerCommandPreprocessEvent event) {

        Player player = event.getPlayer();
        Player p = event.getPlayer();
        String cmd = event.getMessage().toLowerCase();

        if (cmd.startsWith("/kill")) {
            event.setCancelled(true);
            Chat.permsError(p);
        }
        if (cmd.startsWith("/minecraft:")) {
            event.setCancelled(true);
            Chat.permsError(p);
        }



    }



    @EventHandler(priority = EventPriority.HIGHEST)
    public void onCommandPreProcess2(PlayerCommandPreprocessEvent e) {
        String[] msg = e.getMessage().split(" ");
        Player p = e.getPlayer();

        List<String> plugins = new ArrayList();
        plugins.add("pl");
        plugins.add("plugins");
        plugins.add("bukkit:pl");
        plugins.add("bukkit:plugins");
        plugins.add("plugins");

        List<String> version = new ArrayList();
        version.add("ver");
        version.add("version");
        version.add("bukkit:ver");
        version.add("bukkit:version");

        List<String> about = new ArrayList();
        about.add("about");
        about.add("bukkit:about");

        List<String> question = new ArrayList();
        question.add("?");
        question.add("help");
        question.add("bukkit:?");
        if (Rank.getRankLadder(p) >= 5) {

        } else {
            for (String Loop : plugins) {
                if (msg[0].equalsIgnoreCase("/" + Loop)) {

                    e.setCancelled(true);
                    Chat.permsError(p);
                }
            }


            for (String Loop : version) {
                if (msg[0].equalsIgnoreCase("/" + Loop)) {

                    e.setCancelled(true);
                    Chat.permsError(p);
                }
            }


            for (String Loop : question) {
                if (msg[0].equalsIgnoreCase("/" + Loop)) {

                    e.setCancelled(true);
                    Chat.permsError(p);
                }
            }


            for (String Loop : about) {
                if (msg[0].equalsIgnoreCase("/" + Loop)) {

                    e.setCancelled(true);
                    Chat.permsError(p);
                }
            }
        }

    }



}
