package main.java;

import net.dv8tion.jda.api.entities.*;
import net.dv8tion.jda.internal.entities.ActivityImpl;
import org.apache.log4j.Logger;
import net.dv8tion.jda.api.EmbedBuilder;
import net.dv8tion.jda.api.JDA;
import net.dv8tion.jda.api.JDABuilder;
import net.dv8tion.jda.api.MessageBuilder;
import net.dv8tion.jda.api.requests.GatewayIntent;
import net.dv8tion.jda.api.utils.ChunkingFilter;
import net.dv8tion.jda.api.utils.MemberCachePolicy;

import javax.security.auth.login.LoginException;
import java.awt.*;
import java.io.FileReader;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Properties;


public class MainBot {

    public static final String BOT_TOKEN;
    public static JDA jda;
	
    static{
		Properties login = new Properties();
		try (FileReader in = new FileReader("C:\\Users\\morip\\Desktop\\login.properties")){
			login.load(in);
		} catch (Exception e){
			try (FileReader in = new FileReader("//root//login.properties")){
				login.load(in);
			} catch (Exception ignored){}
		}
		BOT_TOKEN = login.getProperty("token");
	}

    public static void main(String[] args) {
        try{
            JDABuilder builder = JDABuilder.createDefault(BOT_TOKEN);
            builder.enableIntents(GatewayIntent.GUILD_MEMBERS, GatewayIntent.GUILD_VOICE_STATES, GatewayIntent.GUILD_EMOJIS, GatewayIntent.DIRECT_MESSAGES, GatewayIntent.GUILD_PRESENCES, GatewayIntent.GUILD_MESSAGES, GatewayIntent.GUILD_MESSAGE_REACTIONS);
            builder.setActivity(Activity.playing("Schönes Wochenende!"));
            builder.setChunkingFilter(ChunkingFilter.ALL);
            builder.setMemberCachePolicy(MemberCachePolicy.ALL);
            jda = builder.build();
            jda.awaitReady();
            jda.addEventListener(new EventListener());
        } catch (LoginException | InterruptedException ignored){}



        //welcomeMessage();         //rdytogo
        //rollenMatheVorkurs();     //rdytogo
        //rollenModuleS1();         //rdytogo
        //rollenModuleS2();         //rdytogo
        //rollenModuleS3();         //rdytogo
        //rollenModuleS4();         //rdytogo
        //rollenHobbys();           //rdytogo
        //rollenGaming();           //rdytogo
        //startMessageBot();        //rdytogo
        //stadtteile();             //rdytogo
        //rollenUebersichtsZuweisung();
        //rollenevents();

        //testNachricht();

        //Exel.createEvent("Testevent", new Role[]{
        //        EventListener.guild.getRoleById("771852088011391016"),
        //        EventListener.guild.getRoleById("771852280915820585"),
        //        EventListener.guild.getRoleById("771852396866961478"),
        //        EventListener.guild.getRoleById("771852435866124319"),
        //        EventListener.guild.getRoleById("771852472821612584"),
        //        EventListener.guild.getRoleById("771852514340503614"),
        //        EventListener.guild.getRoleById("771852564563886080"),
        //        EventListener.guild.getRoleById("771852595017809951"),
        //        EventListener.guild.getRoleById("771852630405283871"),
        //        EventListener.guild.getRoleById("771852668418785330"),
        //        EventListener.guild.getRoleById("771852714136174624"),
        //        EventListener.guild.getRoleById("771852749033701457"),
        //        EventListener.guild.getRoleById("771852792323244102"),
        //        EventListener.guild.getRoleById("771852826502627349"),
        //        EventListener.guild.getRoleById("771852861323739147"),
        //        EventListener.guild.getRoleById("771852902137724979"),
        //        EventListener.guild.getRoleById("771852995062530048"),
        //        EventListener.guild.getRoleById("771853039916941373"),
        //        EventListener.guild.getRoleById("771853076827078667"),
        //        EventListener.guild.getRoleById("771853115681931285")}, 3, 10);


    }

