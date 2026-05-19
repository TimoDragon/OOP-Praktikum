import java.util.Calendar;

public class Sparkonto extends Konto{

    private final float zinssatz;
    private Calendar naechsteZahlung = null;


    public Sparkonto(Inhaber pInhaber, float pZinssatz) {
        this.zinssatz = pZinssatz;
        super(pInhaber);
    }

    public Sparkonto(Inhaber pInhaber, float pZinssatz, int pEinzahlung) throws Exception {
        this.zinssatz = pZinssatz;
        super(pInhaber,pEinzahlung);
    }

    public Sparkonto(Inhaber pInhaber, float pZinssatz, Konto pEmpfaenger) throws Exception{
        this.zinssatz = pZinssatz;
        super(pInhaber,pEmpfaenger);
    }






}
