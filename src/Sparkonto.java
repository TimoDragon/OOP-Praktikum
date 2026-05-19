import java.util.Calendar;

public class Sparkonto extends Konto{

    private final float zinssatz;
    private Calendar naechsteZahlung = null;


    public Sparkonto(Inhaber pInhaber, float pZinssatz) {
        super(pInhaber);
        this.zinssatz = pZinssatz;
    }

    public Sparkonto(Inhaber pInhaber, float pZinssatz, int pEinzahlung) throws Exception {
        super(pInhaber,pEinzahlung);
        this.zinssatz = pZinssatz;
    }

    public Sparkonto(Inhaber pInhaber, float pZinssatz, Konto pEmpfaenger) throws Exception{
        super(pInhaber,pEmpfaenger);
        this.zinssatz = pZinssatz;
    }

    public void zinszahlung(Calendar cal) throws Exception {
        if (naechsteZahlung != null && cal.compareTo(naechsteZahlung) < 0){
            System.out.println("Zinszahlung noch nicht möglich \n");
            return;
        }
        setNaechsteZinszahlung(cal);
        float zinszahlung = (this.zinssatz/100) * getKontoStand();
        einzahlen(zinszahlung, cal);
    }

    public Calendar getNaechsteZinszahlung() {
        return naechsteZahlung;
    }

    public void setNaechsteZinszahlung(Calendar cal) {
        naechsteZahlung = (Calendar) cal.clone();
        naechsteZahlung.add(Calendar.YEAR, 1);
    }






}
