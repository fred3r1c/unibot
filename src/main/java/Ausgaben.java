import net.dv8tion.jda.api.MessageBuilder;
import net.dv8tion.jda.api.entities.Message;

public class Ausgaben {

    public static void stundenplan(){

    }

    public static Message testMention (String name){

        MessageBuilder builder = new MessageBuilder("@"+ name);
        builder.allowMentions(Message.MentionType.valueOf(name));
        return builder.build();

    }


}