    public static void startMessageBot() {

        EmbedBuilder eb = new EmbedBuilder();

        eb.setAuthor("Uni-Bot_EIT");
        eb.setTitle("Hallo, ich bin der Uni-Bot dieses Discords.\n\nMit !help, !h und !hilfe (entweder privat an mich direkt oder im bot-command Channel), bekommst du eine private nachricht mit all meinen Befehelen");
        eb.addField("", "bei Fragen oder anregungen bezüglich mir richte dich an meinen Schöpfer <@411138870793469952> oder andere mit der <@&753639586110111755> Rolle.",false);
        eb.setThumbnail("https://secure.meetupstatic.com/photos/event/2/5/0/f/highres_456969487.jpeg");
        eb.setColor(Color.blue);

        MessageEmbed me = eb.build();

        EventListener.guild.getTextChannelById("769988185803456523").sendMessage(me).queue();

    }

    public static void rollenMatheVorkurs(){

        EmbedBuilder embedBuilder = new EmbedBuilder();

        embedBuilder.setAuthor("Rollenverteilung");
        embedBuilder.setTitle("Mathe-Vorkurs", "https://www.moodle.tum.de/course/view.php?id=58860");
        embedBuilder.addField("", "Du bist für den Mathe-Vorkurs angemeldet?\nDann reagiere jetzt mit dem \uD83D\uDC23 Emoji auf diese Nachricht und du bekommst automatisch Zugriff auf alles, das mit dem Mathe-Vorkurs zusammenhängt.", false);
        embedBuilder.addField("", "You are registered for the Math-Course?\nThen react with a \uD83D\uDC23 emoji on this message and you will get acces to all the Math-Course related stuff.", false);

        MessageEmbed messageEmbed = embedBuilder.build();

        MessageBuilder messageBuilder = new MessageBuilder(messageEmbed);

        Message message = messageBuilder.build();


        EventListener.module.sendMessage(message).queue(m -> m.addReaction("\uD83D\uDC23").queue());


    }

    public static void welcomeMessage(){

        EmbedBuilder embedBuilder = new EmbedBuilder();

        embedBuilder.setAuthor("Uni-Bot_EIT");
        embedBuilder.setTitle("Willkommen auch von mir auf unserem Discord Server.");
        embedBuilder.setDescription("Bevor wir loslegen können habe ich eine Kurze frage an dich. Reagiere als Antwort bitte mit dem entsprechenden Emoji." +
                "\n\nIn Welchem Semester bist du?");

        MessageEmbed messageEmbed = embedBuilder.build();

        MessageBuilder messageBuilder = new MessageBuilder(messageEmbed);

        Message message = messageBuilder.build();

        EventListener.guild.getTextChannelById("769930976012795906").sendMessage(message).queue(m -> {          //2. Welcome channel

            m.addReaction("1️⃣").queue();
            m.addReaction("2️⃣").queue();
            m.addReaction("3️⃣").queue();
            m.addReaction("4️⃣").queue();

        });

        embedBuilder.clear();
        embedBuilder.setAuthor("Uni-Bot_EIT");
        embedBuilder.setTitle("Willkommen auch von mir auf unserem Discord Server.");
        embedBuilder.setDescription("Bevor du wählen kannst in welchem Semester du bist, bitte akzeptiere zuert die Regeln im <#764935334366019594>-Channel");

        EventListener.guild.getTextChannelById("764935137157840956").sendMessage(embedBuilder.build()).queue();

        embedBuilder.clear();
        embedBuilder.setAuthor("Uni-Bot_EIT");
        embedBuilder.setTitle("Regeln");
        embedBuilder.setDescription("Bitte akzeptiere diese Regeln mit einem ✅ um Zugriff auf die Semesterwahl zu bekommen.");
        EventListener.guild.getTextChannelById("764935334366019594").sendMessage(embedBuilder.build()).queue(message1 -> message1.addReaction("✅").queue());


    }

