package com.yeetdev.cinemamc.commands;

import com.google.common.base.Joiner;
import com.yeetdev.cinemamc.Main;
import com.yeetdev.cinemamc.utils.Chat;
import com.yeetdev.cinemamc.utils.CommandSpy;
import com.yeetdev.cinemamc.utils.Rank;
import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import java.io.IOError;
import java.util.Arrays;

public class SetRankCommand implements CommandExecutor {

    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String s, String[] args) {
        if (!(sender instanceof Player)) {
            return true;
        }
        Player p = (Player) sender;
        if (Rank.getRankLadder(p) >= 5) {
            CommandSpy.logCommand(p, "setrank " + Joiner.on(' ').join(args));
            if (args.length == 2) {
                if (args[1].equalsIgnoreCase("guest")) {
                    Bukkit.dispatchCommand(Bukkit.getConsoleSender(), "pex user " + args[0] + " group set default");
                    Chat.sendMessage(p, "Ranking", "Updated " + args[0] + "'s rank to Guest.");
                } else if (args[1].equalsIgnoreCase("CM")) {
                    Bukkit.dispatchCommand(Bukkit.getConsoleSender(), "pex user " + args[0] + " group set CM");
                    Chat.sendMessage(p, "Ranking", "Updated " + args[0] + "'s rank to CM.");
                } else if (args[1].equalsIgnoreCase("FC")) {
                    Bukkit.dispatchCommand(Bukkit.getConsoleSender(), "pex user " + args[0] + " group set FC");
                    Chat.sendMessage(p, "Ranking", "Updated " + args[0] + "'s rank to Film Crew.");
                } else if (args[1].equalsIgnoreCase("SC")) {
                    Bukkit.dispatchCommand(Bukkit.getConsoleSender(), "pex user " + args[0] + " group set SC");
                    Chat.sendMessage(p, "Ranking", "Updated " + args[0] + "'s rank to Stage Crew.");
                } else if (args[1].equalsIgnoreCase("DT")) {
                    Bukkit.dispatchCommand(Bukkit.getConsoleSender(), "pex user " + args[0] + " group set DT");
                    Chat.sendMessage(p, "Ranking", "Updated " + args[0] + "'s rank to Design Team.");
                } else if (args[1].equalsIgnoreCase("Tech")) {
                    Bukkit.dispatchCommand(Bukkit.getConsoleSender(), "pex user " + args[0] + " group set Tech");
                    Chat.sendMessage(p, "Ranking", "Updated " + args[0] + "'s rank to Technician.");
                } else if (args[1].equalsIgnoreCase("AR")) {
                    Bukkit.dispatchCommand(Bukkit.getConsoleSender(), "pex user " + args[0] + " group set AR");
                    Chat.sendMessage(p, "Ranking", "Updated " + args[0] + "'s rank to Architect.");
                } else if (args[1].equalsIgnoreCase("Coord")) {
                    Bukkit.dispatchCommand(Bukkit.getConsoleSender(), "pex user " + args[0] + " group set Coord");
                    Chat.sendMessage(p, "Ranking", "Updated " + args[0] + "'s rank to Coordinator.");
                } else if (args[1].equalsIgnoreCase("StageM")) {
                    Bukkit.dispatchCommand(Bukkit.getConsoleSender(), "pex user " + args[0] + " group set StageM");
                    Chat.sendMessage(p, "Ranking", "Updated " + args[0] + "'s rank to Stage Manager.");
                } else if (args[1].equalsIgnoreCase("StudioM")) {
                    Bukkit.dispatchCommand(Bukkit.getConsoleSender(), "pex user " + args[0] + " group set StudioM");
                    Chat.sendMessage(p, "Ranking", "Updated " + args[0] + "'s rank to Studio Manager.");
                } else if (args[1].equalsIgnoreCase("StageD")) {
                    Bukkit.dispatchCommand(Bukkit.getConsoleSender(), "pex user " + args[0] + " group set StageD");
                    Chat.sendMessage(p, "Ranking", "Updated " + args[0] + "'s rank to Stage Director.");
                } else if (args[1].equalsIgnoreCase("StudioD")) {
                    Bukkit.dispatchCommand(Bukkit.getConsoleSender(), "pex user " + args[0] + " group set StudioD");
                    Chat.sendMessage(p, "Ranking", "Updated " + args[0] + "'s rank to Studio Director.");
                } else if (args[1].equalsIgnoreCase("SystemsD")) {
                    Bukkit.dispatchCommand(Bukkit.getConsoleSender(), "pex user " + args[0] + " group set SystemsD");
                    Chat.sendMessage(p, "Ranking", "Updated " + args[0] + "'s rank to Systems Director.");

                } else {
                    Chat.sendMessage(p, "Command", "That is not a valid rank! - Do /ranks for a list of ranks.");
                }
                return true;
            } else {
                Chat.sendMessage(p, "Command", "Please do /setrank (Username) (Rank) - Do /ranks for a list of ranks.");
            }
        } else {
            Chat.permsError(p);
        }
        return true;
    }

}
