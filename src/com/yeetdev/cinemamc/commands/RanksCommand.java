package com.yeetdev.cinemamc.commands;

import com.yeetdev.cinemamc.utils.Chat;
import com.yeetdev.cinemamc.utils.CommandSpy;
import com.yeetdev.cinemamc.utils.Rank;
import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class RanksCommand implements CommandExecutor {

    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String s, String[] args) {
        if (!(sender instanceof Player)) {
            return true;
        }
        Player p = (Player) sender;
        if (Rank.getRankLadder(p) >= 4) {
           Chat.sendMessage(p, "Ranking", "Rank List:\nGuest - Default\nCM - Cast Member\nFC - Film Crew\nSC - Stage Crew\nDT - Design Team\nTech - Technician\nAR - Architect\nCoord - Coordinator\nStageM - Stage Manager\nStudioM - Studio Manager\nStageD - Stage Director\nStudioD - Studio Director\nSystemsD - Systems Director");
           return true;
        } else {
            Chat.permsError(p);
        }
        return true;
    }

}
