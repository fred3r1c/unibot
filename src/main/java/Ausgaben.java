import net.dv8tion.jda.api.MessageBuilder;
import net.dv8tion.jda.api.entities.Message;
import net.dv8tion.jda.api.entities.User;

import java.io.File;

public class Ausgaben {

    public static String resources = System.getProperty("user.dir");

    public Ausgaben(){


    }

    public static Message stundenplan(User user){


        File file = new File("//var//lib//jenkins//workspace//unibot//src//main//resources//Files//Fachsemester_1_Stundenplan.pdf");

        user.openPrivateChannel().queue(channel -> channel.sendMessage("anfang " + resources + " ende").queue());
        user.openPrivateChannel().queue(channel -> channel.sendFile(file, file.getName()).queue());

        return null;
    }



}
