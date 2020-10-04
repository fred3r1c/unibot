import net.dv8tion.jda.api.EmbedBuilder;
import net.dv8tion.jda.api.JDA;
import net.dv8tion.jda.api.JDABuilder;
import net.dv8tion.jda.api.entities.Activity;
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
        testMention("M̶̿̉o̷̝͂r̴̊̉i̴͐̈́t̶̾̎z̵͗̓");


    }

    public static void startMessageBot() {

        EmbedBuilder eb = new EmbedBuilder();

        eb.setAuthor("Uni-Bot_EIT");
        eb.setTitle("Hallo, ich bin der Uni-Bot dieses Discords.\n\nMit !help, !h und !hilfe (entweder privat an mich direkt oder im bot-command Channel), bekommst du eine private nachricht mit all meinen Befehelen");
        eb.addField("", "bei Fragen oder anregungen bezüglich mir richte dich an meinen Schöpfer M̶̿̉o̷̝͂r̴̊̉i̴͐̈́t̶̾̎z̵͗̓ oder andere mit der \"Bot-Programmer\" Rolle.",false);
        eb.setThumbnail("https://secure.meetupstatic.com/photos/event/2/5/0/f/highres_456969487.jpeg");
        eb.setColor(Color.blue);

        MessageEmbed me = eb.build();

        EventListener.guild.getTextChannelById("740970939616985088").sendMessage(me).queue();
    }

    public static void testMention(String string){

        EventListener.guild.getTextChannelById("753640621855604908").sendMessage("Hey <@411138870793469952> are you there?").queue();
    }

}
