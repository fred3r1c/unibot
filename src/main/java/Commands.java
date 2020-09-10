public enum Commands {

    hallo, unknown, termine, help;

    public static Commands eval(String msg) {

        msg = msg.toLowerCase();

        if(msg.equals("!hallo"))
            return hallo;

        if (msg.equals("!termine") || msg.equals("!kalender"))
            return termine;

        if (msg.equals("!help") || msg.equals("!h") || msg.equals("!hilfe"))
            return help;
        
        return unknown;
    }
}