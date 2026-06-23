package Praktikum_4;

import java.util.List;

public class Jaeger extends Akteur{

    private static final int ANZAHL_RAND_SCHUESSE = 5;

    private static int kills = 0;

    public Jaeger() {
        super();
    }

    @Override
    public void agiere(Feld aktuellesFeld, Feld naechstesFeld, List neueAkteure) {
        for (int i = 0; i < ANZAHL_RAND_SCHUESSE; i++) {
            Position pos = aktuellesFeld.zufaelligeNachbarposition(this.gibPosition());
            if (aktuellesFeld.gibObjektAn(pos) instanceof Tier tier) {
                tier.setzeGestorben();
                kills++;
            }
        }

        Position neuePosition = naechstesFeld.freieNachbarposition(this.gibPosition());

        if (neuePosition == null) {
            neuePosition = this.gibPosition();
        }

        setzePosition(neuePosition);

        naechstesFeld.platziere(this);
    }

    public int getKills() {
        return kills;
    }
}
