package main.java;

import net.dv8tion.jda.api.EmbedBuilder;
import net.dv8tion.jda.api.JDA;
import net.dv8tion.jda.api.JDABuilder;
import net.dv8tion.jda.api.MessageBuilder;
import net.dv8tion.jda.api.entities.Activity;
import net.dv8tion.jda.api.entities.Message;
import net.dv8tion.jda.api.entities.MessageEmbed;
import net.dv8tion.jda.api.requests.GatewayIntent;
import net.dv8tion.jda.api.utils.ChunkingFilter;
import net.dv8tion.jda.api.utils.MemberCachePolicy;

import javax.security.auth.login.LoginException;
import java.awt.*;

public class MainBot {

    public static final String BOT_TOKEN = "NzUzNjEzMjM5MjcwNTA2NTE3.X1ovBQ.Y9LPSiKGzF6Opt44G9wu-mKJMBI";
    public static JDA jda;

    public static void main(String[] args) {


        try{
            JDABuilder builder = JDABuilder.createDefault(BOT_TOKEN);
            builder.enableIntents(GatewayIntent.GUILD_MEMBERS, GatewayIntent.GUILD_VOICE_STATES, GatewayIntent.GUILD_EMOJIS, GatewayIntent.DIRECT_MESSAGES, GatewayIntent.GUILD_PRESENCES, GatewayIntent.GUILD_MESSAGES, GatewayIntent.GUILD_MESSAGE_REACTIONS);
            builder.setActivity(Activity.watching("you"));
            builder.setChunkingFilter(ChunkingFilter.ALL);
            builder.setMemberCachePolicy(MemberCachePolicy.ALL);
            jda = builder.build();
            jda.awaitReady();
            jda.addEventListener(new EventListener());
        } catch (LoginException | InterruptedException ignored){}

        //startMessageBot();
        //rollenMatheVorkurs();
        //rollenModule();
        rollenHobbys();

        testNachricht();


    }

    public static void startMessageBot() {

        EmbedBuilder eb = new EmbedBuilder();

        eb.setAuthor("Uni-Bot_EIT");
        eb.setTitle("Hallo, ich bin der Uni-Bot dieses Discords.\n\nMit !help, !h und !hilfe (entweder privat an mich direkt oder im bot-command Channel), bekommst du eine private nachricht mit all meinen Befehelen");
        eb.addField("", "bei Fragen oder anregungen bezüglich mir richte dich an meinen Schöpfer <@411138870793469952> oder andere mit der <@&753639586110111755> Rolle.",false);
        eb.setThumbnail("https://secure.meetupstatic.com/photos/event/2/5/0/f/highres_456969487.jpeg");
        eb.setColor(Color.blue);

        MessageEmbed me = eb.build();

        EventListener.guild.getTextChannelById("764937566926536775").sendMessage(me).queue();

    }

    public static void rollenMatheVorkurs(){

        EmbedBuilder embedBuilder = new EmbedBuilder();

        embedBuilder.setAuthor("Rollenverteilung");
        embedBuilder.setTitle("Mathe-Vorkurs", "https://www.moodle.tum.de/course/view.php?id=58860");
        embedBuilder.addField("", "Du bist für den Mathe-Vorkurs angemeldet?\nDann reagiere jetzt mit dem \uD83D\uDC23 Emoji auf diese Nachricht und du bekommst automatisch Zugriff auf alles, das mit dem Mathe-Vorkurs zusammenhängt.", false);
        embedBuilder.addField("", "You are registered for the Math-Course?\nThan react with a \uD83D\uDC23 emoji on this message and you will get acces to all the Math-Course related stuff.", false);

        MessageEmbed messageEmbed = embedBuilder.build();

        MessageBuilder messageBuilder = new MessageBuilder(messageEmbed);

        Message message = messageBuilder.build();


        EventListener.rollenverteilung.sendMessage(message).queue(m -> m.addReaction("\uD83D\uDC23").queue());


    }

