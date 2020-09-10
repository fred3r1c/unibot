import net.dv8tion.jda.api.events.message.priv.PrivateMessageReceivedEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;


public class EventListener extends ListenerAdapter {
    @Override
    public void onPrivateMessageReceived(PrivateMessageReceivedEvent event){
        if (event.getAuthor().equals(MainBot.jda.getSelfUser()))
            return;
        event.getChannel().sendMessage("Hallo du hurensohn").queue();

    }

}
