/**
 * Konto Klasse
 */
public class Konto {
    private final int nummer;
    private final Inhaber inhaber;
    private int kontoStand = 0;

    /**
     * Konstruktor für ein Konto, der nur die Nummer und den Inhaber nutzt
     * @param nummer    Kontonummer
     * @param inhaber   Inhaber des Kontos
     */
    public Konto(int nummer, Inhaber inhaber) {
        this.nummer = nummer;
        this.inhaber = inhaber;
    }

    /**
     * Konstruktor für ein Konto mit einer ersten Einzahlung
     * @param nummer        Kontonummer
     * @param inhaber       Inhaber des Kontos
     * @param einzahlung    Die erste Einzahlung
     */
    public Konto(int nummer, Inhaber inhaber, int einzahlung) {
        this(nummer, inhaber);
        einzahlen(einzahlung);
    }

    /**
     * Konstruktor für ein Konto mit Freundschaftswerbung
     * @param nummer        Kontonummer
     * @param inhaber       Inhaber des Kontos
     * @param empfaenger    Konto, welches den "Freunschaftswerbung" Bonus bekommen soll
     */
    public Konto(int nummer, Inhaber inhaber, Konto empfaenger) {
        this(nummer, inhaber);
        empfaenger.einzahlen(60);
    }

    /**
     * Gibt den Kontostand zurück
     * @return  Kontostand
     */
    public int getKontoStand() {
        return this.kontoStand;
    }

    /**
     * Gibt den Inhaber zurück
     * @return  Inhaber
     */
    public Inhaber getInhaber() {
        return this.inhaber;
    }

    /**
     * Tätigt eine Einzahlung auf das Konto
     * @param amount    Der Betrag, der eingezahlt werden soll
     */
    public void einzahlen(int amount) {
        if (amount <= 0) {
            System.out.println("Keine Einzahlung mit: " + amount + " möglich!\n");
            return;
        }
        this.kontoStand += amount;
    }

    /**
     * Hebt Geld vom Konto ab
     * @param amount    Der Betrag, der abgehoben werden soll
     */
    public void abheben(int amount) {
        if (getKontoStand() - amount < 0) {
            System.out.println("Keine Abhebung mit: " + amount + " möglich!\n");
            return;
        }
        this.kontoStand -= amount;
    }

    /**
     * Überweist den Betrag auf den angegebenen Empfänger
     * @param empfaenger das Empfänger Konto, auf welches überwiesen werden soll
     * @param betrag der Betrag, der vom Konto abgebucht wird und auf das empfänger Konto draufgebucht wird
     */
    public void ueberweisen(Konto empfaenger, int betrag) {
        if (getKontoStand() - betrag < 0) {
            System.out.println("Keine Überweisung mit: " + betrag  + " möglich!");
            System.out.printf("Kontostand: " + getKontoStand() + " zu niedrig\n");
            return;
        }

        abheben(betrag);
        empfaenger.einzahlen(betrag);
    }
}
