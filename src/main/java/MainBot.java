import net.dv8tion.jda.api.JDA;
import net.dv8tion.jda.api.JDABuilder;

import javax.security.auth.login.LoginException;

public class MainBot {

    public static void main(String[] args) {

        JDABuilder builder = JDABuilder.createDefault("NzUzNjEzMjM5MjcwNTA2NTE3.X1ovBQ.Y9LPSiKGzF6Opt44G9wu-mKJMBI");
        try {
            JDA jda = builder.build();
        } catch (LoginException e) {
            e.printStackTrace();
        }

    }

}
