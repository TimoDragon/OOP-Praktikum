package Praktikum_4;

import java.util.HashMap;
import java.util.Iterator;

/**
 * Diese Klasse sammelt und liefert statistische Daten �ber den
 * Zustand eines Feldes. Auf sehr flexible Weise: Es wird ein
 * Z�hler angelegt und gepflegt f�r jede Objektklasse, die im
 * Feld gefunden wird.
 * 
 * @author David J. Barnes and Michael Kolling
 * @version 2003-04-12
 */
public class FeldStatistik
{
    // Die Z�hler f�r die jeweiligen Akteurstypen (Fuchs, Hase, etc.)
    // in der Simulation.
    private HashMap zaehler;
    // Sind die Z�hlerst�nde momentan aktuell?
    private boolean zaehlerAktuell;

    /**
     * Erzeuge ein Objekt f�r die Feldstatistik.
     */
    public FeldStatistik()
    {
        // Wir legen eine Sammlung f�r die Z�hler an, die wir f�r
        // die gefundenen Tierarten erzeugen.
        zaehler = new HashMap();
        zaehlerAktuell = true;
    }

    /**
     * @return Eine Beschreibung, welche Tiere das
     *          Feld bev�lkern.
     */
    public String gibBewohnerInfo(Feld feld)
    {
        StringBuffer buffer = new StringBuffer();
        if(!zaehlerAktuell) {
            gibZaehlerstaende(feld);
        }
        Iterator schluessel = zaehler.keySet().iterator();
        while(schluessel.hasNext()) {
            Zaehler info = (Zaehler) zaehler.get(schluessel.next());
            buffer.append(info.gibName());
            buffer.append(": ");
            buffer.append(info.gibStand());
            buffer.append(' ');
        }
        return buffer.toString();
    }
    
    /**
     * Verwerfe alle bisher gesammelten Daten; setze alle Z�hler
     * auf Null zur�ck.
     */
    public void zuruecksetzen()
    {
        zaehlerAktuell = false;
        Iterator schluessel = zaehler.keySet().iterator();
        while(schluessel.hasNext()) {
            Zaehler z = (Zaehler) zaehler.get(schluessel.next());
            z.zuruecksetzen();
        }
    }

    /**
     * Erh�he den Z�hler f�r eine Tierklasse.
     */
    public void erhoeheZaehler(Class tierklasse)
    {
        Zaehler z = (Zaehler) zaehler.get(tierklasse);
        if(z == null) {
            // Wir haben noch keinen Z�hler f�r
            // diese Spezies - also neu anlegen
            z = new Zaehler(tierklasse.getName());
            zaehler.put(tierklasse, z);
        }
        z.erhoehen();
    }

    /**
     * Signalisiere, dass eine Tierz�hlung beendet ist.
     */
    public void zaehlungBeendet()
    {
        zaehlerAktuell = true;
    }

    /**
     * Stelle fest, ob die Simulation noch aktiv ist, also
     * ob sie weiterhin laufen sollte.
     * @return true wenn noch mehr als eine Spezies lebt.
     */
    public boolean istAktiv(Feld feld)
    {
        // Wieviele Z�hler sind nicht Null.
        int nichtNull = 0;
        if(!zaehlerAktuell) {
            gibZaehlerstaende(feld);
        }
        Iterator schluessel = zaehler.keySet().iterator();
        while(schluessel.hasNext()) {
            Zaehler info = (Zaehler) zaehler.get(schluessel.next());
            if(info.gibStand() > 0) {
                nichtNull++;
            }
        }
        return nichtNull > 1;
    }
    
    /**
     * Erzeuge Z�hler f�r die Anzahl der F�chse und Hasen.
     * Diese werden nicht st�ndig aktuell gehalten, w�hrend
     * F�chse und Hasen in das Feld gesetzt werden, sondern
     * jeweils bei der Abfrage der Z�hlerst�nde berechnet.
     */
    private void gibZaehlerstaende(Feld feld)
    {
        zuruecksetzen();
        for(int zeile = 0; zeile < feld.gibTiefe(); zeile++) {
            for(int spalte = 0; spalte < feld.gibBreite(); spalte++) {
                Object tier = feld.gibObjektAn(zeile, spalte);
                if(tier != null) {
                    erhoeheZaehler(tier.getClass());
                }
            }
        }
        zaehlerAktuell = true;
    }
}
