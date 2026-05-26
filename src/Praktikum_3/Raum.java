package Praktikum_3;

//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by Fernflower decompiler)
//

import java.util.HashMap;
import java.util.Iterator;
import java.util.Set;

class Raum {
    private String beschreibung;
    private HashMap ausgaenge;

    public Raum(String beschreibung) {
        this.beschreibung = beschreibung;
        this.ausgaenge = new HashMap();
    }

    public void setzeAusgang(String richtung, Raum nachbar) {
        this.ausgaenge.put(richtung, nachbar);
    }

    public String gibKurzbeschreibung() {
        return this.beschreibung;
    }

    public String gibLangeBeschreibung() {
        return "Sie sind " + this.beschreibung + ".\n" + this.gibAusgaengeAlsString();
    }

    private String gibAusgaengeAlsString() {
        String ergebnis = "Ausgänge:";
        Set keys = this.ausgaenge.keySet();

        for(Iterator iter = keys.iterator(); iter.hasNext(); ergebnis = ergebnis + " " + iter.next()) {
        }

        return ergebnis;
    }

    public Raum gibAusgang(String richtung) {
        return (Raum)this.ausgaenge.get(richtung);
    }
}