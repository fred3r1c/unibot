import net.dv8tion.jda.api.EmbedBuilder;
import net.dv8tion.jda.api.MessageBuilder;
import net.dv8tion.jda.api.entities.Message;
import net.dv8tion.jda.api.entities.User;

import java.awt.*;
import java.io.File;

public class Ausgaben {

    public static void stundenplan(User user){

        File filePNG = new File("//var//lib//jenkins//workspace//MoritzUnibot//src//main//resources//Files//Fachsemester_1_Stundenplan.PNG");
        File filepdf = new File("//var//lib//jenkins//workspace//MoritzUnibot//src//main//resources//Files//Fachsemester_1_Stundenplan.pdf");

        user.openPrivateChannel().queue(channel -> channel.sendFile(filePNG, filePNG.getName()).queue());
        user.openPrivateChannel().queue(channel -> channel.sendFile(filepdf, filepdf.getName()).queue());

    }

    public static void help (User user) {

        EmbedBuilder embedBuilder = new EmbedBuilder();

        embedBuilder.setThumbnail("http://www.clipartbest.com/cliparts/9cp/oEb/9cpoEbagi.jpeg");
        embedBuilder.setAuthor("Fragen über mich? Hier erklär ich alles!");
        embedBuilder.addField("Befehle", "Alle Befehele für mich beginnen mit einem \"!\" damit ich erkennen kann, das es sich um einen Befehl handelt. Die Groß- und Kleinschreibung spielt keine Rolle.\n eine Liste aller Befehle erhälst du weiter unten.", false);
        embedBuilder.addField("Hier ist die Liste aller Befehele:", "", false);
        embedBuilder.addField("!help / !h / !hilfe", "Damit sende ich dir diese Nachricht", true);
        embedBuilder.addField("!termine / !karlender", "Damit bekommst du eine Übersicht aller wichtigen Termine und Events die das Studium betreffen.", true);
        embedBuilder.addField("!stundenplan / !plan", "Damit bekommst du den aktuellen Stundenplan als Bild und als PDF von mir.", true);
        embedBuilder.addField("Die Befehle werden immer erweitert und aktuallisiert. Bei Fragen und Anregungen wende dich an meinen Schöpfer <@411138870793469952>.","", false);
        embedBuilder.setColor(Color.red);

        user.openPrivateChannel().queue(channel -> channel.sendMessage(embedBuilder.build()).queue());
        
    }

}
