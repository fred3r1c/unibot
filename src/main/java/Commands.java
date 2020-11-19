package main.java;

public enum Commands {

    hallo, unknown, termine, help, stundenplan, createEvent, purge, editEvent;

    public static Commands eval(String msg) {

        msg = msg.toLowerCase();

        if(msg.equals("!hallo"))
            return hallo;

        if (msg.equals("!termine") || msg.equals("!kalender"))
            return termine;

        if (msg.equals("!help") || msg.equals("!h") || msg.equals("!hilfe"))
            return help;

        if (msg.equals("!stundenplan") || msg.equals("!plan"))
            return stundenplan;

        if (msg.equals("!createevent"))
            return createEvent;

        if (msg.equals("!purge"))
            return purge;

        if (msg.equals("!editevent"))
            return editEvent;
        
        return unknown;
    }
}