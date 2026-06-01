package Praktikum_3;

//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by Fernflower decompiler)
//

import java.util.HashMap;
import java.util.Iterator;
import java.util.Set;

class Room {
    private String beschreibung;
    private HashMap ausgaenge;
    private Enemy enemy;
    private int yCoordinate;
    private int xCoordinate;


    /**
     *
     * @param beschreibung
     */
    public Room(String beschreibung) {
        this.beschreibung = beschreibung;
        this.ausgaenge = new HashMap();
    }

    /**
     *
     * @param beschreibung
     * @param y
     * @param x
     */
    public Room(String beschreibung, int y, int x) {
        this.beschreibung = beschreibung;
        this.ausgaenge = new HashMap();
        this.xCoordinate = x;
        this.yCoordinate = y;
    }

    /**
     *
     * @param richtung
     * @param nachbar
     */
    public void setzeAusgang(String richtung, Room nachbar) {
        switch (richtung) {
            case "north":
                nachbar.setXCoordinate(this.xCoordinate);
                nachbar.setYCoordinate(this.yCoordinate + 1);
                break;

            case "south":
                nachbar.setXCoordinate(this.xCoordinate);
                nachbar.setYCoordinate(this.yCoordinate - 1);
                break;

            case "west":
                nachbar.setXCoordinate(this.xCoordinate - 1);
                nachbar.setYCoordinate(this.yCoordinate);
                break;

            case "east":
                nachbar.setXCoordinate(this.xCoordinate + 1);
                nachbar.setYCoordinate(this.yCoordinate);
                break;
        }

        this.ausgaenge.put(richtung, nachbar);
    }


    /**
     *
     * @return
     */
    public String gibKurzbeschreibung() {
        return this.beschreibung;
    }

    /**
     *
     * @return
     */
    public String gibLangeBeschreibung() {
        return "Sie sind " + this.beschreibung + ".\n" + this.gibAusgaengeAlsString();
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
     * @param richtung
     * @return
     */
    public Room gibAusgang(String richtung) {
        return (Room)this.ausgaenge.get(richtung);
    }

    public int getXCoordinate() {
        return xCoordinate;
    }

    public int getYCoordinate() {
        return yCoordinate;
    }

    public void setXCoordinate(int xCoordinate) {
        this.xCoordinate = xCoordinate;
    }

    public void setYCoordinate(int yCoordinate) {
        this.yCoordinate = yCoordinate;
    }
}