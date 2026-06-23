package Praktikum_4;

import java.util.List;

public class Jaeger extends Akteur{

    private static final int ANZAHL_RAND_SCHUESSE = 5;

    public Jaeger() {
        super();
    }

    @Override
    public void agiere(Feld aktuellesFeld, Feld naechstesFeld, List neueAkteure) {
        for (int i = 0; i < ANZAHL_RAND_SCHUESSE; i++) {
            Position pos = aktuellesFeld.zufaelligeNachbarposition(this.gibPosition());
            if (aktuellesFeld.gibObjektAn(pos) instanceof Tier tier) {
                tier.setzeGestorben();
            }
        }

        Position neuePosition = naechstesFeld.freieNachbarposition(this.gibPosition());

        if (neuePosition == null) {
            neuePosition = this.gibPosition();
        }

        setzePosition(neuePosition);

        if (aktuellesFeld.gibObjektAn(this.gibPosition()) instanceof Tier tier) {
            tier.setzeGestorben();
        }

        naechstesFeld.platziere(this);
    }
}