    public static void rollenModuleS1(){

        EmbedBuilder embedBuilder = new EmbedBuilder();

        embedBuilder.setAuthor("Rollenverteilung");
        embedBuilder.setTitle("Module Semester 1");
        embedBuilder.addField("", "Hier kannst du zusätzliche Module aus Semester 1 wählen." +
                "\n\uD83D\uDCC8 für Analysis 1" +
                "\n\uD83D\uDC7E für Digitaltechnik" +
                "\n\uD83E\uDDEE für Lineare Algebra" +
                "\n\uD83D\uDCBB für Computertechnik" +
                "\n\uD83D\uDD79 für Schaltungstechnik", false);

        MessageEmbed messageEmbed = embedBuilder.build();

        MessageBuilder messageBuilder = new MessageBuilder(messageEmbed);

        Message message = messageBuilder.build();

        EventListener.module.sendMessage(message).queue(m -> {

            m.addReaction("\uD83D\uDCC8").queue();
            m.addReaction("\uD83D\uDC7E").queue();
            m.addReaction("\uD83E\uDDEE").queue();
            m.addReaction("\uD83D\uDCBB").queue();
            m.addReaction("\uD83D\uDD79").queue();

        });

    }

    public static void rollenModuleS2(){

        EmbedBuilder embedBuilder = new EmbedBuilder();

        embedBuilder.setAuthor("Rollenverteilung");
        embedBuilder.setTitle("Module Semester 2");
        embedBuilder.addField("", "Hier kannst du zusätzliche Module aus Semester 2 wählen." +
                "\n\uD83E\uDDF2 für Elektrizität und Magnetismus" +
                "\n\uD83D\uDCD0 für Systemtheorie" +
                "\n\uD83D\uDCBE für Algorithmen und Datenstrukturen" +
                "\n\uD83D\uDCC9 für Analysis 2" +
                "\n\uD83C\uDFA2 für Physik für Elektroingenieure", false);

        MessageEmbed messageEmbed = embedBuilder.build();

        MessageBuilder messageBuilder = new MessageBuilder(messageEmbed);

        Message message = messageBuilder.build();

        EventListener.module.sendMessage(message).queue(m -> {

            m.addReaction("\uD83E\uDDF2").queue();
            m.addReaction("\uD83D\uDCD0").queue();
            m.addReaction("\uD83D\uDCBE").queue();
            m.addReaction("\uD83D\uDCC9").queue();
            m.addReaction("\uD83C\uDFA2").queue();

        });

    }

    public static void rollenModuleS3(){

        EmbedBuilder embedBuilder = new EmbedBuilder();

        embedBuilder.setAuthor("Rollenverteilung");
        embedBuilder.setTitle("Module Semester 3");
        embedBuilder.addField("", "Hier kannst du zusätzliche Module aus Semester 3 wählen." +
                "\n\uD83D\uDCCA für Analysis 3" +
                "\n⚡ für Elektromagnetische Feldtheorie" +
                "\n\uD83D\uDCE1 für Signaltheorie" +
                "\n\uD83D\uDD29 für Festkörper-, Halbleiter- und Bauelementephysik" +
                "\n\uD83D\uDD2E für Stochastische Signale", false);

        MessageEmbed messageEmbed = embedBuilder.build();

        MessageBuilder messageBuilder = new MessageBuilder(messageEmbed);

        Message message = messageBuilder.build();

        EventListener.module.sendMessage(message).queue(m -> {

            m.addReaction("\uD83D\uDCCA").queue();
            m.addReaction("⚡").queue();
            m.addReaction("\uD83D\uDCE1").queue();
            m.addReaction("\uD83D\uDD29").queue();
            m.addReaction("\uD83D\uDD2E").queue();

        });

    }

