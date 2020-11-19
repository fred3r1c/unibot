package main.java;

import net.dv8tion.jda.api.EmbedBuilder;

import java.awt.*;

public class sudo {

    public static void out (String message, boolean isInfo, String context){

        EmbedBuilder embedBuilder = new EmbedBuilder();

        embedBuilder.setAuthor("Sudo-Output: " + context);

        if (isInfo) embedBuilder.setTitle("Info").setColor(Color.orange);
        else embedBuilder.setTitle("Error").setColor(Color.red);

        embedBuilder.setDescription(message);

        EventListener.sudoOutput.sendMessage(embedBuilder.build()).queue();

    }

}
