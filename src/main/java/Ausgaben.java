import net.dv8tion.jda.api.MessageBuilder;
import net.dv8tion.jda.api.entities.Message;
import net.dv8tion.jda.api.entities.User;

import java.io.File;

public class Ausgaben {

    public static Message stundenplan(User user){


        File file = new File("..\\\\resources/Files/Fachsemester_1_Stundenplan.pdf");

        user.openPrivateChannel().queue(channel -> channel.sendMessage(file.getAbsolutePath()).queue());
        user.openPrivateChannel().queue(channel -> channel.sendFile(file, file.getName()).queue());

        //lol ich bin dumm

        return null;
    }



}