    public static void rollenModuleS4(){

        EmbedBuilder embedBuilder = new EmbedBuilder();

        embedBuilder.setAuthor("Rollenverteilung");
        embedBuilder.setTitle("Module Semester 4");
        embedBuilder.addField("", "Hier kannst du zusätzliche Module aus Semester 4 wählen." +
                "\n\uD83D\uDD0C für Elektrische Energietechnik        " +
                "\n\uD83D\uDEA6 für Elektronische Schaltungen         " +
                "\n\uD83C\uDF21 für Messsystem- und Sensortechnik     " +
                "\n\uD83D\uDCEE für Nachrichtentechnik                " +
                "\n\uD83C\uDF9A für Regelungssysteme                  " +
                "\n\uD83E\uDD13 für Diskrete Mathematik für Ingenieure" +
                "\n\uD83D\uDD22 für Numerische Mathematik             ", false);

        MessageEmbed messageEmbed = embedBuilder.build();

        MessageBuilder messageBuilder = new MessageBuilder(messageEmbed);

        Message message = messageBuilder.build();

        EventListener.module.sendMessage(message).queue(m -> {

            m.addReaction("\uD83D\uDD0C").queue();
            m.addReaction("\uD83D\uDEA6").queue();
            m.addReaction("\uD83C\uDF21").queue();
            m.addReaction("\uD83D\uDCEE").queue();
            m.addReaction("\uD83C\uDF9A").queue();
            m.addReaction("\uD83E\uDD13").queue();
            m.addReaction("\uD83D\uDD22").queue();

        });

    }

    public static void rollenHobbys(){

        EmbedBuilder embedBuilder = new EmbedBuilder();

        embedBuilder.setAuthor("Rollenverteilung");
        embedBuilder.setTitle("Hobbys und Freizeit");
        embedBuilder.addField("", "Hier kannst du Rollen je nach deinen Interessen und Hobbys wählen." +
                "\n\uD83C\uDFB6 für Musik" +
                "\n\uD83C\uDFB9 für Music-Production" +
                "\n\uD83D\uDEB4 für Sport" +
                "\n\uD83C\uDFA8 für Kunst" +
                "\n\uD83D\uDCF8 für den Instagram-Channel" +
                "\n\uD83D\uDC7B für den Snap-Chat-Channel" +
                "\n\uD83E\uDD86 für den Twitter-Channel", false);

        MessageEmbed messageEmbed = embedBuilder.build();

        MessageBuilder messageBuilder = new MessageBuilder(messageEmbed);

        Message message = messageBuilder.build();


        EventListener.social.sendMessage(message).queue(m -> {

            m.addReaction("\uD83C\uDFB6").queue();
            m.addReaction("\uD83C\uDFB9").queue();
            m.addReaction("\uD83D\uDEB4").queue();
            m.addReaction("\uD83C\uDFA8").queue();
            m.addReaction("\uD83D\uDCF8").queue();
            m.addReaction("\uD83D\uDC7B").queue();
            m.addReaction("\uD83E\uDD86").queue();

        });

    }

