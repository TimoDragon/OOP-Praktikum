package Praktikum_1_2;

import java.util.Calendar;
import java.util.ArrayList;

/**
 * Praktikum_1_2.Konto Klasse
 */
public class Konto {
    private static int naechsteKontoNr = 1;
    private final int kontoNr;
    private final Inhaber inhaber;
    private final ArrayList<Transaktion> list = new ArrayList<>();
    private float kontoStand;


    /**
     * Konstruktor für ein Praktikum_1_2.Konto, der nur den Praktikum_1_2.Inhaber nutzt
     * @param inhaber   Praktikum_1_2.Inhaber des Kontos
     */
    public Konto(Inhaber inhaber) {
        this.inhaber = inhaber;
        this.kontoNr = naechsteKontoNr++;
    }

    /**
     * Konstruktor für ein Praktikum_1_2.Konto mit einer ersten Einzahlung
     * @param inhaber       Praktikum_1_2.Inhaber des Kontos
     * @param einzahlung    Die erste Einzahlung
     */
    public Konto(Inhaber inhaber, int einzahlung) throws Exception {
        this(inhaber);
        einzahlen(einzahlung , Calendar.getInstance());
    }

    /**
     * Konstruktor für ein Praktikum_1_2.Konto mit Freundschaftswerbung
     * @param inhaber       Praktikum_1_2.Inhaber des Kontos
     * @param empfaenger    Praktikum_1_2.Konto, welches den "Freunschaftswerbung" Bonus bekommen soll
     */
    public Konto(Inhaber inhaber, Konto empfaenger) {
        this(inhaber);
        try {
            this.einzahlen(30, Calendar.getInstance());
            empfaenger.einzahlen(30, Calendar.getInstance());
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    /**
     * Gibt die Kontonummer zurück
     * @return Kontonummer
     */
    public int getKontoNummer() {
        return this.kontoNr;
    }

    /**
     * Gibt den Kontostand zurück
     * @return  Kontostand
     */
    public float getKontoStand() {
        return this.kontoStand;
    }

    /**
     * Gibt den Praktikum_1_2.Inhaber zurück
     * @return  Praktikum_1_2.Inhaber
     */
    public Inhaber getInhaber() {
        return this.inhaber;
    }

    /**
     * Tätigt eine Einzahlung auf das Praktikum_1_2.Konto
     * @param amount    Der Betrag, der eingezahlt werden soll
     */
    public void einzahlen(float amount, Calendar cal) throws IllegalArgumentException {
        if (amount <= 0) {
            throw new IllegalArgumentException("Betrag darf nicht negativ sein");
        }

        if (cal == null) {
            throw new IllegalArgumentException("Kein Datum angegeben");
        }

        this.kontoStand += amount;
        createTransaktion(amount,cal);
    }

    /**
     * Hebt Geld vom Praktikum_1_2.Konto ab
     * @param amount    Der Betrag, der abgehoben werden soll
     */
    public void abheben(float amount, Calendar cal) throws IllegalArgumentException {
        if (getKontoStand() - amount < 0 ) {
            throw new IllegalArgumentException("Kontostand reicht nicht aus");
        }

        if (cal == null) {
            throw new IllegalArgumentException("Kein Datum angegeben");
        }

        this.kontoStand -= amount;
        createTransaktion(-amount,cal);
    }

    /**
     * Überweist den Betrag auf den angegebenen Empfänger
     * @param empfaenger    das Empfänger Praktikum_1_2.Konto, auf welches überwiesen werden soll
     * @param amount        der Betrag, der vom Praktikum_1_2.Konto abgebucht wird und auf das empfänger Praktikum_1_2.Konto draufgebucht wird
     */
    public void ueberweisen(Konto empfaenger, float amount, Calendar cal) throws IllegalArgumentException {
        abheben(amount,cal);
        empfaenger.einzahlen(amount,cal);
    }

    /**
     * Erstellt eine neue Praktikum_1_2.Transaktion
     * @param pAmount    Der Betrag, der transferiert wird
     * @param  pCal       Das Datum, an dem die Praktikum_1_2.Transaktion stattgefunden hat
     */
    public void createTransaktion(float pAmount, Calendar pCal) {
        Transaktion transaction = new Transaktion( pCal, pAmount);
        if (list.isEmpty()) {
            list.add(transaction);
            return;
        }

        for (int i = list.size() - 1; i >= 0; i--) {
            if (list.get(i).getCal().compareTo(pCal) < 0) {
                list.add(i + 1, transaction);
                return;
            }
        }
    }

    /**
     * Gibt alle Transaktionen bis zu einem bestimmten Datum aus
     * @param pCal Datum
     */
    public void printKontoauszuege(Calendar pCal) {
        System.out.println("-------------------------------------------");
        System.out.println("Kontoauszug für Praktikum_1_2.Konto: " + getKontoNummer());
        System.out.println("-------------------------------------------");
        for (Transaktion transaktion : list) {
            if (pCal == null || pCal.compareTo(transaktion.getCal()) <= 0) {
                System.out.println("Datum: " + transaktion.getCal().getTime() + "\nBetrag: " + transaktion.getAmount());
                System.out.println("---------------------------");
            }
        }
        System.out.println("AKtueller Kontostand: " + getKontoStand());
        System.out.println("-------------------------------------------\n\n");
    }

    public void printKontoauszuege() {
        printKontoauszuege(null);
    }
}
