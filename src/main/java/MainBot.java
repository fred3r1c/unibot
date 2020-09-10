import net.dv8tion.jda.api.JDA;
import net.dv8tion.jda.api.JDABuilder;
import net.dv8tion.jda.api.entities.Activity;
import net.dv8tion.jda.api.requests.GatewayIntent;
import net.dv8tion.jda.api.utils.ChunkingFilter;
import net.dv8tion.jda.api.utils.MemberCachePolicy;

import javax.security.auth.login.LoginException;

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

    }

}