    public static void rollenGaming(){

        EmbedBuilder embedBuilder = new EmbedBuilder();

        embedBuilder.setAuthor("Rollenverteilung");
        embedBuilder.setTitle("Gaming");
        embedBuilder.addField("","Du bist interessiert an Gaming? Dann wähle hier die Games aus die du gerne spielst und erhalte Zugriff auf die entsprechenden Channel." +
                "\n<:AmongUs:765248376051728434> für Among Us" +
                "\n<:LoL:765267533401686026> für League of Legends" +
                "\n<:CSGO:765268874413080596> für CS-GO" +
                "\n<:R6:765269090867609600> für Rainbow Six Siege" +
                "\n<:RL:765269337212190720> für Rocket League" +
                "\n<:GTA5:769915315731431455> für GTA5" +
                "\n<:Valorant:769914905994068009> für Valorant" +
                "\n<:switch:769950762859102239> für Nintendo-Switch" +
                "\nDein Game ist nicht dabei? Dann schreibe einen der <@&753639586110111755> an.",false);

        MessageEmbed messageEmbed = embedBuilder.build();

        MessageBuilder messageBuilder = new MessageBuilder(messageEmbed);

        Message message = messageBuilder.build();


        EventListener.social.sendMessage(message).queue(m -> {

            m.addReaction(EventListener.guild.getEmotesByName("AmongUs", true).get(0)).queue();
            m.addReaction(EventListener.guild.getEmotesByName("LoL", true).get(0)).queue();
            m.addReaction(EventListener.guild.getEmotesByName("CSGO", true).get(0)).queue();
            m.addReaction(EventListener.guild.getEmotesByName("R6", true).get(0)).queue();
            m.addReaction(EventListener.guild.getEmotesByName("RL", true).get(0)).queue();
            m.addReaction(EventListener.guild.getEmotesByName("GTA5", true).get(0)).queue();
            m.addReaction(EventListener.guild.getEmotesByName("Valorant", true).get(0)).queue();
            m.addReaction(EventListener.guild.getEmotesByName("switch", true).get(0)).queue();

        });

    }

    public static void rollenUebersichtsZuweisung(){

        ArrayList<String> arrayList = new ArrayList<String>();
        arrayList.add("740931533443170326");        //Maintainer
        arrayList.add("766333821368795166");        //Bot
        arrayList.add("766042676607975495");        //FSEI
        arrayList.add("753615382098739291");        //UniBot
        arrayList.add("753639586110111755");        //BotProgrammer
        arrayList.add("766395925412315137");        //Content Creator
        arrayList.add("766332083575980095");        //TeXit
        arrayList.add("766632020444446730");        //Rythm
        arrayList.add("767033183924518973");        //content Bot
        arrayList.add("769931144221163550");        //JJ

        //EmbedBuilder embedBuilder = new EmbedBuilder();

        //embedBuilder.setAuthor("Uni-Bot_EIT");

        EventListener.guild.getMembers().stream().forEach(member -> {

            if (!member.getUser().isBot()) {
                member.getRoles().stream().forEach(role -> {

                    if (!arrayList.contains(role.getId()))
                        EventListener.guild.removeRoleFromMember(member, role).queue();

                });

                EventListener.guild.addRoleToMember(member, EventListener.guild.getRoleById("769931144221163550")).queue();     //just joined

                //embedBuilder.setDescription("Hallo lieber Studierender," +
                //        "\n\nWillkommen auf dem EIT-Server 2.0!" +
                //        "\nIn Kürze wirst du im Regeln-Channel und im Willkommen-Channel jeweils eine Nachricht vom Bot sehen, die dich durch die ersten Schritte auf unserem neuen Server führen werden." +
                //        "\nAkzeptiere dann einfach die Regeln und wähle dein Semester aus und dann wird bald alles wieder wie gewohnt sein, nur besser!" +
                //        "\n\nIm Rahmen der Umstrukturierung wurden dir **__alle Rollen weggenommen__**, aber keine Sorge:" +
                //        "\n1. Deine Module werden dir automatisch mit deiner Semester-Wahl gegeben (zusätzliche Module findest du im Modul-Gruppen-Channel." +
                //        "\n2. Alle Gruppen bzgl. Hobbys, Freizeit und Gaming kannst du dir wie gewohnt nun über den Social-Gruppen-Channel geben." +
                //        "\n\n Bei Fragen melde dich bei einem der Maintainer und wir werden dir gerne versuchen weiterzuhelfen." +
                //        "\n\n Viel Spaß in deinem Studium wünscht dir" +
                //        "\n Dein Uni-Bot_EIT");

                //member.getUser().openPrivateChannel().queue(privateChannel -> privateChannel.sendMessage(embedBuilder.build()).queue());
            }

        });

    }

