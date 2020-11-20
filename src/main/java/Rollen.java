package main.java;

import net.dv8tion.jda.api.EmbedBuilder;
import net.dv8tion.jda.api.entities.Guild;
import net.dv8tion.jda.api.entities.Member;
import net.dv8tion.jda.api.entities.Role;
import net.dv8tion.jda.api.events.message.react.MessageReactionAddEvent;
import net.dv8tion.jda.api.events.message.react.MessageReactionRemoveEvent;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Rollen {

    private static final Guild guild = EventListener.guild;

    public static final HashMap<String, Role> module = new HashMap<String, Role>();
    public static final HashMap<String, Role> social = new HashMap<String, Role>();
    public static final HashMap<String, Role> events = new HashMap<String, Role>();
    public static final HashMap<String, String> eventName = new HashMap<String, String>();
    public static final ArrayList<String > amongus = new ArrayList<>();
    public static final ArrayList<String > scribble = new ArrayList<>();
    public static final ArrayList<String > slf = new ArrayList<>();
    public static final ArrayList<String > freiesEvent = new ArrayList<>();


    public static final String discordVideo = "";

    static {

        module.put("✅", guild.getRoleById("769174582468542507")); //Regeln

        module.put("1️⃣", guild.getRoleById("768143973511987241")); //Semester 1
        module.put("2️⃣", guild.getRoleById("769590160886857770")); //Semester 2
        module.put("3️⃣", guild.getRoleById("768143954449268768")); //Semester 3
        module.put("4️⃣", guild.getRoleById("769590166213754920")); //Semester 4

        module.put("\uD83D\uDCC8", guild.getRoleById("764937834863001610")); //Analysis 1
        module.put("\uD83D\uDC7E", guild.getRoleById("764938020688101426")); //Digitaltechnik
        module.put("\uD83E\uDDEE", guild.getRoleById("764938234253672478")); //Lineare Algebra
        module.put("\uD83D\uDCBB", guild.getRoleById("764938237109075988")); //Computertechnik
        module.put("\uD83D\uDD79", guild.getRoleById("764938239558942740")); //Schaltungtheorie

        module.put("\uD83E\uDDF2", guild.getRoleById("769900641895055360")); //Elektrizität und Magnetismus
        module.put("\uD83D\uDCD0", guild.getRoleById("769900644579540993")); //Systemtheorie
        module.put("\uD83D\uDCBE", guild.getRoleById("769900647394181120")); //Algorithmen und Datenstrukturen
        module.put("\uD83D\uDCC9", guild.getRoleById("769900649109258271")); //Analysis 2
        module.put("\uD83C\uDFA2", guild.getRoleById("769900651655462922")); //Physik für Elektroingenieure

        module.put("\uD83D\uDCCA", guild.getRoleById("768142504145977384")); //Analysis 3
        module.put("⚡",           guild.getRoleById("768143242150674452")); //Elektromagnetische Feldtheorie
        module.put("\uD83D\uDCE1", guild.getRoleById("768143269694799903")); //Signaltheorie
        module.put("\uD83D\uDD29", guild.getRoleById("768143272731213825")); //Festkörper-, Halbleiter- und Bauelementephysik
        module.put("\uD83D\uDD2E", guild.getRoleById("768143275340333076")); //Stochastische Signale

        module.put("\uD83D\uDD0C", guild.getRoleById("769900654431830037")); //Elektrische Energietechnik
        module.put("\uD83D\uDEA6", guild.getRoleById("769900655900360735")); //Elektronische Schaltungen
        module.put("\uD83C\uDF21", guild.getRoleById("769900657817288705")); //Messsystem- und Sensortechnik
        module.put("\uD83D\uDCEE", guild.getRoleById("769900659427901450")); //Nachrichtentechnik
        module.put("\uD83C\uDF9A", guild.getRoleById("769900660794851348")); //Regelungssysteme
        module.put("\uD83E\uDD13", guild.getRoleById("769900662371647488")); //Diskrete Mathematik für Ingenieure
        module.put("\uD83D\uDD22", guild.getRoleById("769900663852236800")); //Numerische Mathematik

        module.put("\uD83D\uDC23", guild.getRoleById("764938487434051604")); //Mathe-Vorkurs


        social.put("\uD83D\uDCF8", guild.getRoleById("764954188706611210")); //Insta
        social.put("\uD83D\uDC7B", guild.getRoleById("764954190212235275")); //Snap
        social.put("\uD83E\uDD86", guild.getRoleById("764954419832815686")); //Twitter

        social.put("AmongUs", guild.getRoleById("764933443137175562")); //Among Us
        social.put("CSGO", guild.getRoleById("764933536671072267")); //CS-Go
        social.put("LoL", guild.getRoleById("764933376104202250")); //League of Legends
        social.put("R6", guild.getRoleById("764933659505066005")); //Rainbow Six Siege
        social.put("RL", guild.getRoleById("764934139190444113")); //Rocket League
        social.put("GTA5", guild.getRoleById("769901645106380831")); //GTA 5
        social.put("Valorant", guild.getRoleById("769901625648349194")); //Valorant
        social.put("switch", guild.getRoleById("769950474195304478")); //Switch-Player

        social.put("\uD83D\uDEB4", guild.getRoleById("764933303115186177")); //Sport

        social.put("\uD83C\uDFB6", guild.getRoleById("764933242012172341")); //Musik
        social.put("🎹", guild.getRoleById("764934890297753640")); //Music-Production
        social.put("🎨", guild.getRoleById("769611792011624480")); //Kunst

        social.put("\uD83C\uDF53", guild.getRoleById("769916525103677441"));  //Baldham
        social.put("\uD83C\uDF5D", guild.getRoleById("769916493461848085"));  //Bogenhausen
        social.put("\uD83E\uDD5E", guild.getRoleById("769916451226124299"));  //Ebersberg
        social.put("\uD83C\uDF6B", guild.getRoleById("769916344489476106"));  //Freising
        social.put("\uD83C\uDF4F", guild.getRoleById("769915688969961472"));  //Garching
        social.put("\uD83E\uDD51", guild.getRoleById("769916609857978398"));  //Giesing
        social.put("\uD83E\uDD5D", guild.getRoleById("769916094260576276"));  //Hadern
        social.put("\uD83E\uDDCA", guild.getRoleById("769916653944176713"));  //Isarvorstadt
        social.put("\uD83E\uDD67", guild.getRoleById("769916147193479188"));  //Pasing
        social.put("\uD83E\uDD68", guild.getRoleById("769916384787300382"));  //Münchner Innenstadt
        social.put("\uD83C\uDF7A", guild.getRoleById("769915992221679646"));  //Schwabing
        social.put("\uD83C\uDF55", guild.getRoleById("769915836982099988"));  //Sendling
        social.put("\uD83C\uDF49", guild.getRoleById("769916045937999892"));  //Trudering

        events.put("🇦", guild.getRoleById("771852088011391016"));  //A
        events.put("🇧", guild.getRoleById("771852280915820585"));  //B
        events.put("🇨", guild.getRoleById("771852396866961478"));  //C
        events.put("🇩", guild.getRoleById("771852435866124319"));  //D
        events.put("🇪", guild.getRoleById("771852472821612584"));  //E
        events.put("🇫", guild.getRoleById("771852514340503614"));  //F
        events.put("🇬", guild.getRoleById("771852564563886080"));  //G
        events.put("🇭", guild.getRoleById("771852595017809951"));  //H
        events.put("🇮", guild.getRoleById("771852630405283871"));  //I
        events.put("🇯", guild.getRoleById("771852668418785330"));  //J
        events.put("🇰", guild.getRoleById("771852714136174624"));  //K
        events.put("🇱", guild.getRoleById("771852749033701457"));  //L
        events.put("🇲", guild.getRoleById("771852792323244102"));  //M
        events.put("🇳", guild.getRoleById("771852826502627349"));  //N
        events.put("🇴", guild.getRoleById("771852861323739147"));  //O
        events.put("🇵", guild.getRoleById("771852902137724979"));  //P
        events.put("🇶", guild.getRoleById("771852995062530048"));  //Q
        events.put("🇷", guild.getRoleById("771853039916941373"));  //R
        events.put("🇸", guild.getRoleById("771853076827078667"));  //S
        events.put("🇹", guild.getRoleById("771853115681931285"));  //T

        amongus.add("🇦");
        amongus.add("🇧");
        amongus.add("🇨");
        amongus.add("🇩");
        amongus.add("🇪");
        amongus.add("🇫");

        scribble.add("🇬");
        scribble.add("🇭");
        scribble.add("🇮");
        scribble.add("🇯");
        scribble.add("🇰");

        slf.add("🇱");
        slf.add("🇲");
        slf.add("🇳");
        slf.add("🇴");
        slf.add("🇵");

        freiesEvent.add("🇶");
        freiesEvent.add("🇷");
        freiesEvent.add("🇸");
        freiesEvent.add("🇹");

        //eventName.put()

    }

    public static void regelnadd(MessageReactionAddEvent event){

        guild.removeRoleFromMember(event.getMember(), guild.getRoleById("769931144221163550")).queue();
        guild.addRoleToMember(event.getMember(), module.get(event.getReactionEmote().getEmoji())).queue();
        guild.addRoleToMember(event.getMember(), guild.getRoleById("765603281799348277")).queue();
        guild.addRoleToMember(event.getMember(), guild.getRoleById("765603618635513917")).queue();
        guild.addRoleToMember(event.getMember(), guild.getRoleById("765603644422094869")).queue();
        guild.addRoleToMember(event.getMember(), guild.getRoleById("765603791885828126")).queue();

        EmbedBuilder embedBuilder = new EmbedBuilder();

        embedBuilder.setTitle("Willkommen auf unserem Discord Server!", discordVideo);
        embedBuilder.setDescription("Danke das du unsere Regeln akzeptiert hast.\n\nDu kannst nun dein Semester im \"willkommen\"-Channel wählen.");

        event.getMember().getUser().openPrivateChannel().queue(privateChannel -> privateChannel.sendMessage(embedBuilder.build()).queue());

    }

    public static void regelnrem(MessageReactionRemoveEvent event){

        event.getMember().getUser().openPrivateChannel().queue(privateChannel -> privateChannel.sendMessage(new EmbedBuilder().setAuthor("Uni-Bot_EIT").setDescription("Du kannst die Akzeptierung der Regeln nicht zurücknehmen." +
                "\nBei weiteren Fragen wende dich bitte an einen Maintainer.\n\nVielen Dank für dein Verständnis").build()).queue());

    }

    public static void welcomeadd(MessageReactionAddEvent event){

        guild.addRoleToMember(event.getMember(), module.get(event.getReactionEmote().getEmoji())).queue();

    }

    public static void welcomerem(MessageReactionRemoveEvent event){

        guild.removeRoleFromMember(event.getMember(), module.get(event.getReactionEmote().getEmoji())).queue();

    }

    public static void moduleadd(MessageReactionAddEvent event){

        if (event.getReactionEmote().isEmoji())
            guild.addRoleToMember(event.getMember(), module.get(event.getReactionEmote().getEmoji())).queue();

        if (event.getReactionEmote().isEmote())
            guild.addRoleToMember(event.getMember(), module.get(event.getReactionEmote().getEmote().getName())).queue();

    }

    public static void modulerem(MessageReactionRemoveEvent event){

        if (event.getReactionEmote().isEmoji())
            guild.removeRoleFromMember(event.getMember(), module.get(event.getReactionEmote().getEmoji())).queue();

        if (event.getReactionEmote().isEmote())
            guild.removeRoleFromMember(event.getMember(), module.get(event.getReactionEmote().getEmote().getName())).queue();

    }

    public static void socialadd(MessageReactionAddEvent event){

        if (event.getReactionEmote().isEmoji())
            guild.addRoleToMember(event.getMember(), social.get(event.getReactionEmote().getEmoji())).queue();

        if (event.getReactionEmote().isEmote())
            guild.addRoleToMember(event.getMember(), social.get(event.getReactionEmote().getEmote().getName())).queue();

    }

    public static void socialrem(MessageReactionRemoveEvent event){

        if (event.getReactionEmote().isEmoji())
            guild.removeRoleFromMember(event.getMember(), social.get(event.getReactionEmote().getEmoji())).queue();

        if (event.getReactionEmote().isEmote())
            guild.removeRoleFromMember(event.getMember(), social.get(event.getReactionEmote().getEmote().getName())).queue();

    }

    public static void eventadd(MessageReactionAddEvent event){

        //System.out.println(event.getReactionEmote().getEmoji());

        if (event.getReactionEmote().getEmoji().equals("\uD83C\uDFB2")) {
            guild.addRoleToMember(event.getMember(), Excel.getRole("freiesEvent")).queue();                                       //🎲
            return;
        }

        if (event.getReactionEmote().getEmoji().equals("\uD83D\uDD8C")) {
            guild.addRoleToMember(event.getMember(), Excel.getRole("Scribble")).queue();                                        //🖌
            return;
        }

        if (event.getReactionEmote().getEmoji().equals("\uD83D\uDDFA")) {
            guild.addRoleToMember(event.getMember(), Excel.getRole("StadtLandFluss")).queue();                                       //🗺
            return;
        }

        if (event.getReactionEmote().getEmoji().equals("\uD83C\uDD70")) {
            guild.addRoleToMember(event.getMember(), Excel.getRole("AmongUs")).queue();                                       //AmongUs
            return;
        }

        if (event.getReactionEmote().isEmoji()) {

            if (amongus.contains(event.getReactionEmote().getEmoji())){

                guild.addRoleToMember(event.getMember(), events.get(event.getReactionEmote().getEmoji())).queue();
                Excel.changeMemberInList("AmongUs", events.get(event.getReactionEmote().getEmoji()).getId(), true);
                return;

            }

            if (scribble.contains(event.getReactionEmote().getEmoji())){

                guild.addRoleToMember(event.getMember(), events.get(event.getReactionEmote().getEmoji())).queue();
                Excel.changeMemberInList("Scribble", events.get(event.getReactionEmote().getEmoji()).getId(), true);
                return;

            }

            if (slf.contains(event.getReactionEmote().getEmoji())){

                guild.addRoleToMember(event.getMember(), events.get(event.getReactionEmote().getEmoji())).queue();
                Excel.changeMemberInList("StadtLandFluss", events.get(event.getReactionEmote().getEmoji()).getId(), true);
                return;

            }

            if (freiesEvent.contains(event.getReactionEmote().getEmoji())){

                guild.addRoleToMember(event.getMember(), events.get(event.getReactionEmote().getEmoji())).queue();
                Excel.changeMemberInList("freiesEvent", events.get(event.getReactionEmote().getEmoji()).getId(), true);
                return;

            }

        }

        if (event.getReactionEmote().isEmote()) {

            guild.addRoleToMember(event.getMember(), events.get(event.getReactionEmote().getEmote().getName())).queue();
            Excel.changeMemberInList("GamingNight", events.get(event.getReactionEmote().getEmote().getName()).getId(), true);

        }

    }

    public static void eventrem(MessageReactionRemoveEvent event){

        List<Role> memberRollen = event.getMember().getRoles();

        if (event.getReactionEmote().getEmoji().equals("\uD83C\uDFB2")) {
            remMember(memberRollen, "freiesEvent", event.getMember());                                        //🎲
            return;
        }

        if (event.getReactionEmote().getEmoji().equals("\uD83D\uDD8C")) {
            remMember(memberRollen, "Scribble", event.getMember());                                        //🖌
            return;
        }

        if (event.getReactionEmote().getEmoji().equals("\uD83D\uDDFA")) {
            remMember(memberRollen, "StadtLandFluss", event.getMember());                                        //🗺
            return;
        }

        if (event.getReactionEmote().getEmoji().equals("\uD83C\uDD70")) {
            remMember(memberRollen, "AmongUs", event.getMember());                                        //AmongUs
            return;
        }

        if (event.getReactionEmote().isEmoji()) {

            if (amongus.contains(event.getReactionEmote().getEmoji())){

                guild.removeRoleFromMember(event.getMember(), events.get(event.getReactionEmote().getEmoji())).queue();
                Excel.changeMemberInList("AmongUs", events.get(event.getReactionEmote().getEmoji()).getId(), false);
                return;

            }

            if (scribble.contains(event.getReactionEmote().getEmoji())){

                guild.removeRoleFromMember(event.getMember(), events.get(event.getReactionEmote().getEmoji())).queue();
                Excel.changeMemberInList("Scribble", events.get(event.getReactionEmote().getEmoji()).getId(), false);
                return;

            }

            if (slf.contains(event.getReactionEmote().getEmoji())){

                guild.removeRoleFromMember(event.getMember(), events.get(event.getReactionEmote().getEmoji())).queue();
                Excel.changeMemberInList("StadtLandFluss", events.get(event.getReactionEmote().getEmoji()).getId(), false);
                return;

            }

            if (freiesEvent.contains(event.getReactionEmote().getEmoji())){

                guild.removeRoleFromMember(event.getMember(), events.get(event.getReactionEmote().getEmoji())).queue();
                Excel.changeMemberInList("freiesEvent", events.get(event.getReactionEmote().getEmoji()).getId(), false);
                return;

            }

        }

        if (event.getReactionEmote().isEmote()) {

            guild.removeRoleFromMember(event.getMember(), events.get(event.getReactionEmote().getEmote().getName())).queue();
            Excel.changeMemberInList("GamingNight", events.get(event.getReactionEmote().getEmote().getName()).getId(), false);
        }

    }

    /*public static Role roleast () {

        Role kleinsteRolle = null;
        int anzahl = -1;

        for (Map.Entry<String, Role> entry : events.entrySet()) {

            String key = entry.getKey();
            Role value = entry.getValue();

            if (anzahl < 0) {

                anzahl = guild.getMembersWithRoles(value).size();
                kleinsteRolle = value;

            }

            else if (anzahl > guild.getMembersWithRoles(value).size()) {

                anzahl = guild.getMembersWithRoles(value).size();
                kleinsteRolle = value;

            }

        }

        System.out.println(kleinsteRolle.getName());

        return  kleinsteRolle;
    }*/

    public static boolean hasEventRole (MessageReactionAddEvent event){

        for (Map.Entry<String, Role> entry : events.entrySet()) {

            String key = entry.getKey();
            Role value = entry.getValue();

            if (event.getMember().getRoles().contains(value)) {

                guild.getTextChannelById("764946848833339442").getHistoryFromBeginning(10).queue(messageHistory ->
                        messageHistory.getMessageById(event.getMessageId()).removeReaction(event.getReactionEmote().getEmoji(), event.getMember().getUser()).queue());

                return true;

            }

        }

        return false;

    }

    public static void remMember(List<Role> memberRollen, String eventName, Member member){

        for (Role value : events.values()) {

            if (memberRollen.contains(value)) {

                guild.removeRoleFromMember(member, value).queue();
                Excel.changeMemberInList(eventName, value.getId(), false);

            }

        }

    }


}
