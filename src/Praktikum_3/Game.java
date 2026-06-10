package Praktikum_3;

import Praktikum_3.commands.Command;
import Praktikum_3.enemy.Enemy;
import Praktikum_3.items.Item;
import Praktikum_3.items.StickyNote;
import Praktikum_3.items.Weapon;
import Praktikum_3.map.Direction;
import Praktikum_3.map.Map;
import Praktikum_3.map.Room;
import Praktikum_3.user.User;

import java.util.Random;
import java.util.Scanner;

public class Game {
    private final Random random = new Random();
    private User user;
    private Parser parser = new Parser();
    private Map map = new Map();
    private Room aktuellerRaum;
    private boolean unlockedLanPort = false;

    public static void main(String[] args) {
        Game spiel = new Game();
        spiel.spielen();
    }

    /**
     * Konstruktor der Klasse Game
     */
    public Game() {
        this.raeumeAnlegen();
    }

    /**
     * Methode zum anlegen der Räume
     */
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
        Room mbdGpuC = map.addRoom(new Room("CBL"));
        Room gpuScreenC = map.addRoom(new Room("CBL"));
        Room mbdLanC = map.addRoom(new Room("CBL"));

        mainboard.setzeAusgang(Direction.NORTH, mbdCpuC);
        mainboard.setzeAusgang(Direction.EAST, mbdSsdC);
        mainboard.setzeAusgang(Direction.SOUTH, mbdGpuC);
        mainboard.setzeAusgang(Direction.WEST, mbdLanC);

        mbdCpuC.setzeAusgang(Direction.NORTH, cpu);
        mbdCpuC.setzeAusgang(Direction.SOUTH, mainboard);

        cpu.setzeAusgang(Direction.EAST, cpuRamC);
        cpu.setzeAusgang(Direction.SOUTH, mbdCpuC);

        cpuRamC.setzeAusgang(Direction.EAST, ram);
        cpuRamC.setzeAusgang(Direction.WEST, cpu);

        ram.setzeAusgang(Direction.WEST, cpuRamC);

        mbdSsdC.setzeAusgang(Direction.EAST, ssd);
        mbdSsdC.setzeAusgang(Direction.WEST, mainboard);

        ssd.setzeAusgang(Direction.EAST, ssdHddC);
        ssd.setzeAusgang(Direction.WEST, mbdSsdC);

        ssdHddC.setzeAusgang(Direction.NORTH, hdd);
        ssdHddC.setzeAusgang(Direction.WEST, ssd);

        hdd.setzeAusgang(Direction.SOUTH, ssdHddC);

        mbdGpuC.setzeAusgang(Direction.NORTH, mainboard);
        mbdGpuC.setzeAusgang(Direction.SOUTH, gpu);

        gpu.setzeAusgang(Direction.NORTH, mbdGpuC);
        gpu.setzeAusgang(Direction.EAST, gpuScreenC);

        gpuScreenC.setzeAusgang(Direction.SOUTH, screen);
        gpuScreenC.setzeAusgang(Direction.WEST, gpu);

        screen.setzeAusgang(Direction.NORTH, gpuScreenC);

        mbdLanC.setzeAusgang(Direction.EAST, mainboard);
        mbdLanC.setzeAusgang(Direction.WEST, lan);

        lan.setzeAusgang(Direction.EAST, mbdLanC);
        lan.setzeAusgang(Direction.WEST, new Room("exit"));

        StickyNote stickyNote = new StickyNote("Passwort: ******");

