package Praktikum_3.map;

import Praktikum_3.enemy.Enemy;
import Praktikum_3.items.Item;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Set;

public class Room {
    private final String name;
    private HashMap<Direction, Room> ausgaenge = new HashMap<>();
    private Item item;
    private Enemy enemy;
    private int yCoordinate;
    private int xCoordinate;
    private Direction freierAusgang;


    /**
     * Konstrukto der Klasse Room
     * @param name Name des Raums
     */
    public Room(String name) {
        this.name = name;
    }

    /**
     * Konstruktor der Klasse Room
     * @param name Name des Raums
     * @param y y-Koordinate
     * @param x x-Koordinate
     */
    public Room(String name, int y, int x) {
        this.name = name;
        this.xCoordinate = x;
        this.yCoordinate = y;
    }

    /**
     * Gibt den Namen des Raums zurück
     * @return name
     */
    public String getName() {
        return this.name;
    }

    /**
     * Setzt von einen Raum den Ausgang und die jeweilligen Koordinaten
     * @param direction die Richtung des Ausgangs
     * @param nachbar der Nachbarraum
     */
    public void setzeAusgang(Direction direction, Room nachbar) {
        switch (direction) {
            case NORTH:
                nachbar.setXCoordinate(this.xCoordinate);
                nachbar.setYCoordinate(this.yCoordinate + 1);
                break;

            case SOUTH:
                nachbar.setXCoordinate(this.xCoordinate);
                nachbar.setYCoordinate(this.yCoordinate - 1);
                break;

            case WEST:
                nachbar.setXCoordinate(this.xCoordinate - 1);
                nachbar.setYCoordinate(this.yCoordinate);
                break;

            case EAST:
                nachbar.setXCoordinate(this.xCoordinate + 1);
                nachbar.setYCoordinate(this.yCoordinate);
                break;
        }

        this.ausgaenge.put(direction, nachbar);
    }


    /**
     * Gibt den Namen des Raums zurück
     * @return name
     */
    public String gibKurzbeschreibung() {
        return this.name;
    }

    /**
     * Gibt eine Beschreibung des Raums zurück
     * @return
     */
    public String gibLangeBeschreibung() {
        return "Sie sind im " + this.name + ".\n" + this.gibAusgaengeAlsString();
    }

    /**
     * Gibt allse Ausgänge des Raumes zurück
     * @return Ausgänge als String
     */
    private String gibAusgaengeAlsString() {
        String ergebnis = "Ausgänge:";
        Set keys = this.ausgaenge.keySet();

        for(Iterator iter = keys.iterator(); iter.hasNext(); ergebnis = ergebnis + " " + iter.next()) {
        }

        return ergebnis;
    }

    /**
     * gibt den Ausgang zurück
     * @param direction Richtung des Ausgangsraum
     * @return room
     */
    public Room gibAusgang(Direction direction) {
        return this.ausgaenge.get(direction);
    }

    /**
     * Gibt die x-Koordinate zurück
     * @return x-Koordinate
     */
    public int getX() {
        return xCoordinate;
    }

    /**
     * Gibt die y-Koordinate zurück
     * @return y-Koordinate
     */
    public int getY() {
        return yCoordinate;
    }

    /**
     * Setzt die x-Koordinate
     * @param xCoordinate x-Koordinate
     */
    public void setXCoordinate(int xCoordinate) {
        this.xCoordinate = xCoordinate;
    }

    /**
     * Setzt die y-Koordinate
     * @param yCoordinate y-Koordinate
     */
    public void setYCoordinate(int yCoordinate) {
        this.yCoordinate = yCoordinate;
    }

    /**
     * Setzt den Enemy im Raum und den Ausgang, welcher nicht vom Gegner blockiert wird
     * @param pEnemy der Gegner der im Raum gesertz
     * @param freierAusgang Ausgang, welcher nicht vom Gegner blockiert wird
     */
    public void setEnemy(Enemy pEnemy, Direction freierAusgang) {
        this.enemy = pEnemy;
        this.freierAusgang = freierAusgang;
    }

    /**
     * Gibt den Enemy im Raum zurück
     * @return Enemy
     */
    public Enemy getEnemy() {
        return this.enemy;
    }

    /**
     * Gibt den Freien Ausgang zurück
     * @return freierAusgang
     */
    public Direction getFreierAusgang() {
        return this.freierAusgang;
    }

    /**
     * Setzt das Item im raum
     * @param pItem das Item, welches im Raum sein soll
     */
    public void setItem(Item pItem) {
        this.item = pItem;
    }

    /**
     * Gibt das Item im Raum zurück
     * @return item
     */
    public Item getItem() {
        return this.item;
    }
}