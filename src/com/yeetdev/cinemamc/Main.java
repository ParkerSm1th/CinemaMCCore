package com.yeetdev.cinemamc;

import com.yeetdev.cinemamc.commands.*;
import com.yeetdev.cinemamc.events.Connection;
import com.yeetdev.cinemamc.events.Message;
import com.yeetdev.cinemamc.events.World;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.GameMode;
import org.bukkit.Server;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.command.ConsoleCommandSender;
import org.bukkit.entity.Player;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.ArrayList;

public class Main extends JavaPlugin {

    static Server server = Bukkit.getServer();

    private static Main instance;

    private static com.yeetdev.cinemamc.Main m;

    public ArrayList<String> buildModePlayers = new ArrayList<String>();
    public ArrayList<String> commandSpyPlayers = new ArrayList<String>();


    static ConsoleCommandSender console = server.getConsoleSender();

    public static void warn(String msg) {
        console.sendMessage(ChatColor.YELLOW + "CMC WARN > " + msg);
    }

    public static void error(String msg) {
        console.sendMessage( ChatColor.RED + "CMC ERROR > " + msg);
    }

    public static void success(String msg) {
        console.sendMessage( ChatColor.GREEN + "CMC SUCCESS > " + msg);
    }

    public static void bigerror(String msg) {
        console.sendMessage( ChatColor.DARK_RED + "CMC CRASH WORTHY ERROR > " + msg);
    }

    public static void log(String msg) {
        console.sendMessage( ChatColor.GRAY + "CMC LOG > " + msg);
    }

    @Override
    public void onEnable() {
        log("CMC Core is loading..");
        instance = this;
        registerCommands();
        registerEvents();
        success("CMC Core has loaded.");

    }

    @Override
    public void onDisable() {
        log("CMC Core is unloading..");
        instance = null;
        for (Player pl : Bukkit.getOnlinePlayers()) {
            pl.setGameMode(GameMode.ADVENTURE);
        }
        success("CMC Core has unloaded.");
    }

    public static Main getInstance() {
        return instance;
    }

    public void registerCommands() {
        getCommand("build").setExecutor(new ToggleBuildCommand());
        getCommand("setrank").setExecutor(new SetRankCommand());
        getCommand("fly").setExecutor(new FlyCommand());
        getCommand("cc").setExecutor(new ClearChatCommand());
        getCommand("mc").setExecutor(new MuteChatCommand());
        getCommand("ranks").setExecutor(new RanksCommand());
        getCommand("tp").setExecutor(new TPCommand());
        getCommand("tpall").setExecutor(new TPAllCommand());
        getCommand("spy").setExecutor(new CommandSpyCommand());
    }

    public void registerEvents() {
        PluginManager pm = Bukkit.getPluginManager();
        pm.registerEvents(new World(), this);
        pm.registerEvents(new Connection(), this);
        pm.registerEvents(new Message(), this);
    }


}
