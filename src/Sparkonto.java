import java.util.Calendar;

public class Sparkonto extends Konto{

    private final float zinssatz;
    private Calendar naechsteZahlung = null;


    /**
     * Konstruktor für ein Sparkonto der den Inhaber und Zinssatz nutzt
     * @param pInhaber  der Inhaber des Sparkontos
     * @param pZinssatz der Zinssatz des Sparkontos
     */
    public Sparkonto(Inhaber pInhaber, float pZinssatz) {
        super(pInhaber);
        this.zinssatz = pZinssatz;
    }

    /**
     * Konstruktor für ein Sparkonto der den Inhaber und Zinssatz nutzt und eine Einzahlung auf das Sparkonto tätigt
     * @param pInhaber der Inhaber des Sparkontos
     * @param pZinssatz der Zinssatz des Sparkontos
     * @param pEinzahlung die Einzahlung auf das Konto
     * @throws Exception
     */
    public Sparkonto(Inhaber pInhaber, float pZinssatz, int pEinzahlung) throws Exception {
        super(pInhaber,pEinzahlung);
        einzahlen(pEinzahlung, Calendar.getInstance());
        this.zinssatz = pZinssatz;
    }

    /**
     * Konstruktor für ein Konto mit Freundschaftswerbung
     * @param pInhaber inhaber des Kontos
     * @param pZinssatz zinssatz
     * @param pEmpfaenger Empfänger, der den Freundschaftsbonus erhällt
     * @throws Exception
     */
    public Sparkonto(Inhaber pInhaber, float pZinssatz, Konto pEmpfaenger) throws IllegalArgumentException{
        super(pInhaber,pEmpfaenger);
        this.zinssatz = pZinssatz;
        try {
            this.einzahlen(30, Calendar.getInstance());
            pEmpfaenger.einzahlen(30, Calendar.getInstance());
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    /**
     * Funktion für die Zinszahlung auf ein Sparkonto
     * @param cal Datum an dem die Zinszahlung stattfindet
     * @throws Exception
     */
    public void zinszahlung(Calendar cal) throws IllegalArgumentException {
        if (naechsteZahlung != null && cal.compareTo(naechsteZahlung) < 0){
            throw new IllegalArgumentException("Zinszahlung noch nicht möglich");
        }
        setNaechsteZinszahlung(cal);
        float zinszahlung = (this.zinssatz/100) * getKontoStand();
        einzahlen(zinszahlung, cal);
    }

    /**
     * Getter für die nächste Zinszahlung
     * @return nächsteZahlung
     */
    public Calendar getNaechsteZinszahlung() {
        return naechsteZahlung;
    }

    /**
     * Setter für die nächste Zinszahlung
     * @param cal Datum
     */
    public void setNaechsteZinszahlung(Calendar cal) {
        naechsteZahlung = (Calendar) cal.clone();
        naechsteZahlung.add(Calendar.YEAR, 1);
    }
}
