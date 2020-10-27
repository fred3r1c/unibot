package main.java;

import net.dv8tion.jda.api.EmbedBuilder;
import net.dv8tion.jda.api.MessageBuilder;
import net.dv8tion.jda.api.entities.Message;
import net.dv8tion.jda.api.entities.Role;
import net.dv8tion.jda.api.entities.User;

import java.awt.*;
import java.io.File;
import java.util.HashMap;
import java.util.Random;

public class Ausgaben {

    static Random randy = new Random();

    public static void stundenplan (User user){

        //File filePNG = new File("//var//lib//jenkins//workspace//MoritzUnibot//src//main//resources//Files//Fachsemester_1_Stundenplan.PNG");
        //File filepdf = new File("//var//lib//jenkins//workspace//MoritzUnibot//src//main//resources//Files//Fachsemester_1_Stundenplan.pdf");
        //
        //user.openPrivateChannel().queue(channel -> channel.sendFile(filePNG, filePNG.getName()).queue());
        //user.openPrivateChannel().queue(channel -> channel.sendFile(filepdf, filepdf.getName()).queue());
        user.openPrivateChannel().queue(privateChannel -> privateChannel.sendMessage("Die Stundenplan-Funkion ist aktuell noch in Bearbeitung um den neuen Ansprüchen gerecht zu werden." +
                "\nVielen Dank für dein Verständnis.").queue());

    }

    public static void help (User user) {

        EmbedBuilder embedBuilder = new EmbedBuilder();

        embedBuilder.setThumbnail("http://www.clipartbest.com/cliparts/9cp/oEb/9cpoEbagi.jpeg");
        embedBuilder.setAuthor("Fragen über mich? Hier erklär ich alles!");
        embedBuilder.addBlankField(false);
        embedBuilder.addField("Befehle", "Alle Befehle für mich beginnen mit einem \"!\", damit ich erkennen kann, das es sich um einen Befehl handelt. Die Groß- und Kleinschreibung spielt keine Rolle.", false);
        embedBuilder.addField("Hier ist die Liste aller Befehele:", "", false);
        embedBuilder.addField("!help / !h / !hilfe", "Damit sende ich dir diese Nachricht.", true);
        embedBuilder.addField("!termine / !kalender", "Damit bekommst du eine Übersicht aller wichtigen Termine und Events die das Studium betreffen.", true);
        embedBuilder.addField("!stundenplan / !plan", "Damit bekommst du den aktuellen Stundenplan als Bild und als PDF von mir.", true);
        embedBuilder.addBlankField(false);
        embedBuilder.addField("Die Befehle werden immer erweitert und aktuallisiert. Bei Fragen und Anregungen wende dich an meinen Schöpfer @M̶̿̉o̷̝͂r̴̊̉i̴͐̈́t̶̾̎z̵͗̓.","", false);
        embedBuilder.setColor(Color.red);

        user.openPrivateChannel().queue(channel -> channel.sendMessage(embedBuilder.build()).queue());

    }

    public static void conversation (User user){

        String[] messages = new String[]{
                "Da stimm ich dir absolut zu!",
                "Das sehe ich auch so.",
                "Ne, find ich jetzt nicht, aber kannst du ruhig so machen.",
                "Das würde ich an deiner Stelle nicht tun...",
                "ok",
                "Uhhh, sehr sexy:smirk::smirk::smirk:!",
                "Alles klar, let's GOOOOO!!!"};

        int random = randy.nextInt(messages.length);

        user.openPrivateChannel().queue(channel -> channel.sendMessage(new MessageBuilder(messages[random]).build()).queue());
    }

}