    public static void rollenModule(){

        EmbedBuilder embedBuilder = new EmbedBuilder();

        embedBuilder.setAuthor("Rollenverteilung");
        embedBuilder.setTitle("Uni-Module");
        embedBuilder.addField("", "Hier kannst du die Module wähle die du belegt hast.\n\uD83D\uDCC8 für Analysis 1\n\uD83D\uDC7E für Digitaltechnik\n\uD83E\uDDEE für Lineare Algebra\n\uD83D\uDCBB für Computertechnik\n\uD83D\uDD79 für Schaltungstechnik", true);
        embedBuilder.addBlankField(true);
        embedBuilder.addField("", "Here you can select the modules you chose.\n\uD83D\uDCC8 for Analysis 1\n\uD83D\uDC7E for Digitaltechnik\n\uD83E\uDDEE for Lineare Algebra\n\uD83D\uDCBB for Computertechnik\n\uD83D\uDD79 for Schaltungstechnik", true);

        MessageEmbed messageEmbed = embedBuilder.build();

        MessageBuilder messageBuilder = new MessageBuilder(messageEmbed);

        Message message = messageBuilder.build();

        EventListener.rollenverteilung.sendMessage(message).queue(m -> {

            m.addReaction("\uD83D\uDCC8").queue();
            m.addReaction("\uD83D\uDC7E").queue();
            m.addReaction("\uD83E\uDDEE").queue();
            m.addReaction("\uD83D\uDCBB").queue();
            m.addReaction("\uD83D\uDD79").queue();

        });

    }

    public static void rollenHobbys(){

        EmbedBuilder embedBuilder = new EmbedBuilder();

        embedBuilder.setAuthor("Rollenverteilung");
        embedBuilder.setTitle("Hobbys und Freizeit");
        embedBuilder.addField("", "Hier kannst du Rollen wählen nach deinen Interessen und Hobbys.\n\uD83C\uDFB6 für Musik\n\uD83D\uDEB4 für Sport\n\uD83D\uDCF8 für den Instagram-Channel\n\uD83D\uDC7B für den Snap-Chat-Channel\n\uD83E\uDD86 für den Twitter-Channel", true);
        embedBuilder.addBlankField(true);
        embedBuilder.addField("", "Here you can choose roles based on your interests and hobbys.\n\uD83C\uDFB6 for music\n\uD83D\uDEB4 for sports\n\uD83D\uDCF8 for the Instagram-Channel\n\uD83D\uDC7B for the Snap-Chat-Channel\n\uD83E\uDD86 for the Twitter-Channel", true);

        MessageEmbed messageEmbed = embedBuilder.build();

        MessageBuilder messageBuilder = new MessageBuilder(messageEmbed);

        Message message = messageBuilder.build();


        EventListener.rollenverteilung.sendMessage(message).queue(m -> {

            m.addReaction("\uD83C\uDFB6").queue();
            m.addReaction("\uD83D\uDEB4").queue();
            m.addReaction("\uD83D\uDCF8").queue();
            m.addReaction("\uD83D\uDC7B").queue();
            m.addReaction("\uD83E\uDD86").queue();

        });

    }

    public static void rollenGaming(){

        EmbedBuilder embedBuilder = new EmbedBuilder();

        embedBuilder.setAuthor("Rollenverteilung");
        embedBuilder.setTitle("Gaming");
        embedBuilder.addField("","Du bist interessiert in Gaming? Dann wähle hier die Games aus die du gerne spielst und erhalte Zugriff auf die entsprechenden Channel.\n<:AmongUs:765248376051728434> für Among Us\n<:LoL:765267533401686026> für League of Legends\n<:CSGO:765268874413080596> für CS-GO\n<:R6:765269090867609600> für Rainbow Six Siege\n<:RL:765269337212190720> für Rocket League\nDein Game ist nicht dabei? Dann schreibe eine der <@&753639586110111755> an.",false);
        embedBuilder.addField("", "You are interested in gaming? Than choose the games you play here and get acces to the related channels.\n<:AmongUs:765248376051728434> for Among Us\n<:LoL:765267533401686026> for League of Legends\n<:CSGO:765268874413080596> for CS-GO\n<:R6:765269090867609600> for Rainbow Six Siege\n<:RL:765269337212190720> for Rocket League\nYour game is not included? Than write to of the <@&753639586110111755>.", false);

        MessageEmbed messageEmbed = embedBuilder.build();

        MessageBuilder messageBuilder = new MessageBuilder(messageEmbed);

        Message message = messageBuilder.build();


        EventListener.rollenverteilung.sendMessage(message).queue(m -> {

            m.addReaction("").queue();
            m.addReaction("").queue();
            m.addReaction("").queue();
            m.addReaction("").queue();
            m.addReaction("").queue();

        });

    }

    public static void testNachricht(){
        EventListener.botkonsole.sendMessage("<:AmongUs:765248376051728434>").queue(message -> message.addReaction(EventListener.guild.getEmotesByName("AmongUs", true).get(0)).queue());
    }

}
