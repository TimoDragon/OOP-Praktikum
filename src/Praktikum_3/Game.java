package Praktikum_3;

import Praktikum_3.commands.Command;
import Praktikum_3.enemy.Antivirus;
import Praktikum_3.enemy.EnemyVirus;
import Praktikum_3.enemy.PcOwner;
import Praktikum_3.map.Direction;
import Praktikum_3.map.Map;
import Praktikum_3.map.Room;

import java.util.ArrayList;
import java.util.List;

public class Game {
    private Parser parser = new Parser();
    private Map map = new Map();
    private Room aktuellerRaum;

    public static void main(String[] args) {
        Game spiel = new Game();
        spiel.spielen();
    }

    public Game() {
        this.raeumeAnlegen();
    }

    private void raeumeAnlegen() {
        Room mainboard = map.addRoom(new Room("MBD", 0 , 0));
        this.aktuellerRaum = mainboard;

        Room cpu = map.addRoom(new Room("CPU"));
        Room ram = map.addRoom(new Room("RAM"));
        Room ssd = map.addRoom(new Room("SSD"));
        Room hdd = map.addRoom(new Room("HDD"));
        Room gpu = map.addRoom(new Room("GPU"));
        Room screen = map.addRoom(new Room("SCR"));
        Room lan = map.addRoom(new Room("LAN"));

        Room mbdCpuC = map.addRoom(new Room("CBL"));
        Room cpuRamC = map.addRoom(new Room("CBL"));
        Room mbdSsdC = map.addRoom(new Room("CBL"));
        Room ssdHddC = map.addRoom(new Room("CBL"));
        Room cpuGpuC = map.addRoom(new Room("CBL"));
        Room gpuScreenC = map.addRoom(new Room("CBL"));
        Room mbdLanC = map.addRoom(new Room("CBL"));

        mainboard.setzeAusgang(Direction.NORTH, mbdCpuC);
        mainboard.setzeAusgang(Direction.EAST, mbdSsdC);
        mainboard.setzeAusgang(Direction.SOUTH, cpuGpuC);
        mainboard.setzeAusgang(Direction.WEST, mbdLanC);

        mbdCpuC.setzeAusgang(Direction.NORTH, cpu);

        cpu.setzeAusgang(Direction.EAST, cpuRamC);
        cpuRamC.setzeAusgang(Direction.EAST, ram);

        mbdSsdC.setzeAusgang(Direction.EAST, ssd);

        ssd.setzeAusgang(Direction.EAST, ssdHddC);
        ssdHddC.setzeAusgang(Direction.NORTH, hdd);

        cpuGpuC.setzeAusgang(Direction.SOUTH, gpu);
        gpu.setzeAusgang(Direction.EAST, gpuScreenC);
        gpuScreenC.setzeAusgang(Direction.SOUTH, screen);

        mbdLanC.setzeAusgang(Direction.WEST, lan);

        ram.setEnemy(new Antivirus("Windows Defender"));
        screen.setEnemy(new PcOwner(""));
        lan.setEnemy(new EnemyVirus("Fortnite V-Bucks.exe"));

    }

    public void spielen() {
        this.willkommenstextAusgeben();

        Command command;
        while (true) {
            command = this.parser.liefereBefehl();

            if (this.verarbeiteBefehl(command)) {
                System.out.println("Danke für dieses Spiel. Auf Wiedersehen.");
                break;
            }
        }
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

        String befehl = command.getCommand();

        switch (befehl) {
            case "help" -> this.hilfstextAusgeben();
            case "go" -> this.wechsleRaum(command);
            case "quit" -> moechteBeenden = this.beenden(command);
            case "map" -> this.map.printMap(aktuellerRaum);
            default -> System.out.println("Ich weiß nicht, was Sie meinen...");
        }

        return moechteBeenden;
    }

    private void hilfstextAusgeben() {
        System.out.println("Sie haben sich verlaufen. Sie sind allein.");
        System.out.println("Sie irren auf dem Unigelände herum.");
        System.out.println();
        System.out.println("Ihnen stehen folgende Befehle zur Verfügung:");
        this.parser.zeigeBefehle();
    }

    private void wechsleRaum(Command command) {
        if (!command.hasArgument()) {
            System.out.println("Wohin möchten Sie gehen?");
            return;
        }

        try {
            Direction direction = Direction.valueOf(command.getArgument().toUpperCase());

            Room naechsterRaum = this.aktuellerRaum.gibAusgang(direction);

            if (naechsterRaum == null) {
                System.out.println("Dort ist keine Tür!");
                return;
            }

            this.aktuellerRaum = naechsterRaum;

            System.out.println(this.aktuellerRaum.gibLangeBeschreibung());
            if (this.aktuellerRaum.getEnemy() != null) {

            }

        } catch (IllegalArgumentException e) {
            System.out.println("Das ist keine Richtung!");
        }
    }

    private boolean beenden(Command command) {
        boolean hasArgument = command.hasArgument();

        if (!hasArgument) {
            System.out.println("Was soll beendet werden?");
        }

        return hasArgument;
    }
}