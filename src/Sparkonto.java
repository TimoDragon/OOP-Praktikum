import java.util.Calendar;

public class Sparkonto extends Konto{

    private final float zinssatz;
    private Calendar naechsteZahlung = null;


    /**
     *
     * @param pInhaber
     * @param pZinssatz
     */
    public Sparkonto(Inhaber pInhaber, float pZinssatz) {
        super(pInhaber);
        this.zinssatz = pZinssatz;
    }

    /**
     *
     * @param pInhaber
     * @param pZinssatz
     * @param pEinzahlung
     * @throws Exception
     */
    public Sparkonto(Inhaber pInhaber, float pZinssatz, int pEinzahlung) throws Exception {
        super(pInhaber,pEinzahlung);
        this.zinssatz = pZinssatz;
    }

    /**
     *
     * @param pInhaber
     * @param pZinssatz
     * @param pEmpfaenger
     * @throws Exception
     */
    public Sparkonto(Inhaber pInhaber, float pZinssatz, Konto pEmpfaenger) throws Exception{
        super(pInhaber,pEmpfaenger);
        this.zinssatz = pZinssatz;
    }

    /**
     *
     * @param cal
     * @throws Exception
     */
    public void zinszahlung(Calendar cal) throws Exception {
        if (naechsteZahlung != null && cal.compareTo(naechsteZahlung) < 0){
            throw new IllegalArgumentException("Zinszahlung noch nicht möglich");
        }
        setNaechsteZinszahlung(cal);
        float zinszahlung = (this.zinssatz/100) * getKontoStand();
        einzahlen(zinszahlung, cal);
    }

    /**
     *
     * @return
     */
    public Calendar getNaechsteZinszahlung() {
        return naechsteZahlung;
    }

    /**
     *
     * @param cal
     */
    public void setNaechsteZinszahlung(Calendar cal) {
        naechsteZahlung = (Calendar) cal.clone();
        naechsteZahlung.add(Calendar.YEAR, 1);
    }






}
