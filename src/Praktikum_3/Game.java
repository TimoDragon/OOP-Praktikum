package Praktikum_3;

//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by Fernflower decompiler)
//

class Game {
    private Parser parser;
    private Map map;
    private Room aktuellerRaum;

    public static void main(String[] args) {
        Game spiel = new Game();
        spiel.spielen();
    }

    public Game() {
        this.raeumeAnlegen();
        this.parser = new Parser();
    }

    private void raeumeAnlegen() {



    }

    public void spielen() {
        this.willkommenstextAusgeben();

        Command command;
        for(boolean beendet = false; !beendet; beendet = this.verarbeiteBefehl(command)) {
            command = this.parser.liefereBefehl();
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

    private boolean verarbeiteBefehl(Command command) {
        boolean moechteBeenden = false;
        if (command.istUnbekannt()) {
            System.out.println("Ich wei� nicht, was Sie meinen...");
            return false;
        } else {
            String befehlswort = command.gibBefehlswort();
            if (befehlswort.equals("help")) {
                this.hilfstextAusgeben();
            } else if (befehlswort.equals("go")) {
                this.wechsleRaum(command);
            } else if (befehlswort.equals("quit")) {
                moechteBeenden = this.beenden(command);
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