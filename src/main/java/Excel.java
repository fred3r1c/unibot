package main.java;

import net.dv8tion.jda.api.entities.Role;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Row;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.Random;

public class Excel {

    static Random randy = new Random();

    public static void createEvent(String eventName, Role[] gruppen, int minpR, int maxpR) {                            //In Zelle 0 steht die Rollen ID
                                                                                                                        //In Zelle 1 steht die aktuelle Anzahl der Personen in der Rolle
        HSSFWorkbook workbook = new HSSFWorkbook();                                                                     //In Zelle 2 sthet die minimale Anzahl der Personen
        HSSFSheet sheet = workbook.createSheet(eventName);                                                              //In Zelle 3 sthet die maximale Anzahl der Personen

        for (int i = 0 ; i < gruppen.length ; i++){

            Row row = sheet.createRow(i);

            row.createCell(0).setCellValue(gruppen[i].getId());
            row.createCell(1).setCellValue(0);
            row.createCell(2).setCellValue(minpR);
            row.createCell(3).setCellValue(maxpR);

        }

        try {
            FileOutputStream out = new FileOutputStream(new File("//var//lib//jenkins//workspace//MoritzUnibot//src//main//resources//Files//" + eventName + ".xlsx"));
            //FileOutputStream out = new FileOutputStream(new File("src\\main\\resources\\Files\\" + eventName + ".xlsx"));
            workbook.write(out);
            out.close();
            sudo.out("Event erfolgreich erstellt und abgespeichert", true, "createEvent");
        }
        catch (Exception e) {
            e.printStackTrace();
            sudo.out("Event konnte nicht abgespeichert werden. Fehlernachricht: " + e, false, "createEvent");
        }
    }

    public static HSSFWorkbook getEvent(String eventName) {

        try {
            FileInputStream file = new FileInputStream(new File("//var//lib//jenkins//workspace//MoritzUnibot//src//main//resources//Files//" + eventName + ".xlsx"));
            //FileInputStream file = new FileInputStream(new File("src\\main\\resources\\Files\\" + eventName + ".xlsx"));

            HSSFWorkbook workbook = new HSSFWorkbook(file);

            return workbook;

        } catch (FileNotFoundException e) {
            e.printStackTrace();
            sudo.out("Event \"" + eventName + "\" konnte nicht gefunden werden. Fehlermeldung: " + e , false , "getEvent");
        } catch (IOException e) {
            e.printStackTrace();
            sudo.out("Eventname: " + eventName + "\nNicht sicher was das Problem ist. Fehlermeldung: " + e , false , "getEvent");
        }

        return null;

    }

    public static void writeEvent(String eventName, HSSFWorkbook workbook){

        try {
            FileOutputStream out = new FileOutputStream(new File("//var//lib//jenkins//workspace//MoritzUnibot//src//main//resources//Files//" + eventName + ".xlsx"));
            //FileOutputStream out = new FileOutputStream(new File("src\\main\\resources\\Files\\" + eventName + ".xlsx"));
            workbook.write(out);
            out.close();
            sudo.out("Event " + eventName + " erfolgreich Abgespeichert", true, "writeEvent");
        }
        catch (Exception e) {
            e.printStackTrace();
            sudo.out("Event " + eventName + " konnte nicht abgespeichert werden. Fehlermeldung: " + e, false, "writeEvent");
        }

    }

    public static void writeEventoo(String eventName, HSSFWorkbook workbook){

        try {
            FileOutputStream out = new FileOutputStream(new File("//var//lib//jenkins//workspace//MoritzUnibot//src//main//resources//Files//" + eventName + ".xlsx"));
            //FileOutputStream out = new FileOutputStream(new File("src\\main\\resources\\Files\\" + eventName + ".xlsx"));
            workbook.write(out);
            out.close();
        }
        catch (Exception e) {
            e.printStackTrace();
            sudo.out("Event " + eventName + " konnte nicht abgespeichert werden. Fehlermeldung: " + e, false, "writeEvent");
        }

    }

    public static void editEvent(String eventName, Role[] zusaetzlicheGruppen){

        editEvent(eventName, zusaetzlicheGruppen, -1, -1);

    }

    public static void editEvent(String eventName, Role[] zusaetzlicheGruppen, int minpRneu, int maxpRneu){

        HSSFWorkbook workbook = getEvent(eventName);
        HSSFSheet sheet = workbook.getSheetAt(0);

        int length = sheet.getLastRowNum();

        if (minpRneu >= 0 && maxpRneu >= 0){

            for (int i = 0 ; i <= length; i++){

                sheet.getRow(i).getCell(2).setCellValue(minpRneu);
                sheet.getRow(i).getCell(3).setCellValue(maxpRneu);

            }

        }


        for (int i = 0 ; i < zusaetzlicheGruppen.length ; i++){

            Row row = sheet.createRow(length + i + 1);

            row.createCell(0).setCellValue(zusaetzlicheGruppen[i].getId());
            row.createCell(1).setCellValue(0);
            if (minpRneu >= 0)
                row.createCell(2).setCellValue(minpRneu);
            else row.createCell(2).setCellValue(sheet.getRow(0).getCell(2).getNumericCellValue());

            if (maxpRneu >= 0)
                row.createCell(3).setCellValue(maxpRneu);
            else row.createCell(3).setCellValue(sheet.getRow(0).getCell(3).getNumericCellValue());

        }

        sudo.out("Event " + eventName + " wurde erfolgreich erweitert.", true, "editEvent");

        writeEvent(eventName, workbook);

    }

