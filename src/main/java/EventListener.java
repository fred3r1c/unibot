import net.dv8tion.jda.api.entities.Guild;
import net.dv8tion.jda.api.entities.TextChannel;
import net.dv8tion.jda.api.events.message.MessageReceivedEvent;
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
    public void onPrivateMessageReceived(PrivateMessageReceivedEvent event){
        if (event.getAuthor().equals(MainBot.jda.getSelfUser()))
            return;
        event.getChannel().sendMessage("Hallo du hurensohn").queue();

    }

    @Override
    public void onMessageReceived(MessageReceivedEvent event){

        if (event.getAuthor().equals(MainBot.jda.getSelfUser()))
            return;

        if (!event.getTextChannel().equals(botcommands))
            return;

        Commands commands = Commands.eval(event.getMessage().getContentRaw());

        switch (commands){

            case hallo:
                event.getAuthor().openPrivateChannel().queue(channel -> channel.sendMessage("Hallo, ich bin ein Bot und kann noch nix :)").queue());
                break;

            case termine:
                event.getAuthor().openPrivateChannel().queue(channel -> channel.sendMessage("Das Termin-feature ist noch in der Entwicklung").queue());
                break;

            case help:
                event.getAuthor().openPrivateChannel().queue(channel -> channel.sendMessage("Das Help-feature ist noch in der Entwicklung\nBis dahin: https://www.youtube.com/watch?v=Dh-CW22axyY").queue());

            case unknown:
                event.getAuthor().openPrivateChannel().queue(channel -> channel.sendMessage("unknown command ").queue());
        }


    }

}
