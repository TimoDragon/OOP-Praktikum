package Praktikum_3;

//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by Fernflower decompiler)
//

import java.util.ArrayList;
import java.util.List;

class Game {
    private Parser parser;
    private Map map;
    private Room aktuellerRaum;

    public static void main(String[] args) {
        Game spiel = new Game();
        spiel.spielen();
    }

    public Game() {
        this.map = new Map(this.raeumeAnlegen());
        this.parser = new Parser();
    }

    private List<Room> raeumeAnlegen() {
        List<Room> rooms = new ArrayList<>();
        Room start = new Room("Test1", 0 , 0);
        this.aktuellerRaum = start;

        Room r2 = new Room("Test1");
        Room r3 = new Room("Test1");
        Room r4 = new Room("Test1");

        start.setzeAusgang("north", r2);
        start.setzeAusgang("east", r3);
        start.setzeAusgang("west",r4);


        Room r5 = new Room("Test1");
        Room r6 = new Room("Test1");
        r4.setzeAusgang("west", r5);
        r5.setzeAusgang("west", r6);


        Room r7 = new Room("Test1");
        Room r8 = new Room("Test1");

        r6.setzeAusgang("north",r7);
        r7.setzeAusgang("north",r8);

        rooms.add(start);
        rooms.add(r2);
        rooms.add(r3);
        rooms.add(r4);
        rooms.add(r5);
        rooms.add(r6);
        rooms.add(r7);
        rooms.add(r8);

        return rooms;
    }

    public void spielen() {
        this.willkommenstextAusgeben();

        Command command;
        for(boolean beendet = false; !beendet; beendet = this.verarbeiteBefehl(command)) {
            command = this.parser.liefereBefehl();
        }

        System.out.println("Danke für dieses Spiel. Auf Wiedersehen.");
    }

    private void willkommenstextAusgeben() {
        System.out.println();
        System.out.println("Willkommen zu Zuul!");
        System.out.println("Zuul ist ein neues, unglaublich langweiliges Spiel.");
        System.out.println("Tippen sie 'help', wenn Sie Hilfe brauchen.");
        System.out.println();
        System.out.println(this.aktuellerRaum.gibLangeBeschreibung());
    }

    private boolean verarbeiteBefehl(Command command) {
        boolean moechteBeenden = false;
        if (command.istUnbekannt()) {
            System.out.println("Ich wei� nicht, was Sie meinen...");
            return false;
        } else {
            String befehl = command.gibBefehlswort();
            if (befehl.equals("help")) {
                this.hilfstextAusgeben();
            } else if (befehl.equals("go")) {
                this.wechsleRaum(command);
            } else if (befehl.equals("quit")) {
                moechteBeenden = this.beenden(command);
            } else if (befehl.equals("map")) {
                this.map.printMap();
            }
            return moechteBeenden;
        }
    }

    private void hilfstextAusgeben() {
        System.out.println("Sie haben sich verlaufen. Sie sind allein.");
        System.out.println("Sie irren auf dem Unigel�nde herum.");
        System.out.println();
        System.out.println("Ihnen stehen folgende Befehle zur Verf�gung:");
        this.parser.zeigeBefehle();
    }

    private void wechsleRaum(Command command) {
        if (!command.hatZweitesWort()) {
            System.out.println("Wohin m�chten Sie gehen?");
        } else {
            String richtung = command.gibZweitesWort();
            Room naechsterRaum = this.aktuellerRaum.gibAusgang(richtung);
            if (naechsterRaum == null) {
                System.out.println("Dort ist keine T�r!");
            } else {
                this.aktuellerRaum = naechsterRaum;
                System.out.println(this.aktuellerRaum.gibLangeBeschreibung());
            }

        }
    }

    private boolean beenden(Command command) {
        if (command.hatZweitesWort()) {
            System.out.println("Was soll beendet werden?");
            return false;
        } else {
            return true;
        }
    }
}