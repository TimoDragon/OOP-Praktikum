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






}
