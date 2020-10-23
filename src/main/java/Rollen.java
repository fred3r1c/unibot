package main.java;

import jdk.internal.event.Event;
import net.dv8tion.jda.api.entities.Guild;
import net.dv8tion.jda.api.entities.MessageReaction;
import net.dv8tion.jda.api.entities.Role;
import main.java.EventListener;
import net.dv8tion.jda.api.events.message.react.MessageReactionAddEvent;
import net.dv8tion.jda.api.events.message.react.MessageReactionRemoveEvent;

import java.util.HashMap;

public class Rollen {

    private static final Guild guild = EventListener.guild;

    public static final HashMap<String, Role> rollenzuweisung = new HashMap<String, Role>();

    static {
        rollenzuweisung.put("\uD83D\uDCC8", guild.getRoleById("764937834863001610")); //Analysis 1
        rollenzuweisung.put("\uD83D\uDC7E", guild.getRoleById("764938020688101426")); //Digitaltechnik
        rollenzuweisung.put("\uD83E\uDDEE", guild.getRoleById("764938234253672478")); //Lineare Algebra
        rollenzuweisung.put("\uD83D\uDCBB", guild.getRoleById("764938237109075988")); //Computertechnik
        rollenzuweisung.put("\uD83D\uDD79", guild.getRoleById("764938239558942740")); //Schaltungtheorie
        rollenzuweisung.put("\uD83D\uDC23", guild.getRoleById("764938487434051604")); //Mathe-Vorkurs
        rollenzuweisung.put("\uD83D\uDCF8", guild.getRoleById("764954188706611210")); //Insta
        rollenzuweisung.put("\uD83D\uDC7B", guild.getRoleById("764954190212235275")); //Snap
        rollenzuweisung.put("\uD83E\uDD86", guild.getRoleById("764954419832815686")); //Twitter
        rollenzuweisung.put("AmongUs", guild.getRoleById("764933443137175562")); //Among Us
        rollenzuweisung.put("CSGO", guild.getRoleById("764933536671072267")); //CS-Go
        rollenzuweisung.put("LoL", guild.getRoleById("764933376104202250")); //League of Legends
        rollenzuweisung.put("R6", guild.getRoleById("764933659505066005")); //Rainbow Six Siege
        rollenzuweisung.put("RL", guild.getRoleById("764934139190444113")); //Rocket League
        rollenzuweisung.put("\uD83D\uDEB4", guild.getRoleById("764933303115186177")); //Sport
        rollenzuweisung.put("\uD83C\uDFB6", guild.getRoleById("764933242012172341")); //Musik
        rollenzuweisung.put("✅", guild.getRoleById("769174582468542507")); //Regeln
    }

    public static void regelnadd(MessageReactionAddEvent event){

        guild.addRoleToMember(event.getMember(), rollenzuweisung.get(event.getReactionEmote().getEmoji())).queue();

    }

    public static void regelnrem(MessageReactionRemoveEvent event){

        guild.removeRoleFromMember(event.getMember(), rollenzuweisung.get(event.getReactionEmote().getEmoji())).queue();

    }

    public static void rollenVerteilungadd(MessageReactionAddEvent event){

        if (event.getReactionEmote().isEmoji())
            guild.addRoleToMember(event.getMember(), rollenzuweisung.get(event.getReactionEmote().getEmoji())).queue();

        if (event.getReactionEmote().isEmote())
            guild.addRoleToMember(event.getMember(), rollenzuweisung.get(event.getReactionEmote().getEmote().getName())).queue();

    }

    public static void rollenVerteilungrem(MessageReactionRemoveEvent event){

        if (event.getReactionEmote().isEmoji())
            guild.removeRoleFromMember(event.getMember(), rollenzuweisung.get(event.getReactionEmote().getEmoji())).queue();

        if (event.getReactionEmote().isEmote())
            guild.removeRoleFromMember(event.getMember(), rollenzuweisung.get(event.getReactionEmote().getEmote().getName())).queue();


    }

}
