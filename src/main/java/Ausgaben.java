import net.dv8tion.jda.api.MessageBuilder;
import net.dv8tion.jda.api.entities.Message;
import net.dv8tion.jda.api.entities.User;

import java.io.File;

public class Ausgaben {

    public static Message stundenplan(User user){

        File file = new File("src/main/resources/Files/Fachsemester_1_Stundenplan.PNG");

        user.openPrivateChannel().queue(channel -> channel.sendFile(file, file.getName()).queue());

        return null;
    }



}