    public static Role getRole (String eventName){

        HSSFWorkbook workbook = getEvent(eventName);
        HSSFSheet sheet = workbook.getSheetAt(0);

        String roleID = null;
        int zeile;
        double anzahl = -1;
        boolean zugewiesen = false;

        for (int i = 0 ; i <= sheet.getLastRowNum() ; i++){

            if (anzahl < 0
                    && sheet.getRow(i).getCell(1).getNumericCellValue() <= sheet.getRow(i).getCell(3).getNumericCellValue()){

                roleID = sheet.getRow(i).getCell(0).getStringCellValue();
                anzahl = sheet.getRow(i).getCell(1).getNumericCellValue();
                zeile = i;

            }

            if (sheet.getRow(i).getCell(1).getNumericCellValue() < sheet.getRow(i).getCell(2).getNumericCellValue()){

                roleID = sheet.getRow(i).getCell(0).getStringCellValue();
                anzahl = sheet.getRow(i).getCell(1).getNumericCellValue();
                sheet.getRow(i).getCell(1).setCellValue(sheet.getRow(i).getCell(1).getNumericCellValue() + 1);
                zugewiesen = true;
                break;

            } else if (sheet.getRow(i).getCell(1).getNumericCellValue() < anzahl
                    && sheet.getRow(i).getCell(1).getNumericCellValue() <= sheet.getRow(i).getCell(3).getNumericCellValue()){

                roleID = sheet.getRow(i).getCell(0).getStringCellValue();
                anzahl = sheet.getRow(i).getCell(1).getNumericCellValue();
                sheet.getRow(i).getCell(1).setCellValue(sheet.getRow(i).getCell(1).getNumericCellValue() + 1);
                zeile = i;

            }

        }

        if (roleID == null){

            sudo.out("Alle Rollen sind voll besetzt in Event:" + eventName, false, "getRole");
            return null;

        }

        writeEventoo(eventName, workbook);

        return EventListener.guild.getRoleById(roleID);

    }

    public static Role[] getRoles (HSSFWorkbook workbook){

        HSSFSheet sheet = workbook.getSheetAt(0);

        Role[] rollen = new Role[sheet.getLastRowNum() + 1];

        for ( int i = 0 ; i <= sheet.getLastRowNum() ; i++){

            rollen[i] = EventListener.guild.getRoleById(sheet.getRow(i).getCell(0).getStringCellValue());

        }

        return rollen;

    }

    public static int getMaxTeilnehmer (HSSFWorkbook workbook){

        HSSFSheet sheet = workbook.getSheetAt(0);
        double maxTeilnehmer = 0;

        for (int i = 0 ; i <= sheet.getLastRowNum() ; i++)
            maxTeilnehmer += sheet.getRow(i).getCell(1).getNumericCellValue();

        return (int) maxTeilnehmer;

    }

    public static void deleteEvent (String eventName){

        try {

            Files.delete(Paths.get("//var//lib//jenkins//workspace//MoritzUnibot//src//main//resources//Files//" + eventName + ".xlsx"));
            //Files.delete(Paths.get("src\\main\\resources\\Files\\" + eventName + ".xlsx"));

            sudo.out("Event " + eventName + " wurde erfolgreich gelöscht", true, "deleteEvent");

        } catch (IOException e) {

            e.printStackTrace();

            sudo.out("Event " + eventName + " konnte nicht gelöscht werden. Fehlermeldung: " + e, false, "deleteEvent");

        }

    }

    public static String purge (String eventName, boolean delete){

        HSSFWorkbook workbook = getEvent(eventName);

        if (workbook == null)
            return "Fehler. Siehe <#778930065806589962>";

        Role[] rollen = getRoles(workbook);

        Arrays.stream(rollen).forEach(role -> {


            //System.out.println(role.getName());

            EventListener.guild.getMembersWithRoles(role).forEach(member -> {

                //System.out.println(member.toString() + "\n\n");
                EventListener.guild.removeRoleFromMember(member, role).queue();

            });

        });

        //int i = 0;
        //
        //if (EventListener.guild.getMembersWithRoles(rollen).size() == 0) System.out.println("es is null");
        //
        //EventListener.guild.getMembersWithRoles(rollen).forEach(member -> {
        //
        //        //System.out.println(member.toString() + "\n\n");
        //        for (Role role : rollen) EventListener.guild.removeRoleFromMember(member, role).queue();
        //
        //});

        sudo.out("Es werden " + getMaxTeilnehmer(workbook) + "Membern die Eventrollen vom Event " + eventName + " entzogen." , true, "purge");

        resetEvent(eventName);



        if (delete){

            deleteEvent(eventName);

            return "Purge erfolgreich gestartet und delete angefordert (siehe <#778930065806589962>).";

        }

        return "Purge erfolgreich gestartet.";

    }

    public static void changeMemberInList (String eventName, String RoleId, boolean add){

        HSSFWorkbook workbook = getEvent(eventName);
        HSSFSheet sheet = workbook.getSheetAt(0);

        for (int i = 0 ; i <= sheet.getLastRowNum() ; i++){

            if (sheet.getRow(i).getCell(0).getStringCellValue().equals(RoleId)) {

                sheet.getRow(i).getCell(1).setCellValue(sheet.getRow(i).getCell(1).getNumericCellValue() + (add ? 1: -1));
                writeEventoo(eventName, workbook);
                return;

            }
        }

        sudo.out("Moritz hats wohl nicht drauf", false, "addMemberToList");

    }

    public static void resetEvent (String eventName){

        HSSFWorkbook workbook = getEvent(eventName);
        HSSFSheet sheet = workbook.getSheetAt(0);

        for (int i = 0 ; i <= sheet.getLastRowNum() ; i++)
            sheet.getRow(i).getCell(1).setCellValue(0);

        writeEvent(eventName, workbook);

    }



}
