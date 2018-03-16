package com.yeetdev.cinemamc.commands;

import com.google.common.base.Joiner;
import com.yeetdev.cinemamc.utils.Chat;
import com.yeetdev.cinemamc.utils.CommandSpy;
import com.yeetdev.cinemamc.utils.Rank;
import org.apache.commons.lang.StringUtils;
import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class MessageCommand implements CommandExecutor {

    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String s, String[] args) {
        if (!(sender instanceof Player)) {
            return true;
        }
        Player p = (Player) sender;
        if (!(args.length >= 2)) {
            Chat.sendMessage(p, "Command", "Please do /msg (User) (Message)");
            return true;
        }
        Player targp = Bukkit.getPlayer(args[0]);
        if(targp != null) {
            String message = StringUtils.join(args, ' ', 1, args.length);
            Chat.sendMessage(p, "Message", "To " + targp.getName() + ": " + message);
            Chat.sendMessage(targp, "Message", "From " + p.getName() + ": " + message);
            CommandSpy.logCommand(p, "msg " + Joiner.on(' ').join(args));
        } else{
            Chat.sendMessage(p, "Message", "That player is not online!");
        }
        return true;
    }

}