        cpu.setEnemy(new Enemy("Windows Defender", 60, 120, 10), Direction.EAST);
        screen.setEnemy(new Enemy("Layer 8", 20, 80, 5, stickyNote), Direction.NORTH);
        lan.setEnemy(new Enemy("Fortnite V-Bucks.exe", 10, 60, 20), Direction.EAST);
    }

    /**
     * Game
     */
    public void spielen() {
        this.willkommenstextAusgeben();

        Scanner scanner = new Scanner(System.in);
        String name = scanner.nextLine();

        System.out.println("Hallo " + name + "!\n");

        System.out.println("Tippen sie 'help', wenn Sie Hilfe brauchen.");
        System.out.println();
        System.out.println(this.aktuellerRaum.gibLangeBeschreibung());

        this.user = new User(name);

        Command command;
        while (true) {
            command = this.parser.liefereBefehl();

            if (this.verarbeiteBefehl(command)) {
                System.out.println("Danke für dieses Spiel. Auf Wiedersehen.");
                break;
            }
        }
    }

    /**
     * Gibt den Willkommenstext aus
     */
    private void willkommenstextAusgeben() {
        System.out.println();
        System.out.println("Willkommen zu Zuul!");
        System.out.println("Zuul ist ein neues, unglaublich langweiliges Spiel.");
        System.out.println("Bitte gebe deinen Namen ein:");
    }

    /**
     * Befehlsverarbeitung
     * @param command der übrergebene Befehl der überprüft werden soll
     * @return boolean
     */
    private boolean verarbeiteBefehl(Command command) {
        boolean moechteBeenden = false;

        String befehl = command.getCommand();

        if (befehl == null) {
            System.out.println("Ich weiß nicht, was Sie meinen...");
            return moechteBeenden;
        }

        switch (befehl) {
            case "help" -> this.hilfstextAusgeben();
            case "go" -> this.wechsleRaum(command);
            case "quit" -> moechteBeenden = this.beenden(command);
            case "map" -> this.map.printMap(aktuellerRaum);
            case "attack" -> attack(command);
            case "use" -> useItem(command);
            case "inv" -> this.user.getInventory().printInventory();
            case "collect" -> collectItem();
            case "look" -> look();
            default -> System.out.println("Ich weiß nicht, was Sie meinen...");
        }

        System.out.println("\nBefehle bis jetzt eingegeben: " + this.parser.getCommand().getCommandCount());

        return moechteBeenden;
    }

    /**
     * Gibt den hilfe Text aus
     */
    private void hilfstextAusgeben() {
        System.out.println("Sie befinden sich im: " + this.aktuellerRaum.getName());
        if (this.aktuellerRaum.getEnemy() == null) {
            System.out.println("Es befindet sich kein Gegner im Raum");
        } else {
            System.out.println("Gegner im Raum: " + this.aktuellerRaum.getEnemy().getName());
        }
        this.parser.zeigeBefehle();

    }

    /**
     * Methode zum wechseln des Raums
     * @param command Command
     */
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

            if (this.aktuellerRaum.getEnemy() != null && !direction.equals(this.aktuellerRaum.getFreierAusgang())) {
                System.out.println("Diese Richtung ist vom Gegner versperrt. Besiege entweder den Gegner oder nutze die letzte Tür.");
                return;
            }


            if (naechsterRaum.getName().equals("exit")) {
                if (!unlockedLanPort) {
                    System.out.println("Der Ausgang ist verschlossen. Du musst erst die Firewall deaktivieren.");
                    return;
                }

                System.out.println("Du hast erfolgreich den PC verlassen und breitest dich auf andere Geräte aus. Das Spiel ist vorbei.");
                System.exit(0);
            }

            this.aktuellerRaum = naechsterRaum;

            System.out.println(this.aktuellerRaum.gibLangeBeschreibung());

            if (this.aktuellerRaum.getEnemy() != null) {
                System.out.println("Gegner im Raum: " + this.aktuellerRaum.getEnemy().getName());
            }
        } catch (IllegalArgumentException e) {
            System.out.println("Das ist keine Richtung!");
        }
    }

    /**
     * Attacke des User
     * @param command Command zum angreifen
     */
    private void attack(Command command) {
        Enemy enemy = this.aktuellerRaum.getEnemy();

        if (enemy == null) {
            System.out.println("In diesem Raum befindet sich kein Gegner!");
            return;
        }

        if (!command.hasArgument()) {
            System.out.println("Wo Waffe?");
            return;
        }

        Integer slot = null;
        try {
            slot = Integer.parseInt(command.getArgument());
        } catch (IllegalArgumentException e) {
            System.out.println("Ungültiger Slot!");
        }

        if (slot == null) {
            return;
        }

        if (slot < 0 || slot >= user.getInventory().getItems().size()) {
            System.out.println("Ungültiger Slot!");
            return;
        }

        Item item = user.getInventory().getItem(slot);
        if (!(item instanceof Weapon weapon)) {
            System.out.println("Das ist keine Waffe!");
            return;
        }

        System.out.println( enemy.getName() +  " Hat noch: \nFirewall: " + enemy.getFirewall()+ "\nSystemintegrity: " +  enemy.getSystemIntegrity());

        if (random.nextFloat() > 0.75f) {
            System.out.println("Kein Treffer!");
        } else {
            enemy.takeDamage(weapon.getDamage());
            System.out.println("Treffer! " + enemy.getName() + " hat " + weapon.getDamage() + " Schaden erlitten");
        }

        if (enemy.isDead()) {
            System.out.println("Sie haben den " + this.aktuellerRaum.getEnemy().getName() + " besiegt!");

            if (enemy.getItem() != null) {
                this.aktuellerRaum.setItem(enemy.getItem());
                System.out.println("Der Gegner hat ein Item fallen gelassen.");
            }

            aktuellerRaum.setEnemy(null, null);

            return;
        }

        try {
            Thread.sleep(3000);
            this.enemyAttack();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    /**
     * Attacke des Gegners
     */
    private void enemyAttack() {
        Enemy enemy = this.aktuellerRaum.getEnemy();

        if (random.nextFloat() > 0.5f) {
            System.out.println("Der Gegner hat seinen Angriff verfehlt!");
            return;
        }

        int damage = enemy.getAttackDamage();
        user.takeDamage(damage);

        System.out.println("Der Gegner hat seinen Angriff getroffen. Du erleidest " + damage + " Schaden");
        System.out.println(this.user.getName() + " HP: " + this.user.getHP());

        if (user.isDead()) {
            System.out.println("Du bist Gestorben!");
            System.exit(0);
        }
    }

    /**
     * benutzen des Items aus dem Inventar
     * @param command Command
     */
    public void useItem(Command command) {
        if (!command.hasArgument()) {
            System.out.println("Was soll benutzt werden?");
            return;
        }

        int slot = Integer.parseInt(command.getArgument());

        if (slot < 0 || slot >= user.getInventory().getItems().size()) {
            System.out.println("Ungültiger Slot!");
            return;
        }

        Item item = user.getInventory().getItem(slot);

        if (item instanceof StickyNote note && this.aktuellerRaum.getName().equalsIgnoreCase("RAM")) {
            this.unlockedLanPort = true;
            user.getInventory().getItems().remove(item);
            System.out.println("Du hast erfolgreich Root zugriff erlangt und die Firewall deaktiviert.");
            return;
        }

        if ((item instanceof Weapon weapon)) {
            System.out.println("Dieses Item kannst du nicht benutzen!");
            return;
        }
    }

    /**
     * Einsammeln des Items im Raum, wenn vorhanden
     */
    public void collectItem() {
        if(this.aktuellerRaum.getItem() == null) {
            System.out.println("Kein Item im Raum");
            return;
        }

        Item item = this.aktuellerRaum.getItem();
        user.getInventory().addItem(item);
        System.out.println(item.getName() + " eingesammelt!");
        this.aktuellerRaum.setItem(null);

        if (item instanceof StickyNote) {
            System.out.println("Du hast das Passwort gefunden. Dieses kann im RAM benutzt werden");
        }
    }

    /**
     * Gibt auf der Kommandozeile aus, ob sich ein Item im Raum befindet oder nicht
     */
    private void look() {
        Item item = this.aktuellerRaum.getItem();

        if (item == null) {
            System.out.println("Kein Item im Raum.");
            return;
        }

        System.out.println("Item im Raum: " + item.getName());
    }

    /**
     * gibt zurück, wenn der richtige Command zum beenden des Spiels übergeben wird
     * @param command der übergebene Command
     * @return boolean
     */
    private boolean beenden(Command command) {
        boolean hasArgument = command.hasArgument();

        if (!hasArgument) {
            System.out.println("Was soll beendet werden?");
        }

        return hasArgument;
    }
}