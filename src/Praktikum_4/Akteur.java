package Praktikum_4;

import java.util.List;
import java.util.Random;

public abstract class Akteur {
    private Position position;
    private static final Random rand = new Random();

    abstract public void agiere(Feld aktuellesFeld, Feld naechstesFeld, List neueAkteure);

    /**
     * Liefere die Position des Akteurs
     * @return die Position des Akteurs
     */
    public Position gibPosition() {
        return position;
    }

    /**
     * Setze die Position des Akteurs
     * @param zeile die vertikale Koordinate der Position.
     * @param spalte die horizontale Koordinate der Position.
     */
    public void setzePosition(int zeile, int spalte) {
        this.position = new Position(zeile, spalte);
    }

    /**
     * Setze die Position des Akteurs
     * @param position die Position des Akteurs
     */
    public void setzePosition(Position position) {
        this.position = position;
    }

    public static Random getRand() {
        return rand;
    }
}
