import net.dv8tion.jda.api.MessageBuilder;
import net.dv8tion.jda.api.entities.*;
import net.dv8tion.jda.api.events.message.guild.GuildMessageReceivedEvent;
import net.dv8tion.jda.api.events.message.priv.PrivateMessageReceivedEvent;
import net.dv8tion.jda.api.events.message.react.MessageReactionAddEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;

import java.util.HashMap;


public class EventListener extends ListenerAdapter {

    public static final String guildID = "740916429951598683";
    public static final Guild guild = MainBot.jda.getGuildById(guildID);
    public static final TextChannel botcommands = guild.getTextChannelById("753640254917050579");
    public static final TextChannel botkonsole = guild.getTextChannelById("765256872936079401");

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
        rollenzuweisung.put("", guild.getRoleById("764933443137175562")); //Among Us
        rollenzuweisung.put("", guild.getRoleById("764933536671072267")); //CS-Go
        rollenzuweisung.put("", guild.getRoleById("764933376104202250")); //League of Legends
        rollenzuweisung.put("", guild.getRoleById("764933659505066005")); //Rainbow Six Siege
        rollenzuweisung.put("", guild.getRoleById("764934139190444113")); //Rocket League
        rollenzuweisung.put("", guild.getRoleById("764933303115186177")); //Sport
        rollenzuweisung.put("", guild.getRoleById("764933242012172341")); //Musik
        /*rollenzuweisung.put("", guild.getRoleById(""));
        rollenzuweisung.put("", guild.getRoleById(""));
        rollenzuweisung.put("", guild.getRoleById(""));*/
    }
    public void msg(String msg){
        botkonsole.sendMessage(msg).queue();
    }


    @Override
    public void onPrivateMessageReceived(PrivateMessageReceivedEvent event) {

        if (event.getAuthor().equals(MainBot.jda.getSelfUser()))
            return;

        befehlAusfuehren(event.getAuthor(), event.getMessage());

    }

    @Override
    public void onGuildMessageReceived(GuildMessageReceivedEvent event){

        if (event.getAuthor().equals(MainBot.jda.getSelfUser()))
            return;

        if (!event.getChannel().equals(botcommands))
            return;

        befehlAusfuehren(event.getAuthor(), event.getMessage());

    }


    @Override
    public void onMessageReactionAdd(MessageReactionAddEvent event){

        if (event.getUser().equals(MainBot.jda.getSelfUser()))
            return;

        if (event.getTextChannel().getId().equals("764936089001132072"))
            msg(event.getReactionEmote().getEmoji());

        /*if (!event.getTextChannel().getId().equals("764937703691124736"))
            return;

        guild.addRoleToMember(event.getMember(), rollenzuweisung.get(event.getReactionEmote().getEmoji()));*/
    }
    public void befehlAusfuehren(User user, Message message){

        Commands commands = Commands.eval(message.getContentRaw());
        MessageBuilder messageBuilder = new MessageBuilder();

        switch (commands){

            case hallo:
                messageBuilder.setContent("Hallo, ich bin ein Bot und kann noch nix :)");
                break;

            case termine:
                messageBuilder.setContent("Das Termin-feature ist noch in der Entwicklung");
                break;

            case help:
                Ausgaben.help(user);
                return;

            case unknown:
                messageBuilder.setContent("Unbekannter Befehl, sryyyyy OwO");
                break;

            case stundenplan:
                Ausgaben.stundenplan(user);
                return;

            case conversation:
                Ausgaben.conversation(user);
                return;
        }

         user.openPrivateChannel().queue(channel -> channel.sendMessage(messageBuilder.build()).queue());;

    }

}
