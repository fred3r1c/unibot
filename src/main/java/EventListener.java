import net.dv8tion.jda.api.MessageBuilder;
import net.dv8tion.jda.api.entities.*;
import net.dv8tion.jda.api.events.message.guild.GuildMessageReceivedEvent;
import net.dv8tion.jda.api.events.message.priv.PrivateMessageReceivedEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;


public class EventListener extends ListenerAdapter {

    public static final String guildID = "740916429951598683";
    public static final Guild guild = MainBot.jda.getGuildById(guildID);
    public static final TextChannel botcommands = guild.getTextChannelById("753640254917050579");
    public static final TextChannel botkonsole = guild.getTextChannelById("753640621855604908");

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
                return;

            case stundenplan:

                Ausgaben.stundenplan(user);
                return;

        }

         user.openPrivateChannel().queue(channel -> channel.sendMessage(messageBuilder.build()).queue());;

    }

}
