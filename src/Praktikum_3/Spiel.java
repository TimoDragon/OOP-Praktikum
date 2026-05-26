package Praktikum_3;

//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by Fernflower decompiler)
//

class Spiel {
    private Parser parser;
    private Raum aktuellerRaum;

    public static void main(String[] args) {
        Spiel spiel = new Spiel();
        spiel.spielen();
    }

    public Spiel() {
        this.raeumeAnlegen();
        this.parser = new Parser();
    }

    private void raeumeAnlegen() {
        Raum draussen = new Raum("vor dem Haupteingang der Universit�t");
        Raum hoersaal = new Raum("in einem Vorlesungssaal");
        Raum cafeteria = new Raum("in der Cafeteria der Uni");
        Raum labor = new Raum("in einem Rechnerraum");
        Raum buero = new Raum("im Verwaltungsb�ro der Informatik");
        draussen.setzeAusgang("east", hoersaal);
        draussen.setzeAusgang("south", labor);
        draussen.setzeAusgang("west", cafeteria);
        hoersaal.setzeAusgang("west", draussen);
        cafeteria.setzeAusgang("east", draussen);
        labor.setzeAusgang("north", draussen);
        labor.setzeAusgang("east", buero);
        buero.setzeAusgang("west", labor);
        this.aktuellerRaum = draussen;
    }

    public void spielen() {
        this.willkommenstextAusgeben();

        Befehl befehl;
        for(boolean beendet = false; !beendet; beendet = this.verarbeiteBefehl(befehl)) {
            befehl = this.parser.liefereBefehl();
        }

        System.out.println("Danke f�r dieses Spiel. Auf Wiedersehen.");
    }

    private void willkommenstextAusgeben() {
        System.out.println();
        System.out.println("Willkommen zu Zuul!");
        System.out.println("Zuul ist ein neues, unglaublich langweiliges Spiel.");
        System.out.println("Tippen sie 'help', wenn Sie Hilfe brauchen.");
        System.out.println();
        System.out.println(this.aktuellerRaum.gibLangeBeschreibung());
    }

    private boolean verarbeiteBefehl(Befehl befehl) {
        boolean moechteBeenden = false;
        if (befehl.istUnbekannt()) {
            System.out.println("Ich wei� nicht, was Sie meinen...");
            return false;
        } else {
            String befehlswort = befehl.gibBefehlswort();
            if (befehlswort.equals("help")) {
                this.hilfstextAusgeben();
            } else if (befehlswort.equals("go")) {
                this.wechsleRaum(befehl);
            } else if (befehlswort.equals("quit")) {
                moechteBeenden = this.beenden(befehl);
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

    private void wechsleRaum(Befehl befehl) {
        if (!befehl.hatZweitesWort()) {
            System.out.println("Wohin m�chten Sie gehen?");
        } else {
            String richtung = befehl.gibZweitesWort();
            Raum naechsterRaum = this.aktuellerRaum.gibAusgang(richtung);
            if (naechsterRaum == null) {
                System.out.println("Dort ist keine T�r!");
            } else {
                this.aktuellerRaum = naechsterRaum;
                System.out.println(this.aktuellerRaum.gibLangeBeschreibung());
            }

        }
    }

    private boolean beenden(Befehl befehl) {
        if (befehl.hatZweitesWort()) {
            System.out.println("Was soll beendet werden?");
            return false;
        } else {
            return true;
        }
    }
}