    public static void stadtteile(){

        EmbedBuilder embedBuilder = new EmbedBuilder();

        embedBuilder.setAuthor("Rollenverteilung");
        embedBuilder.setTitle("Wohnorte");
        embedBuilder.addField("", "Hier kannst du wählen in welchem Teil von München du wohnst und findest damit vielleicht (heiße) EI'ler in deiner Umgebung." +
                "\n\uD83C\uDF53 für Baldham" +
                "\n\uD83C\uDF5D für Bogenhausen" +
                "\n\uD83E\uDD5E für Ebersberg" +
                "\n\uD83C\uDF6B für Freising" +
                "\n\uD83C\uDF4F für Garching" +
                "\n\uD83E\uDD51 für Giesing" +
                "\n\uD83E\uDD5D für Hadern" +
                "\n\uD83E\uDDCA für Isarvorstadt" +
                "\n\uD83E\uDD67 für Pasing" +
                "\n\uD83E\uDD68 für m. Innenstadt" +
                "\n\uD83C\uDF7A für Schwabing" +
                "\n\uD83C\uDF55 für Sendling" +
                "\n\uD83C\uDF49 für Trudering", false);

        EventListener.social.sendMessage(embedBuilder.build()).queue(message -> {

            message.addReaction("\uD83C\uDF53").queue();
            message.addReaction("\uD83C\uDF5D").queue();
            message.addReaction("\uD83E\uDD5E").queue();
            message.addReaction("\uD83C\uDF6B").queue();
            message.addReaction("\uD83C\uDF4F").queue();
            message.addReaction("\uD83E\uDD51").queue();
            message.addReaction("\uD83E\uDD5D").queue();
            message.addReaction("\uD83E\uDDCA").queue();
            message.addReaction("\uD83E\uDD67").queue();
            message.addReaction("\uD83E\uDD68").queue();
            message.addReaction("\uD83C\uDF7A").queue();
            message.addReaction("\uD83C\uDF55").queue();
            message.addReaction("\uD83C\uDF49").queue();

        });


    }

    public static void rollenevents (){

        EmbedBuilder embedBuilder = new EmbedBuilder();

        embedBuilder.setAuthor("Gaming-Night");
        embedBuilder.setTitle("Gruppen");
        embedBuilder.setDescription("Willkommen bei unserem ersten online-Event!" +
                "\n\nIm folgenden kannst du mit den Emojis 🇦 bis 🇹 eine Gruppe auswählen in der du mit anderen gamen kannst." +
                "\nAufgrund von Limitierungen unseres Bots seitens Discord bitten wir euch, gezielt eine einzelne Gruppe, und nicht mehr als eine gleichzeitig, zu wählen und eventuell mit kleinen Verzögerungen zu rechnen." +
                "\nSollte es nicht funktionieren und du hast schon etwas gewartet (>1 Minute), melde dich gerne bei einem der <@&740931533443170326>, wir fügen dich manuell hinzu \uD83D\uDE42");


        EventListener.events.sendMessage(embedBuilder.build()).queue(message -> {

            //message.addReaction("\uD83C\uDFB2").queue();
            message.addReaction("🇦").queue();
            message.addReaction("🇧").queue();
            message.addReaction("🇨").queue();
            message.addReaction("🇩").queue();
            message.addReaction("🇪").queue();
            message.addReaction("🇫").queue();
            message.addReaction("🇬").queue();
            message.addReaction("🇭").queue();
            message.addReaction("🇮").queue();
            message.addReaction("🇯").queue();
            message.addReaction("🇰").queue();
            message.addReaction("🇱").queue();
            message.addReaction("🇲").queue();
            message.addReaction("🇳").queue();
            message.addReaction("🇴").queue();
            message.addReaction("🇵").queue();
            message.addReaction("🇶").queue();
            message.addReaction("🇷").queue();
            message.addReaction("🇸").queue();
            message.addReaction("🇹").queue();

        });



    }

    public static void testNachricht(){
        EventListener.botkonsole.sendMessage("**__Test__**").queue(message -> message.addReaction(EventListener.guild.getEmotesByName("AmongUs", true).get(0)).queue());
    }

}
