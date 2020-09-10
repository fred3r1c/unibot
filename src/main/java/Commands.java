public enum Commands {

    hallo, unknown, termine;

    public static Commands eval(String msg) {

        msg = msg.toLowerCase();

        if(msg.equals("hallo"))
            return hallo;

        if (msg.equals("termine") || msg.equals("kalender"))
            return termine;

        return unknown;
    }
}