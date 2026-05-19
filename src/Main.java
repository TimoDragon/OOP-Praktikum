import java.util.Calendar;

public class Main {
    static void main() throws Exception {
        Inhaber i1 = new Inhaber("Timo","Kruse","Straße-1");
        Inhaber i2 = new Inhaber("Kevin","Kröger","Straße-2");

        Konto k1 = new Konto(i1,100);
        Sparkonto s1 = new Sparkonto(i2, 5);

        Calendar c1 = Calendar.getInstance();

        c1.set(Calendar.MONTH, 3);
        k1.abheben(10, c1);
        s1.einzahlen(20, c1);
        s1.zinszahlung(c1);

        Calendar c2 = Calendar.getInstance();
        c2.set(Calendar.MONTH, 7);
        k1.ueberweisen(s1, 30, c2);

        Calendar cal = Calendar.getInstance();
        cal.set(Calendar.MONTH, 5);
        s1.getKontoauszuege(cal);
        k1.getKontoauszuege(cal);


        cal.set(Calendar.YEAR, 2027);
        cal.set(Calendar.MONTH, 11);
        s1.zinszahlung(cal);
        Calendar cal2 = (Calendar) cal.clone();
        cal2.add(Calendar.YEAR, 1);
        s1.zinszahlung(cal2);
        cal2.add(Calendar.DAY_OF_MONTH, -1);
        //s1.zinszahlung(cal2);
        s1.getKontoauszuege(null);
    }
}
