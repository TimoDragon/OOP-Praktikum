package Praktikum_4;

/**
 * Objekte dieser Klasse repr�sentieren 
 * Positionen in einem rechteckigen Feld.
 * 
 * @author David J. Barnes and Michael Kolling
 * @version 2002-04-09
 */
public class Position {
    // Zeilen- und Spaltenposition.
    private int zeile;
    private int spalte;

    /**
     * Repr�sentiere eine Zeile und eine Spalte.
     * @param zeile die Zeile.
     * @param spalte die Spalte.
     */
    public Position(int zeile, int spalte)
    {
        this.zeile = zeile;
        this.spalte = spalte;
    }
    
    /**
     * Pr�fung auf Datengleichheit.
     */
    public boolean equals(Object obj)
    {
        if(obj instanceof Position) {
            Position anderePosition = (Position) obj;
            return zeile == anderePosition.gibZeile()
                && spalte == anderePosition.gibSpalte();
        }
        else {
            return false;
        }
    }
    
    /**
     * Liefere einen String in der Form 'Zeile,Spalte'
     * @return eine Stringdarstellung dieser Position.
     */
    public String toString()
    {
        return zeile + "," + spalte;
    }
    
    /**
     * Benutze die 16 h�herwertigen Bits f�r den den Zeilenwert
     * und die 16 niederwertigen Bits f�r den Spaltenwert.
     * Au�er f�r sehr gro�e Felder sollte dies einen eindeutigen
     * Hashwert f�r jedes Zeile-Spalte-Paar geben.
     */
    public int hashCode()
    {
        return (zeile << 16) + spalte;
    }
    
    /**
     * @return Die Zeile.
     */
    public int gibZeile()
    {
        return zeile;
    }
    
    /**
     * @return Die Spalte.
     */
    public int gibSpalte()
    {
        return spalte;
    }
}
