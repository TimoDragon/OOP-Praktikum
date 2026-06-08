package Praktikum_3.map;

import Praktikum_3.enemy.Enemy;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Set;

public class Room {
    private final String name;
    private HashMap<Direction, Room> ausgaenge = new HashMap<>();
    private Enemy enemy;
    private int yCoordinate;
    private int xCoordinate;


    /**
     *
     * @param name
     */
    public Room(String name) {
        this.name = name;
    }

    /**
     *
     * @param beschreibung
     * @param y
     * @param x
     */
    public Room(String beschreibung, int y, int x) {
        this.name = beschreibung;
        this.xCoordinate = x;
        this.yCoordinate = y;
    }

    public String getName() {
        return this.name;
    }

    /**
     *
     * @param direction
     * @param nachbar
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
     *
     * @return
     */
    public String gibKurzbeschreibung() {
        return this.name;
    }

    /**
     *
     * @return
     */
    public String gibLangeBeschreibung() {
        return "Sie sind im " + this.name + ".\n" + this.gibAusgaengeAlsString();
    }

    /**
     *
     * @return
     */
    private String gibAusgaengeAlsString() {
        String ergebnis = "Ausgänge:";
        Set keys = this.ausgaenge.keySet();

        for(Iterator iter = keys.iterator(); iter.hasNext(); ergebnis = ergebnis + " " + iter.next()) {
        }

        return ergebnis;
    }

    /**
     *
     * @param direction
     * @return
     */
    public Room gibAusgang(Direction direction) {
        return this.ausgaenge.get(direction);
    }

    public int getX() {
        return xCoordinate;
    }

    public int getY() {
        return yCoordinate;
    }

    public void setXCoordinate(int xCoordinate) {
        this.xCoordinate = xCoordinate;
    }

    public void setYCoordinate(int yCoordinate) {
        this.yCoordinate = yCoordinate;
    }

    public void setEnemy(Enemy pEnemy) {
        this.enemy = pEnemy;
    }

    public Enemy getEnemy() {
        return this.enemy;
    }
}