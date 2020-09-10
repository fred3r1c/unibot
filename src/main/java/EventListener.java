import net.dv8tion.jda.api.entities.Guild;
import net.dv8tion.jda.api.entities.GuildChannel;
import net.dv8tion.jda.api.entities.TextChannel;
import net.dv8tion.jda.api.events.message.priv.PrivateMessageReceivedEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;


public class EventListener extends ListenerAdapter {

    public static final String guildID = "740916429951598683740916429951598683";
    public static final Guild guild = MainBot.jda.getGuildById(guildID);
    public static final TextChannel botcommands = guild.getTextChannelById("753640254917050579");
    public static final TextChannel botkonsole = guild.getTextChannelById("753640621855604908");
    public void msg(String msg){
        botkonsole.sendMessage(msg);
    }


    @Override
    public void onPrivateMessageReceived(PrivateMessageReceivedEvent event){
        if (event.getAuthor().equals(MainBot.jda.getSelfUser()))
            return;
        msg("hab dich lieb, mein Schöpfer");
        event.getChannel().sendMessage("Hallo du hurensohn").queue();

    }

}
