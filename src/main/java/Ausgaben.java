import net.dv8tion.jda.api.MessageBuilder;
import net.dv8tion.jda.api.entities.Message;
import net.dv8tion.jda.api.entities.User;

import java.io.File;

public class Ausgaben {

    public Ausgaben(){


    }

    public static Message stundenplan(User user){

        File filePNG = new File("//var//lib//jenkins//workspace//MoritzUnibot//src//main//resources//Files//Fachsemester_1_Stundenplan.PNG");
        File filepdf = new File("//var//lib//jenkins//workspace//MoritzUnibot//src//main//resources//Files//Fachsemester_1_Stundenplan.pdf");

        user.openPrivateChannel().queue(channel -> channel.sendFile(filepdf, filepdf.getName()).queue());
        user.openPrivateChannel().queue(channel -> channel.sendFile(filePNG, filePNG.getName()).queue());

        return null;
    }



}
