package com.yeetdev.cinemamc.utils;

import org.bukkit.entity.Player;

import ru.tehkode.permissions.PermissionUser;
import ru.tehkode.permissions.bukkit.PermissionsEx;

public class Rank  {
    public static int getRankLadder(Player p) {
        PermissionUser user = PermissionsEx.getUser(p);
        if (user.inGroup("default")) {
            return 0;
        } else if (user.inGroup("CM")) {
            return 1;
        } else if (user.inGroup("FC")) {
            return 2;
        } else if (user.inGroup("SC")) {
            return 2;
        } else if (user.inGroup("DT")) {
            return 2;
        } else if (user.inGroup("Tech")) {
            return 2;
        } else if (user.inGroup("AR")) {
            return 2;
        } else if (user.inGroup("Coord")) {
            return 3;
        } else if (user.inGroup("StageM")) {
            return 4;
        } else if (user.inGroup("StudioM")) {
            return 4;
        } else if (user.inGroup("StageD")) {
            return 5;
        } else if (user.inGroup("StudioD")) {
            return 5;
        } else if (user.inGroup("SystemsD")) {
            return 6;
        } else {
            return 0;
        }

    }

    public static String getRankString(Player p) {
        PermissionUser user = PermissionsEx.getUser(p);
        if (user.inGroup("default")) {
            return "Guest";
        } else if (user.inGroup("CM")) {
            return "Cast Member";
        } else if (user.inGroup("FC")) {
            return "Film Crew";
        } else if (user.inGroup("SC")) {
            return "Stage Crew";
        } else if (user.inGroup("DT")) {
            return "Design Team";
        } else if (user.inGroup("Tech")) {
            return "Technician";
        } else if (user.inGroup("AR")) {
            return "Architect";
        } else if (user.inGroup("Coord")) {
            return "Coordinator";
        } else if (user.inGroup("StageM")) {
            return "Stage Manager";
         }else if (user.inGroup("StudioM")) {
            return "Studio Manager";
        } else if (user.inGroup("StageD")) {
            return "Stage Director";
        } else if (user.inGroup("StudioD")) {
            return "Studio Director";
        } else if (user.inGroup("SystemsD")) {
            return "Systems Director";
        } else {
            return "Guest";
        }
    }

    public static String getRankPrefix(Player p) {
        PermissionUser user = PermissionsEx.getUser(p);
        if (user.inGroup("default")) {
            return "";
        } else if (user.inGroup("CM")) {
            return "&7[&a&lCast Member&r&7]";
        } else if (user.inGroup("FC")) {
            return "&7[&6&lFilm Crew&r&7]";
        } else if (user.inGroup("SC")) {
            return "&7[&6&lStage Crew&r&7]";
        } else if (user.inGroup("DT")) {
            return "&7[&6&lDesign Team&r&7]";
        } else if (user.inGroup("Tech")) {
            return "&7[&6&lTechnician&r&7]";
        } else if (user.inGroup("AR")) {
            return "&7[&6&lArchitect&r&7]";
        } else if (user.inGroup("Coord")) {
            return "&7[&e&lCoordinator&r&7]";
        } else if (user.inGroup("StageM")) {
            return "&7[&3&lStage Manager&r&7]";
        } else if (user.inGroup("StudioM")) {
            return "&7[&3&lStudio Manager&r&7]";
        } else if (user.inGroup("StageD")) {
            return "&7[&b&lStage Director&r&7]";
        } else if (user.inGroup("StudioD")) {
            return "&7[&b&lStudio Director&r&7]";
        } else if (user.inGroup("SystemsD")) {
            return "&7[&b&lSystems Director&r&7]";
        } else {
            return "";
        }
    }

    public static String getRankColor(Player p) {
        PermissionUser user = PermissionsEx.getUser(p);
        if (user.inGroup("default")) {
            return "&7";
        } else if (user.inGroup("CM")) {
            return "&a";
        } else if (user.inGroup("FC")) {
            return "&6";
        } else if (user.inGroup("SC")) {
            return "&6";
        } else if (user.inGroup("DT")) {
            return "&6";
        } else if (user.inGroup("Tech")) {
            return "&6";
        } else if (user.inGroup("AR")) {
            return "&6";
        } else if (user.inGroup("Coord")) {
            return "&e";
        } else if (user.inGroup("StageM")) {
            return "&3";
        } else if (user.inGroup("StudioM")) {
            return "&3";
        } else if (user.inGroup("StageD")) {
            return "&b";
        } else if (user.inGroup("StudioD")) {
            return "&b";
        } else if (user.inGroup("SystemsD")) {
            return "&b";
        } else {
            return "&7";
        }

    }
}