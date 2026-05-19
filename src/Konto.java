import java.util.Calendar;
import java.util.ArrayList;

/**
 * Konto Klasse
 */
public class Konto {
    private static int naechsteKontoNR = 1;
    private final int kontoNR;
    private final Inhaber inhaber;
    private float kontoStand;
    private final ArrayList<Transaktion> List = new ArrayList<>();

    /**
     * Konstruktor für ein Konto, der nur die Nummer und den Inhaber nutzt
     * @param inhaber   Inhaber des Kontos
     */
    public Konto(Inhaber inhaber) {
        this.inhaber = inhaber;
        this.kontoNR = naechsteKontoNR++;
    }

    /**
     * Konstruktor für ein Konto mit einer ersten Einzahlung
     * @param inhaber       Inhaber des Kontos
     * @param einzahlung    Die erste Einzahlung
     */
    public Konto(Inhaber inhaber, int einzahlung) throws Exception {
        this(inhaber);
        einzahlen(einzahlung , Calendar.getInstance());
    }

    /**
     * Konstruktor für ein Konto mit Freundschaftswerbung
     * @param inhaber       Inhaber des Kontos
     * @param empfaenger    Konto, welches den "Freunschaftswerbung" Bonus bekommen soll
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
        return this.kontoNR;
    }

    /**
     * Gibt den Kontostand zurück
     * @return  Kontostand
     */
    public float getKontoStand() {
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
    public void einzahlen(float amount, Calendar cal) throws Exception {
        if (amount <= 0) {
            throw new Exception("Betrag darf nicht negativ sein");
        }
        this.kontoStand += amount;
        transaktion(amount,cal);
    }

    /**
     * Hebt Geld vom Konto ab
     * @param amount    Der Betrag, der abgehoben werden soll
     */
    public void abheben(float amount, Calendar cal) throws Exception {
        if (getKontoStand() - amount < 0) {
            throw new Exception("Kontostand reicht nicht aus");
        }
        this.kontoStand -= amount;
        transaktion(amount,cal);
    }

    /**
     * Überweist den Betrag auf den angegebenen Empfänger
     * @param empfaenger    das Empfänger Konto, auf welches überwiesen werden soll
     * @param amount        der Betrag, der vom Konto abgebucht wird und auf das empfänger Konto draufgebucht wird
     */
    public void ueberweisen(Konto empfaenger, float amount, Calendar cal) throws Exception {
        abheben(amount,cal);
        empfaenger.einzahlen(amount,cal);
    }

    /**
     * Erstellt eine neue Transaktion
     * @param amount    Der Betrag, der transferiert wird
     * @param cal       Das Datum, an dem die Transaktion stattgefunden hat
     */
    public void transaktion(float amount, Calendar cal) {
        Transaktion transaction = new Transaktion(cal, amount);
        List.add(transaction);
    }

    public void getKontoauszuege(Calendar cal){
        System.out.println("-------------------------------------------");
        System.out.println("Kontoauszug für Konto: " + getKontoNummer());
        System.out.println("-------------------------------------------");
        for(Transaktion transaktion : List) {
            if (cal == null || cal.compareTo(transaktion.getCal()) <= 0) {
                System.out.println("Datum: " + transaktion.getCal().getTime() + "\nBetrag: " + transaktion.getAmount());
                System.out.println("---------------------------");
            }
        }
        System.out.println("AKtueller Kontostand: " + getKontoStand());
    }
}
